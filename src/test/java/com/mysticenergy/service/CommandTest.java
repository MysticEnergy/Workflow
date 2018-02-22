package com.mysticenergy.service;

import com.mysticenergy.command.CommandHelper;
import com.mysticenergy.common.BaseTest;
import com.mysticenergy.entity.Node;
import com.mysticenergy.wfprocessor.model.NodeProcessorDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Name: CommandTest
 * Desc:
 *
 * @Author: wasmir
 * @Date 2018/2/20
 */
public class CommandTest extends BaseTest{



    @Autowired
    CommandHelper commandHelper;
    @Test
    public void test() throws Exception {
        Node node = new Node();
        node.set_id("123");
        node.setCode("String a = \"123\";System.out.println(\"Hello World 你好你好\" + a);\nreturn null;");
        Node node2 = new Node();
        node2.set_id("12345");
        node2.setCode("System.out.println(\"Hello World2\");\n");
        Node node3 = new Node();
        node3.set_id("123456");
        node3.setCode("System.out.println(\"Hello World3\");\n");
        NodeProcessorDTO nodeProcessorDTO = new NodeProcessorDTO().setNode(node);
        commandHelper.compile(nodeProcessorDTO);
        commandHelper.run(nodeProcessorDTO);


    }
}
