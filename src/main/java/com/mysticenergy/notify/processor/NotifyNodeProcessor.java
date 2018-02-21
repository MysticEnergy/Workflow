package com.mysticenergy.notify.processor;

import com.mysticenergy.constant.NodeType;
import com.mysticenergy.wfprocessor.model.NodeProcessorDTO;
import com.mysticenergy.wfprocessor.nodeprocessor.NodeProcessor;
import org.springframework.stereotype.Service;

/**
 * Created by 书生 on 2018/2/21.
 */
@Service
public class NotifyNodeProcessor implements NodeProcessor {

    @Override
    public NodeType getNodeType() {
        return NodeType.NOTIFY;
    }

    @Override
    public NodeProcessorDTO execute(NodeProcessorDTO nodeProcessorDTO) {
        return null;
    }

}
