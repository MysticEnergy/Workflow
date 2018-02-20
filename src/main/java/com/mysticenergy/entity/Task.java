package com.mysticenergy.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Name: Task
 * Desc: 任务数据结构
 *
 * @Author: wasmir
 * @Date 2018/2/20
 */
public class Task implements Serializable{

    private static final long serialVersionUID = 4327921116243685231L;
    /**
     * 任务ID
     */
    public String _id;

    /**
     * 任务对应的流程ID，只对应一个
     */
    public String wfId;

    /**
     * 任务对应的cron表达式
     */
    public String cronExpress;

    /**
     * 任务对应的用户Id
     */
    public String userId;

    /**
     * 该任务所选择的提醒类型，目前只可选择一个
     */
    public List<String> notifyTypes;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getWfId() {
        return wfId;
    }

    public void setWfId(String wfId) {
        this.wfId = wfId;
    }

    public String getCronExpress() {
        return cronExpress;
    }

    public void setCronExpress(String cronExpress) {
        this.cronExpress = cronExpress;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getNotifyTypes() {
        return notifyTypes;
    }

    public void setNotifyTypes(List<String> notifyTypes) {
        this.notifyTypes = notifyTypes;
    }
}
