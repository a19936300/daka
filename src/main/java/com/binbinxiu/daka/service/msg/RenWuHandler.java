package com.binbinxiu.daka.service.msg;

import com.binbinxiu.daka.entity.bo.ParseMsg;
import com.binbinxiu.daka.enums.MsgEnum;

public class RenWuHandler extends Handler<ParseMsg> {

    @Override
    public boolean canRequest(ParseMsg msg) {
        if(msg.content.contains(MsgEnum.RENTU.value)){
            return true;
        }
        return false;
    }
    
}
