package com.mysticenergy.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Name: UserInfo
 * Desc:
 *
 * @Author: wasmir
 * @Date 2018/2/20
 */
public class UserInfo implements Serializable{

    private static final long serialVersionUID = 3793461291749105725L;

    public String _id;

    public String userName;

    public String wfIds;

    public List<Bound> bounds;

    static class Bound implements Serializable{

        private static final long serialVersionUID = 8358807743944487637L;

        public String type;

        public String key;
    }
}
