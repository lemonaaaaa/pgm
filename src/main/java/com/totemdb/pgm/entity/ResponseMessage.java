package com.totemdb.pgm.entity;

import org.springframework.http.HttpStatus;

public class ResponseMessage<T> {
    private Integer code;
    private String message;
    private T data;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public ResponseMessage(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseMessage<T> success(T data) {
        return new ResponseMessage<T>(HttpStatus.OK.value(), "success", data);
    }

    public static <T> ResponseMessage<T> success() {
        return new ResponseMessage<T>(HttpStatus.OK.value(), "success", null);
    }

    public static <T> ResponseMessage<T> error(String msg) {
        return new ResponseMessage<T>(HttpStatus.OK.value(), msg, null);
    }
}
