package com.mysticenergy.notify.service;

import com.google.common.base.Objects;
import com.mysticenergy.constant.NotifyType;
import com.mysticenergy.notify.model.NotifyDTO;

/**
 * 通知接口
 * Created by 书生 on 2018/2/20.
 */
public interface NotifyService {

    /**
     * 通知类型
     *
     * @return 类型枚举
     */
    NotifyType getType();

    /**
     * 是否支持指定类型
     *
     * @param notifyType 指定类型
     * @return t/f
     */
    default boolean isSupport(NotifyType notifyType) {
        return getType() == notifyType;
    }

    /**
     * 发送通知
     *
     * @param notifyDTO 通知数据
     * @return t/f 是否成功
     */
    boolean sendMessage(NotifyDTO notifyDTO);
}
