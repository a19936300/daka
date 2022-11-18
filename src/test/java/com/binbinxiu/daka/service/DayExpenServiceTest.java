package com.binbinxiu.daka.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import weixin.popular.bean.message.EventMessage;

@SpringBootTest
public class DayExpenServiceTest {

    @Autowired
    private TDayExpendService tDayExpendService;

    @Test
    public void receiveMessage(){
        EventMessage eventMessage = new EventMessage();
        eventMessage.setFromUserName("sdfsd_dfsdf-sdf");
        eventMessage.setContent("今天买水花了20.5元");

        tDayExpendService.expendRecord(eventMessage);
    }
}
