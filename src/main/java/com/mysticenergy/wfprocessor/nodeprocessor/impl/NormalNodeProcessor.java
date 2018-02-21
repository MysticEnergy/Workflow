package com.mysticenergy.wfprocessor.nodeprocessor.impl;

import com.alibaba.fastjson.JSONObject;
import com.mysticenergy.command.CommandHelper;
import com.mysticenergy.common.exception.WfBaseException;
import com.mysticenergy.constant.NodeType;
import com.mysticenergy.entity.Node;
import com.mysticenergy.wfprocessor.model.NodeProcessorDTO;
import com.mysticenergy.wfprocessor.nodeprocessor.NodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Name: NormalNodeProcessor
 * Desc:
 *
 * @Author: wasmir
 * @Date 2018/2/21
 */
public class NormalNodeProcessor implements NodeProcessor{

    @Autowired
    private CommandHelper commandHelper;

    @Override
    public NodeType getNodeType() {
        return NodeType.NORMAL;
    }

    @Override
    public NodeProcessorDTO execute(NodeProcessorDTO nodeProcessorDTO) {
        Node node = nodeProcessorDTO.getNode();
        try {
            JSONObject result = commandHelper.run(nodeProcessorDTO);
        }catch (Exception e){
            throw new WfBaseException("key",e);
        }

        return null;
    }
}
