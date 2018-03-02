package com.mysticenergy.wfprocessor.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mysticenergy.common.BaseTest;
import com.mysticenergy.constant.NodeType;
import com.mysticenergy.entity.Node;
import com.mysticenergy.entity.UserInfo;
import com.mysticenergy.entity.Workflow;
import com.mysticenergy.util.UuidGenerator;
import com.mysticenergy.wfprocessor.WorkflowProcessor;
import com.mysticenergy.wfprocessor.model.WorkflowProcessorDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Created by 书生 on 2018/2/21.
 */
public class DefaultWorkflowProcessorTest extends BaseTest {

    @Autowired
    private WorkflowProcessor workflowProcessor;

    @Test
    public void execute() throws Exception {
        JSONObject object = new JSONObject();
        object.getString("");
        object.getString("");
        workflowProcessor.execute(new WorkflowProcessorDTO()
                .setWorkflow(
                        new Workflow()
                                .set_id("1")
                                .setWfName("test")
                                .setNodes(Arrays.asList(
                                        new Node().set_id("1")
                                                .setType(NodeType.NORMAL.getName())
                                                .setCode("        JSONArray array = data.getJSONArray(\"results\");\n" +
                                                        "        JSONObject ret = (JSONObject) array.get(0);\n" +
                                                        "        JSONObject o = new JSONObject();\n" +
                                                        "        o.put(\"位置\",ret.getJSONObject(\"location\").getString(\"name\"));\n" +
                                                        "        o.put(\"天气\",ret.getJSONObject(\"now\").getString(\"text\"));" +
                                                        "        return o;")
                                                .setNodeName("node1")
                                                .setPreNum(0)
                                                .setRelations(
                                                        Arrays.asList(
                                                                new Node.Relation()
                                                                        .setResult(true).setTo("2")
                                                        )
                                                ),
                                        new Node().set_id("2")
                                                .setType(NodeType.NOTIFY.getName())
                                                .setCode("telegram")
                                                .setNodeName("node2")
                                                .setPreNum(1)
                                                .setRelations(Collections.emptyList())

                                ))
                )
                .setUserInfo(new UserInfo()
                        .setUserName("428620498")
                        .set_id(UuidGenerator.uuid())
                        .setBounds(Arrays.asList(
                                new UserInfo.Bound()
                                        .setType("telegram")
                                        .setKey("428620498"),
                                new UserInfo.Bound()
                                        .setType("telegram")
                                        .setKey("523969365")
                        ))
                        .setWfIds("1"))
        );
    }

}