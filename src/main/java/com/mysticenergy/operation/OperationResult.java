package com.mysticenergy.operation;

/**
 * Name: OperationResult
 * Desc:
 *
 * @Author: wasmir
 * @Date 2018/2/21
 */
public class OperationResult<T> {

    /**
     * 操作状态
     */
    private String status;

    private T data;

    private String message;

    public OperationResult() {
        this.status = OperationResult.SUCCESS;
    }

    private final static String SUCCESS = "success";

    private final static String FAILED = "failed";

    public String getStatus() {
        return status;
    }

    public OperationResult setStatus(String status) {
        this.status = status;
        return this;
    }

    public T getData() {
        return data;
    }

    public OperationResult setData(T data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public OperationResult setMessage(String message) {
        this.message = message;
        return this;
    }

    public OperationResult setSuccess(){
        this.status = OperationResult.SUCCESS;
        return this;
    }

    public OperationResult setFailed(){
        this.status = OperationResult.FAILED;
        return this;
    }

    public boolean isSuccess(){
        if (this.getStatus().equals("success")) {
            return true;
        }else {
            return false;
        }
    }
}
