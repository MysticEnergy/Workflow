package com.mysticenergy.notify.service.impl;

import com.mysticenergy.constant.NotifyType;
import com.mysticenergy.notify.service.NotifyService;
import com.mysticenergy.notify.model.NotifyDTO;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.ApiContext;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by 书生 on 2018/2/20.
 */
@Service
public class TelegramNotify extends TelegramLongPollingBot implements NotifyService {

    private static final Logger logger = LoggerFactory.getLogger(TelegramNotify.class);

    //    @Value("${proxy.host}")
    private static String proxyHost = "127.0.0.1";

    //    @Value("${proxy.port}")
    private static Integer proxyPort = 1080;

    private static DefaultBotOptions buildOptions() {
        DefaultBotOptions options = ApiContext.getInstance(DefaultBotOptions.class);
        options.setRequestConfig(RequestConfig.copy(RequestConfig.custom().build())
                .setSocketTimeout(75000)
                .setConnectTimeout(75000)
                .setConnectionRequestTimeout(75000)
                .setProxy(new HttpHost(proxyHost, proxyPort))
                .build());
        return options;
    }

    public TelegramNotify() {
        this(buildOptions());
    }

    public TelegramNotify(DefaultBotOptions defaultBotOptions) {
        super(defaultBotOptions);
    }

    @Value("${notify.telegram.botUserName}")
    private String botUserName;

    @Value("${notify.telegram.token}")
    private String token;

    @Override
    public NotifyType getType() {
        return NotifyType.TELEGRAM;
    }

    @Override
    public boolean sendMessage(NotifyDTO notifyDTO) {
        SendMessage sendMessage = new SendMessage(notifyDTO.getUserId(), notifyDTO.getMessage());
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            logger.error("发送失败！", e);
            return false;
        }
        return true;
    }

    @Override
    public void onUpdateReceived(Update update) {
        //ignore
    }

    @Override
    public String getBotUsername() {
        return this.botUserName;
    }

    @Override
    public String getBotToken() {
        return this.token;
    }
}
