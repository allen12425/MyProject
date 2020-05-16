package com.example.demo.common;

import lombok.Data;

@Data
public class Result {
    public static final int OK_CODE = 1000;
    /**
     * 状态码
     */
    private int code;
    /**
     * 提示信息
     */
    private String message;
    /**
     * 数据
     */
    private Object data;
    /**
     * 错误信息
     */
    private String errMsg;
    /**
     * 本次请求的唯一id
     */
    private String actionId;

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public static Result unAuth(){
        return new Result(-1,"",null);
    }
    public static Result success(Object data){
        return new Result(OK_CODE,"success",data);
    }
    public static Result success(String message,Object data){
        return new Result(OK_CODE,message,data);
    }

    public static Result failed(String message) {
        return new Result(0,message,null);
    }
    public static Result failed(String message,Object data) {
        return new Result(0,message,data);
    }

    public static Result failed(Exception e) {
        CustomException be;
        if (e instanceof CustomException) {
            be = (CustomException)e;
        }else {
            be = new CustomException(e);
        }
        return new Result(be.getCode(),be.getMessage(),null);
    }
}
