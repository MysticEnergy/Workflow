package com.mysticenergy.wfprocessor;

import com.mysticenergy.entity.Workflow;
import com.mysticenergy.wfprocessor.model.WorkflowProcessorDTO;

/**
 * Created by 书生 on 2018/2/21.
 */
public interface WorkflowProcessor {

    void execute(WorkflowProcessorDTO workflowProcessorDTO);

}
