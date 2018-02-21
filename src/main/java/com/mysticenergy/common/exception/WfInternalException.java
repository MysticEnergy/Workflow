package com.mysticenergy.common.exception;

/**
 * 系统内部错误
 * Created by 书生 on 2018/2/21.
 */
public class WfInternalException extends WfBaseException {

    public WfInternalException() {
        super("com.mysticEnergy.internal.exception");
    }

    public WfInternalException(Exception e) {
        super("com.mysticEnergy.internal.exception", e);
    }

}
