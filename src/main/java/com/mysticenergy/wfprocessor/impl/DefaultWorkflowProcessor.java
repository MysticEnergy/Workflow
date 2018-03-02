package com.mysticenergy.wfprocessor.impl;

import com.alibaba.fastjson.JSONObject;
import com.mysticenergy.common.exception.ExceptionKeyConstant;
import com.mysticenergy.common.exception.WfBaseException;
import com.mysticenergy.entity.Node;
import com.mysticenergy.entity.UserInfo;
import com.mysticenergy.entity.Workflow;
import com.mysticenergy.service.ApiClent;
import com.mysticenergy.wfprocessor.WorkflowProcessor;
import com.mysticenergy.wfprocessor.model.NodeProcessorDTO;
import com.mysticenergy.wfprocessor.model.WorkflowProcessorDTO;
import com.mysticenergy.wfprocessor.nodeprocessor.NodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

/**
 * Created by 书生 on 2018/2/21.
 */
@Service
public class DefaultWorkflowProcessor implements WorkflowProcessor {

    @Autowired
    private ApiClent apiClent;

    @Autowired(required = false)
    private List<NodeProcessor> nodeProcessorList;

    protected NodeProcessor getProcessor(String nodeType) {
        if (CollectionUtils.isEmpty(nodeProcessorList)) {
            throw new WfBaseException(ExceptionKeyConstant.Workflow.NODE_TYPE_NOT_FOUND);
        }

        for (NodeProcessor nodeProcessor : nodeProcessorList) {
            if (nodeProcessor.isSupport(nodeType)) {
                return nodeProcessor;
            }
        }

        throw new WfBaseException(ExceptionKeyConstant.Workflow.NODE_TYPE_NOT_FOUND);
    }

    protected JSONObject init() {
        String url = "https://api.seniverse.com/v3/weather/now.json?key={key}&location={location}";
        Map<String, String> map = new HashMap<>();
        map.put("key", "auvelrhcvsizxt9k");
        map.put("location", "beijing");
        String method = "get";
        return apiClent.getJson(url, map, method);
    }

    protected List<Node> getRoots(Workflow wf) {
        List<Node> nodes = wf.getNodes();
        List<Node> roots = nodes.stream().filter(e -> Objects.equals(e.getPreNum(), 0)).collect(Collectors.toList());
        if (Objects.isNull(roots)) {
            throw new WfBaseException(ExceptionKeyConstant.Workflow.ROOT_NODE_NOT_FOUND);
        }
        return roots;
    }

    protected List<Node> getTos(Node current, boolean status, List<Node> nodeList) {
        List<Node.Relation> relations = current.getRelations();

        if (CollectionUtils.isEmpty(relations) || CollectionUtils.isEmpty(nodeList)) {
            return Collections.emptyList();
        }

        return relations.stream().map(relation -> {
            if (relation.getResult() != status) {
                return null;
            }

            String nodeId = relation.getTo();
            for (Node node : nodeList) {
                if (Objects.equals(nodeId, node.get_id())) {
                    return node;
                }
            }

            return null;
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    @Override
    public void execute(WorkflowProcessorDTO workflowProcessorDTO) {
        UserInfo userInfo = workflowProcessorDTO.getUserInfo();
        List<Node> nodeList = workflowProcessorDTO.getWorkflow().getNodes();
        Map<String, NodeProcessorDTO> nodeProcessorDTOMap = new HashMap<>();
        Queue<Node> taskQueue = new ConcurrentLinkedQueue<>();

        List<Node> roots = getRoots(workflowProcessorDTO.getWorkflow());
        roots.forEach(e -> {
            NodeProcessorDTO nodeProcessorDTO = new NodeProcessorDTO()
                    .setNode(e)
                    .setData(init())
                    .setStatus(true)
                    .setUserInfo(userInfo);
            nodeProcessorDTOMap.put(e.get_id(), nodeProcessorDTO);
            taskQueue.add(e);
        });

        while (!taskQueue.isEmpty()) {

            Node task = taskQueue.poll();

            NodeProcessorDTO retDTO = getProcessor(task.getType()).execute(nodeProcessorDTOMap.get(task.get_id()));

            List<Node> relationNodes = getTos(task, retDTO.getStatus(), nodeList);

            if (CollectionUtils.isEmpty(relationNodes)) {
                continue;
            }

            relationNodes.forEach(relationNode -> {
                taskQueue.add(relationNode);
                retDTO.setNode(relationNode);
                nodeProcessorDTOMap.put(relationNode.get_id(), retDTO);
            });

        }

    }

}
