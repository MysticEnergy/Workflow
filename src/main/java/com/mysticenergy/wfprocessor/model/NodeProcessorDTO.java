package com.mysticenergy.wfprocessor.model;

import com.alibaba.fastjson.JSONObject;
import com.mysticenergy.entity.Node;

/**
 * 节点执行类数据传输对象
 * Created by 书生 on 2018/2/21.
 */
public class NodeProcessorDTO {

    /**
     * 当前任务节点
     */
    private Node node;

    /**
     * 节点数据
     */
    private JSONObject data;

    /**
     * 节点产生的结果
     */
    private boolean status;

    public Node getNode() {
        return node;
    }

    public NodeProcessorDTO setNode(Node node) {
        this.node = node;
        return this;
    }

    public JSONObject getData() {
        return data;
    }

    public NodeProcessorDTO setData(JSONObject data) {
        this.data = data;
        return this;
    }

    public boolean isStatus() {
        return status;
    }

    public NodeProcessorDTO setStatus(boolean status) {
        this.status = status;
        return this;
    }
}
