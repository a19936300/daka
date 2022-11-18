package com.binbinxiu.daka.service.msg;

import com.binbinxiu.daka.entity.bo.ParseMsg;
import com.binbinxiu.daka.enums.MsgEnum;

public class ExpendHandler extends Handler<ParseMsg> {

    @Override
    public boolean canRequest(ParseMsg msg) {
        if(msg.content.contains(MsgEnum.EXPEND.value)){
            return true;
        }
        return false;
    }
    
}
