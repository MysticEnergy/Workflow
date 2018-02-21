package com.mysticenergy.constant;

/**
 * Name: NotifyType
 * Desc:
 *
 * @Author: wasmir
 * @Date 2018/2/20
 */
public enum NotifyType {
    TELEGRAM("telegram"),
    QQ("qq"),
    WX("wx");

    private String name;

    NotifyType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equal(String notifyType) {
        return this.name.equals(notifyType);
    }

}
