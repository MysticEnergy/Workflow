package com.mysticenergy.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Name: UserInfo
 * Desc: 用户信息数据结构
 *
 * @Author: wasmir
 * @Date 2018/2/20
 */
public class UserInfo implements Serializable{

    private static final long serialVersionUID = 3793461291749105725L;

    /**
     * 用户信息表id
     */
    public String _id;

    /**
     * 用户名
     */
    public String userName;

    /**
     * 用户所拥有的流程
     *  拥有 -> 创建者/使用者
     */
    public String wfIds;

    /**
     * 用户所绑定的通知方法
     */
    public List<Bound> bounds;

    static class Bound implements Serializable{

        private static final long serialVersionUID = 8358807743944487637L;

        /**
         * 绑定的类型
         *  eg:telegram
         */
        public String type;

        /**
         * 该类型对应的id
         */
        public String key;
    }
}
