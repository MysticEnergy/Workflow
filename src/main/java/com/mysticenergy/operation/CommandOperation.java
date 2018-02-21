package com.mysticenergy.operation;

import com.mysticenergy.command.CommandHelper;
import com.mysticenergy.entity.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Name: CommandOperation
 * Desc: 命令操作类，继承该类实现before与after方法进行对上下文的限制
 *
 * @Author: wasmir
 * @Date 2018/2/21
 */

@Service
public class CommandOperation {

    @Autowired
    private CommandHelper commandHelper;

    private final static String SUCCESS = "操作成功";
    private final static String FAILED = "操作失败";

    @SuppressWarnings("unchecked")
    public OperationResult<Class> compileOR(Node node) {
        Class clazz = commandHelper.compile(node);
        OperationResult<Class> or = new OperationResult<>();
        if (clazz != null) {
            or.setSuccess()
                    .setMessage(CommandOperation.SUCCESS)
                    .setData(clazz);
        } else {
            or.setFailed()
                    .setMessage(CommandOperation.FAILED)
                    .setData(null);
        }
        return or;
    }

    public OperationResult<NULL> run(Node node) {
        OperationResult<NULL> or = new OperationResult<>();
        OperationResult orB = runBefore(node);
        try {
            //commandHelper.run(node);
        } catch (Exception e) {
            or.setFailed()
                    .setMessage(e.getMessage());
        }
        OperationResult orA = runAfter(node);
        if (or.isSuccess() && orA.isSuccess() && orB.isSuccess()) {
            or.setSuccess().
                    setMessage(CommandOperation.SUCCESS);
        } else {
            or.setFailed().
                    setMessage(orA.getMessage() + "\n"
                            + or.getMessage() + "\n"
                            + orB.getMessage() + "\n");
        }
        return or;
    }

    public OperationResult<NULL> runBefore(Node node) {
        return new OperationResult<>();
    }

    public OperationResult<NULL> runAfter(Node node) {
        return new OperationResult<>();
    }
}
