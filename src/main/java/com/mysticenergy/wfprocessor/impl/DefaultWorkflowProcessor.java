package com.mysticenergy.wfprocessor.impl;

import com.mysticenergy.entity.Workflow;
import com.mysticenergy.wfprocessor.WorkflowProcessor;
import com.mysticenergy.wfprocessor.nodeprocessor.NodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by 书生 on 2018/2/21.
 */
@Service
public class DefaultWorkflowProcessor implements WorkflowProcessor {

    @Autowired(required = false)
    private List<NodeProcessor> nodeProcessorList;

    @Override
    public void execute(Workflow workflow) {

    }

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

}
