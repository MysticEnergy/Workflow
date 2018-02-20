package com.mysticenergy.notify.model;

/**
 * 通知数据传输类
 * Created by 书生 on 2018/2/20.
 */
public class NotifyDTO {

    private String userId;

    private String message;

    public String getUserId() {
        return userId;
    }

    public NotifyDTO setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public NotifyDTO setMessage(String message) {
        this.message = message;
        return this;
    }
}
