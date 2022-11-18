package com.binbinxiu.daka.enums;

public enum RenWuTypeEnum {
    NO_TYPE("noType","没有分配类型"),
    GAME("game","游戏"),
    STUDY("study","学习");

    public String value;
    public String name;

    RenWuTypeEnum(String value, String name){
        this.name = name;
        this.value = value;
    }

    public static String getName(String value){
        for (RenWuTypeEnum renWuTypeEnum : values()) {
            if(renWuTypeEnum.value.equals(value)){
                return renWuTypeEnum.name;
            }
        }
        return value;
    }

}
