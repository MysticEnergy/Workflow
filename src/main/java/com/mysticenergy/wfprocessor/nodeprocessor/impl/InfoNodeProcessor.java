package com.mysticenergy.wfprocessor.nodeprocessor.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysticenergy.constant.NodeType;
import com.mysticenergy.service.ApiClent;
import com.mysticenergy.wfprocessor.model.NodeProcessorDTO;
import com.mysticenergy.wfprocessor.nodeprocessor.NodeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Name: InfoNodeProcessor
 * Desc:
 *
 * @Author: wasmir
 * @Date 2018/3/2
 */

@Service
public class InfoNodeProcessor implements NodeProcessor{

    @Autowired
    ApiClent apiClent;

    @Override
    public NodeType getNodeType() {
        return NodeType.INFO;
    }

    @Override
    public NodeProcessorDTO execute(NodeProcessorDTO nodeProcessorDTO) {
        // code : url|method|params
        //https://api.seniverse.com/v3/weather/now.json?key={key}&location={location}|get|{"key":"auvelrhcvsizxt9k","location":"nanchang"}
        // params : {"key":"value"}
        String[] urlAndParams = nodeProcessorDTO.getNode().getCode().split("\\|");
        JSONObject o = apiClent.getJson(urlAndParams[0],JSONObject.parseObject(urlAndParams[2], Map.class), urlAndParams[1]);
        return nodeProcessorDTO.setData(o);
    }
}
