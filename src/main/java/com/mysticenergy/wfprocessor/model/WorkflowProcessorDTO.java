package com.mysticenergy.wfprocessor.model;

import com.mysticenergy.entity.UserInfo;
import com.mysticenergy.entity.Workflow;

/**
 * Created by 书生 on 2018/2/21.
 */
public class WorkflowProcessorDTO {

    private Workflow workflow;

    private UserInfo userInfo;

    public Workflow getWorkflow() {
        return workflow;
    }

    public WorkflowProcessorDTO setWorkflow(Workflow workflow) {
        this.workflow = workflow;
        return this;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public WorkflowProcessorDTO setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
        return this;
    }

    @Override
    public String toString() {
        return "WorkflowProcessorDTO{" +
                "workflow=" + workflow +
                ", userInfo=" + userInfo +
                '}';
    }
}
