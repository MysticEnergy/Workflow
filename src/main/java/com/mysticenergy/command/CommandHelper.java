package com.mysticenergy.command;

import com.alibaba.fastjson.JSONObject;
import com.mysticenergy.command.runtime.DynamicEngine;
import com.mysticenergy.operation.OperationResult;
import com.mysticenergy.entity.Node;
import com.mysticenergy.wfprocessor.model.NodeProcessorDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import sun.misc.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


/**
 * Name: CommandHelper
 * Desc: 动态代码段编译运行类
 *
 * @Author: wasmir
 * @Date 2018/2/20
 */

@Service
public class CommandHelper {

    @Value("${dyCode.fullPre}")
    private String fullPreClassName;

    @Value("${dyCode.pre}")
    private String preClassName;

    @Value("${dyCode.tail}")
    private String tailClassName;

    @Value("${dyCode.preCode}")
    private String preCode;

    @Value("${dyCode.midCode}")
    private String midCode;

    @Value("${dyCode.tailCode}")
    private String tailCode;


    /**
     * 编译node中的code为Dy{nodeId}Command.class并返回Class类
     *
     * @param node
     * @return
     * @throws Exception
     */
    public Class compile(Node node) {
        String className = preClassName + node.get_id() + tailClassName;
        String fullClassName = fullPreClassName + node.get_id() + tailClassName;
        String code = node.getCode();
        String realCode = preCode + className + midCode + code + tailCode;
        try (InputStream in = new ByteArrayInputStream(realCode.getBytes())) {
            byte[] bytes = IOUtils.readFully(in, -1, false);
            String src = new String(bytes);
            DynamicEngine de = DynamicEngine.getInstance();
            return de.javaCodetoMemory(fullClassName, src.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 编译并运行node中的code
     *
     * @param nodeDTO
     * @throws Exception
     */
    public JSONObject run(NodeProcessorDTO nodeDTO) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Node node = nodeDTO.getNode();
        String fullClassName = fullPreClassName + node.get_id() + tailClassName;
        Class clazz = null;
        clazz = DynamicEngine.getInstance().getDynamicClassLoader().loadClass(fullClassName);
        Command command = (Command) clazz.newInstance();
        return command.execute(nodeDTO.getData());
    }
}
