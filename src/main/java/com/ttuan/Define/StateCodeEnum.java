package com.ttuan.Define;

public enum  StateCodeEnum {
    SUCCESS(200,"操作成功"),
    FAIL(300,"操作失败"),
    NULL_ERR(500,"空指针异常，请联系管理员！");

    private Integer code;
    private String value;

    StateCodeEnum(Integer code ,String value) {
        this.code = code;
        this.value = value;
    }


    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }


}


