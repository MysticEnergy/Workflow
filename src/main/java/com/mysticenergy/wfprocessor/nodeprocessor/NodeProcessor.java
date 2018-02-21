package com.mysticenergy.wfprocessor.nodeprocessor;

import com.mysticenergy.constant.NodeType;
import com.mysticenergy.entity.UserInfo;
import com.mysticenergy.wfprocessor.model.NodeProcessorDTO;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by 书生 on 2018/2/21.
 */
public interface NodeProcessor {

    NodeType getNodeType();

    default boolean isSupport(String nodeType) {
        return getNodeType() != null && getNodeType().equal(nodeType);
    }

    NodeProcessorDTO execute(NodeProcessorDTO nodeProcessorDTO);

}
