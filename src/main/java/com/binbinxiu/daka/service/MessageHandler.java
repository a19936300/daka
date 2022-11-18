package com.binbinxiu.daka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.binbinxiu.daka.service.msg.ChainMessageHandlerFactory;
import com.binbinxiu.daka.service.msg.RenWuHandler;

import weixin.popular.bean.message.EventMessage;

/**
 * 处理微信发过来的消息
 */
@Component
public class MessageHandler {

    @Autowired
    private TRenWuService tRenWuService;

    @Autowired
    private TDayExpendService tDayExpendService;

    public  String handler(EventMessage eventMessage){
        String content = eventMessage.getContent();
        //RenWuHandler renWuHandler = ChainMessageHandlerFactory.build();
        //renWuHandler.requestHandler(content);
        if(content.contains("=")){
            tRenWuService.receiveRenWu(content);
            return "记录成功 \n"+tRenWuService.renWuSum();
        }
        if(content.startsWith("花了")){
            boolean b = tDayExpendService.expendRecord(eventMessage);
            if(!b){
                return "记录失败,金额转换失败";
            }
        }
        return null;
    }
}
