package com.mysticenergy.constant;

/**
 * Name: NodeType
 * Desc:
 *
 * @Author: wasmir
 * @Date 2018/2/20
 */
public enum NodeType {
    NORMAL("normal"),
    LOGIC("logic"),
    NOTIFY("notify");

    String name;

    NodeType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equal(String name) {
        return this.name.equals(name);
    }

}
