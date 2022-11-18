package com.binbinxiu.daka.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import weixin.popular.bean.message.EventMessage;
@SpringBootTest
public class MessageHandlerTest{

    @Autowired
    private MessageHandler messageHandler;

    @Test
    public void saveRenWu(){
        EventMessage eventMessage = new EventMessage();
        eventMessage.setContent("测试=6");
        String handler = messageHandler.handler(eventMessage);
        System.out.println(handler);
    }

}
