package com.mysticenergy.wfprocessor.nodeprocessor.impl;

import com.mysticenergy.command.CommandHelper;
import com.mysticenergy.common.exception.WfBaseException;
import com.mysticenergy.constant.NodeType;
import com.mysticenergy.wfprocessor.model.NodeProcessorDTO;
import com.mysticenergy.wfprocessor.nodeprocessor.NodeProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Name: NormalNodeProcessor
 * Desc:
 *
 * @Author: wasmir
 * @Date 2018/2/21
 */
@Service
public class NormalNodeProcessor implements NodeProcessor {

    private static final Logger logger = LoggerFactory.getLogger(NormalNodeProcessor.class);

    @Autowired
    private CommandHelper commandHelper;

    @Override
    public NodeType getNodeType() {
        return NodeType.NORMAL;
    }

    @Override
    public NodeProcessorDTO execute(NodeProcessorDTO nodeProcessorDTO) {
        try {
            commandHelper.compile(nodeProcessorDTO);
            commandHelper.run(nodeProcessorDTO);

//            if (logger.isDebugEnabled()) {
//                logger.debug("执行结果:{}", result);
//            }
        } catch (Exception e) {
            throw new WfBaseException("key", e);
        }

        return nodeProcessorDTO.setStatus(true);
    }
}
