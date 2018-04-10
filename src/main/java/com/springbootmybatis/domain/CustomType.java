package com.springbootmybatis.domain;

import java.io.Serializable;

public class CustomType implements Serializable{
    private static final long serialVersionUID = 1421458228428397003L;
    private Integer code;
    private String message;

    public CustomType(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public CustomType() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
