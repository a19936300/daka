package com.binbinxiu.daka.enums;

public enum MsgEnum {
    RENTU("=","任务"),
    EXPEND("花了","日常支付");

    public String value;
    public String name;

    MsgEnum(String value, String name){
        this.name = name;
        this.value = value;
    }

    public static String getName(String value){
        for (MsgEnum msgEnum : values()) {
            if(msgEnum.value.equals(value)){
                return msgEnum.name;
            }
        }
        return value;
    }
}
