package com.pinke.uni.mobile.protal.common.model;

/**
 * Created by Administrator on 15-1-4.
 */
public enum  ResultType{
    JSON("json"),HTML("html"),XML("xml"),TEXT("text"),NULL("null");

    private ResultType(String value){
        this.value = value;
    }

    private String value;
}
