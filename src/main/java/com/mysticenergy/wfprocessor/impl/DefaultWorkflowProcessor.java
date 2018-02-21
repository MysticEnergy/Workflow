package com.mysticenergy.wfprocessor.impl;

import com.alibaba.fastjson.JSONObject;
import com.mysticenergy.common.exception.WfBaseException;
import com.mysticenergy.common.exception.WfInternalException;
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

import javax.management.relation.Relation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

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
            return null;
        }

        for (NodeProcessor nodeProcessor : nodeProcessorList) {
            if (nodeProcessor.isSupport(nodeType)) {
                return nodeProcessor;
            }
        }

        return null;
    }

    @Override
    public void execute(WorkflowProcessorDTO workflowProcessorDTO) {
        Workflow wf = workflowProcessorDTO.getWorkflow();
        UserInfo userInfo = workflowProcessorDTO.getUserInfo();
        List<Node> nodes =  wf.getNodes();
        Node root = null;
        for(Node node : nodes){
            if(node.getPreNum().equals(0)){
                root = node;
                break;
            }
        }
        if (root == null){
            throw new RuntimeException("该流程无根节点");
        }

        String url = "https://api.seniverse.com/v3/weather/now.json?key={key}&location={location}";
        Map<String,String> map = new HashMap<>();
        map.put("key","auvelrhcvsizxt9k");
        map.put("location","beijing");
        String method = "get";
        JSONObject object = apiClent.getJson(url,map,method);

        NodeProcessorDTO nodeProcessorDTO = new NodeProcessorDTO();
        nodeProcessorDTO.setNode(root).setData(object).setStatus(true);
        List<Node.Relation> relations = root.getRelations();

        while (relations!=null){
            List<Node> executeNode = new ArrayList<>();
            for (Node.Relation relation : relations){
                String nodeId = relation.getTo();
                for (Node node : nodes){
                    if(node.get_id().equals(nodeId)) {
                        executeNode.add(node);
                    }
                }
                relations = executeNode.get(0).relations;
            }

        }
    }
}
