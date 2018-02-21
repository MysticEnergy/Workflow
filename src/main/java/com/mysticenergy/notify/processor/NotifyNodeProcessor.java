package com.mysticenergy.notify.processor;

import com.mysticenergy.common.exception.ExceptionKeyConstant;
import com.mysticenergy.common.exception.WfBaseException;
import com.mysticenergy.constant.NodeType;
import com.mysticenergy.entity.Node;
import com.mysticenergy.entity.UserInfo;
import com.mysticenergy.notify.model.NotifyDTO;
import com.mysticenergy.notify.service.NotifyService;
import com.mysticenergy.wfprocessor.model.NodeProcessorDTO;
import com.mysticenergy.wfprocessor.nodeprocessor.NodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * notify节点执行类
 * Created by 书生 on 2018/2/21.
 */
@Service
public class NotifyNodeProcessor implements NodeProcessor {

    @Autowired
    private List<NotifyService> notifyServiceList;

    @Override
    public NodeType getNodeType() {
        return NodeType.NOTIFY;
    }

    @Override
    public NodeProcessorDTO execute(NodeProcessorDTO nodeProcessorDTO) {
        Node node = nodeProcessorDTO.getNode();
        UserInfo userInfo = nodeProcessorDTO.getUserInfo();

        getNotifyService(node.getCode()).sendMessage(
                new NotifyDTO().setUserId(getUserId(userInfo))
                        .setMessage(nodeProcessorDTO.getData().toString())
        );

        return null;
    }

    protected NotifyService getNotifyService(String notifyType) {
        if (notifyServiceList == null) {
            throw new WfBaseException(ExceptionKeyConstant.Notify.NOTIFY_TYPE_NOT_FOUND);
        }

        for (NotifyService notifyService : notifyServiceList) {
            if (notifyService.isSupport(notifyType)) {
                return notifyService;
            }
        }

        throw new WfBaseException(ExceptionKeyConstant.Notify.NOTIFY_TYPE_NOT_FOUND);
    }

}
