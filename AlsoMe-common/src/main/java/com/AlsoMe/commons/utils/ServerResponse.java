package com.AlsoMe.commons.utils;//package com.alsome.alsome_create_model.common.utils;
//
//import com.alsome.alsome_create_model.common.enums.UnicomResponseEnums;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.sun.org.apache.bcel.internal.generic.RETURN;
//
//import java.io.Serializable;
//
//// 保证序列化json的时候,如果是null的对象,key也会消失
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//public class ServerResponse<T> implements Serializable {
//    private String status;
//    private String msg;
//    private T data;
//
//    private ServerResponse(String status) {
//        this.status = status;
//    }
//
//    private ServerResponse(String status, T data) {
//        this.status = status;
//        this.data = data;
//    }
//
//    private ServerResponse(String status, String msg, T data) {
//        this.status = status;
//        this.msg = msg;
//        this.data = data;
//    }
//
//    private ServerResponse(String status, String msg) {
//        this.status = status;
//        this.msg = msg;
//    }
//
//    @JsonIgnore
//    // 使之不在json序列化结果当中
//    public boolean isSuccess() {
//        return this.status.equals(UnicomResponseEnums.SUCCESS.getCode());
//
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public static <T> ServerResponse<T> createBySuccess() {
//        return new ServerResponse<T>(UnicomResponseEnums.SUCCESS.getCode());
//    }
//
//    public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
//        return new ServerResponse<T>(UnicomResponseEnums.SUCCESS.getCode(), msg);
//    }
//
//    public static <T> ServerResponse<T> createBySuccess(T data) {
//        return new ServerResponse<T>(UnicomResponseEnums.SUCCESS.getCode(), data);
//    }
//
//    public static <T> ServerResponse<T> createBySuccess(String msg, T data) {
//        return new ServerResponse<T>(UnicomResponseEnums.SUCCESS.getCode(), msg, data);
//    }
//
//    public static <T> ServerResponse<T> createByError() {
//        return new ServerResponse<T>(UnicomResponseEnums.ERROR.getCode(), UnicomResponseEnums.ERROR.getMsg());
//    }
//
//    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage) {
//        return new ServerResponse<T>(UnicomResponseEnums.ERROR.getCode(), errorMessage);
//    }
//
//    public static <T> ServerResponse<T> createByErrorCodeMessage(String errorCode, String errorMessage) {
//        return new ServerResponse<T>(errorCode, errorMessage);
//    }
//}
