package com.mysticenergy.command;

import com.alibaba.fastjson.JSONObject;

/**
 * Name: Command
 * Desc: 动态代码段接口
 *
 * @Author: wasmir
 * @Date 2018/2/20
 */
public interface Command {
    JSONObject execute(JSONObject jsonObject);
}
