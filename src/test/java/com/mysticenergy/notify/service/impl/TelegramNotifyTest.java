package com.mysticenergy.notify.service.impl;

import com.mysticenergy.common.BaseTest;
import com.mysticenergy.notify.model.NotifyDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by 书生 on 2018/2/20.
 */
public class TelegramNotifyTest extends BaseTest {

    @Autowired
    private TelegramNotify telegramNotify;

    @Test
    public void sendMessage() throws Exception {
        telegramNotify.sendMessage(new NotifyDTO().setMessage("test").setUserId("428620498"));
    }

}