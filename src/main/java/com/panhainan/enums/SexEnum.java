package com.panhainan.enums;

/**
 * 测试案例：性别枚举
 *
 * @author panhainan
 * @version 1.0
 * @email panhainan@yeah.net
 */
public enum  SexEnum {
    MALE((byte)1,"男性")
    ,FEMALE((byte)0,"女性")
    ;
    private byte sex;
    private String sexInfo;

    SexEnum(byte sex, String sexInfo) {
        this.sex = sex;
        this.sexInfo = sexInfo;
    }

    public static SexEnum sexOf(byte index){
        for(SexEnum sexEnum:values()){
            if(sexEnum.getSex() == index){
                return sexEnum;
            }
        }
        return null;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public String getSexInfo() {
        return sexInfo;
    }

    public void setSexInfo(String sexInfo) {
        this.sexInfo = sexInfo;
    }
}
