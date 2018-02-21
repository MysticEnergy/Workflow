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

    default String getUserId(UserInfo userInfo) {
        if (userInfo == null) {
            return null;
        }

        List<UserInfo.Bound> boundList = userInfo.getBounds();

        if (CollectionUtils.isEmpty(boundList)) {
            return null;
        }

        for (UserInfo.Bound bound : boundList) {
            if (isSupport(bound.getType())) {
                return bound.getKey();
            }
        }

        return null;
    }

    NodeProcessorDTO execute(NodeProcessorDTO nodeProcessorDTO);

}
