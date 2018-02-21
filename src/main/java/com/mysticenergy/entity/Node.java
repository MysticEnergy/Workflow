package com.mysticenergy.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Name: Node
 * Desc: 流程节点数据结构
 *
 * @Author: wasmir
 * @Date 2018/2/20
 */
public class Node implements Serializable {

    private static final long serialVersionUID = -266979976081873188L;
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
     * （normal,logic,notify）
     */
    public String type;

    /**
     * 节点代码
     * 对应不同的类型拥有不同的代码
     * 对于normal节点，为java代码段
     * 对于logic节点，为ENUM，eg: AND,OR
     * 对于notify节点，为ENUM，eg：telegram
     */
    public String code;

    /**
     * 指向该节点的relation数量
     */
    public int preNum;

    /**
     * 该节点指出的relation列表
     */
    public List<Relation> relations;

    public String get_id() {
        return _id;
    }

    public Node set_id(String _id) {
        this._id = _id;
        return this;
    }

    public String getNodeName() {
        return nodeName;
    }

    public Node setNodeName(String nodeName) {
        this.nodeName = nodeName;
        return this;
    }

    public String getType() {
        return type;
    }

    public Node setType(String type) {
        this.type = type;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Node setCode(String code) {
        this.code = code;
        return this;
    }

    public int getPreNum() {
        return preNum;
    }

    public Node setPreNum(int preNum) {
        this.preNum = preNum;
        return this;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public Node setRelations(List<Relation> relations) {
        this.relations = relations;
        return this;
    }

    public static class Relation implements Serializable {

        private static final long serialVersionUID = -7734802865746082556L;
        /**
         * 指向的节点id
         */
        public String to;

        /**
         * 该relation生效时，节点的值
         */
        public boolean result;

        public String getTo() {
            return to;
        }

        public Relation setTo(String to) {
            this.to = to;
            return this;
        }

        public boolean getResult() {
            return result;
        }

        public Relation setResult(boolean result) {
            this.result = result;
            return this;
        }
    }
}
