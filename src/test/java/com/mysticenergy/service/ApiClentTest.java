package com.mysticenergy.service;

import com.alibaba.fastjson.JSONObject;
import com.mysticenergy.common.BaseTest;
import com.mysticenergy.entity.TestEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Name: ApiClentTest
 * Desc:
 *
 * @Author: wasmir
 * @Date 2018/2/20
 */
public class ApiClentTest extends BaseTest{
    @Autowired
    ApiClent apiClent;

    @Autowired
    RestTemplate restTemplate;
    @Test
    public void test(){
        String url = "https://api.seniverse.com/v3/weather/now.json?key={key}&location={location}";
        Map<String,String> map = new HashMap<>();
        map.put("key","xxxxxxxxxxx");
        map.put("location","beijing");
        String method = "get";
        Assert.assertNotNull(apiClent.getJson(url,map,method));
        Assert.assertNotEquals("{}",apiClent.getJson(url,map,method));
    }
}
