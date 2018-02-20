package com.mysticenergy.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Name: Workflow
 * Desc: 流程数据结构
 *
 * @Author: wasmir
 * @Date 2018/2/20
 */
public class Workflow implements Serializable{

    private static final long serialVersionUID = 4872106986832735628L;
    /**
     * 流程ID
     */
    public String _id;

    /**
     * 流程名
     */
    public String wfName;

    /**
     * 流程所拥有的节点列表
     */
    public List<Node> nodes;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getWfName() {
        return wfName;
    }

    public void setWfName(String wfName) {
        this.wfName = wfName;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }
}
