package com.mysticenergy.wfprocessor.impl;

import com.mysticenergy.common.exception.WfBaseException;
import com.mysticenergy.common.exception.WfInternalException;
import com.mysticenergy.entity.Workflow;
import com.mysticenergy.wfprocessor.WorkflowProcessor;
import com.mysticenergy.wfprocessor.model.WorkflowProcessorDTO;
import com.mysticenergy.wfprocessor.nodeprocessor.NodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by 书生 on 2018/2/21.
 */
@Service
public class DefaultWorkflowProcessor implements WorkflowProcessor {

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
    }
}
