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
public class UserInfo implements Serializable {

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
     * 拥有 -> 创建者/使用者
     */
    public String wfIds;

    /**
     * 用户所绑定的通知方法
     */
    public List<Bound> bounds;

    public String get_id() {
        return _id;
    }

    public UserInfo set_id(String _id) {
        this._id = _id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserInfo setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getWfIds() {
        return wfIds;
    }

    public UserInfo setWfIds(String wfIds) {
        this.wfIds = wfIds;
        return this;
    }

    public List<Bound> getBounds() {
        return bounds;
    }

    public UserInfo setBounds(List<Bound> bounds) {
        this.bounds = bounds;
        return this;
    }

    public static class Bound implements Serializable {

        private static final long serialVersionUID = 8358807743944487637L;

        /**
         * 绑定的类型
         * eg:telegram
         */
        public String type;

        /**
         * 该类型对应的id
         */
        public String key;

        public String getType() {
            return type;
        }

        public Bound setType(String type) {
            this.type = type;
            return this;
        }

        public String getKey() {
            return key;
        }

        public Bound setKey(String key) {
            this.key = key;
            return this;
        }
    }
}
