package com.mysticenergy.entity;

import java.util.List;

/**
 * Name: Node
 * Desc: 流程节点数据结构
 *
 * @Author: wasmir
 * @Date 2018/2/20
 */
public class Node {

    /**
     * 节点ID
     */
    public String _id;

    /**
     * 节点名
     */
    public String nodeName;

    /**
     * 节点类型
     *  （normal,logic,notify）
     */
    public String type;

    /**
     * 节点代码
     *  对应不同的类型拥有不同的代码
     *  对于normal节点，为java代码段
     *  对于logic节点，为ENUM，eg: AND,OR
     *  对于notify节点，为ENUM，eg：telegram
     */
    public String code;

    /**
     * 指向该节点的relation数量
     */
    public String preNum;

    /**
     * 该节点指出的relation列表
     */
    public List<Relation> relations;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPreNum() {
        return preNum;
    }

    public void setPreNum(String preNum) {
        this.preNum = preNum;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }

    static class Relation{

        /**
         * 指向的节点id
         */
        public String to;

        /**
         * 该relation生效时，节点的值
         */
        public String result;

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}
