package com.mysticenergy.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Name: ApiClent
 * Desc: API调用类
 *
 * @Author: wasmir
 * @Date 2018/2/20
 */
@Service
public class ApiClent {
    @Autowired
    RestTemplate restTemplate;

    public JSONObject getJson(String url, Map<String,String> map,String method){
        JSONObject object = new JSONObject();
        if("post".equals(method)) {
            MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
            multiValueMap.setAll(map);
            object = restTemplate.postForObject(url, multiValueMap, JSONObject.class);
        }else if("get".equals(method)){
            object = restTemplate.getForObject(url,JSONObject.class,map);
        }
        return object;
    }
}
