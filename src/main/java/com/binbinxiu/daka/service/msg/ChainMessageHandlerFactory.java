package com.binbinxiu.daka.service.msg;

public class ChainMessageHandlerFactory {
    public static RenWuHandler build(){
        RenWuHandler renwu = new RenWuHandler();
        ExpendHandler expendHandler = new ExpendHandler();
        
        renwu.setNext(expendHandler);
        return renwu;
    }
}
