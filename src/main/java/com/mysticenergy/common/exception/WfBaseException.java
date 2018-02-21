package com.mysticenergy.common.exception;

/**
 * 流程异常基类
 * Created by 书生 on 2018/2/21.
 */
public class WfBaseException extends RuntimeException {

    private String key;

    public WfBaseException(String key, String message, Throwable cause) {
        super(message, cause);
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public WfBaseException setKey(String key) {
        this.key = key;
        return this;
    }
}
