package com.pinke.uni.lottery.http;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 13-1-7
 * Time: 下午2:56
 * To change this template use File | Settings | File Templates.
 */
public class SnsTransportException extends RuntimeException {

    public SnsTransportException() {
    }

    public SnsTransportException(String message) {
        super("sns fail: " + message);
    }

    public SnsTransportException(String message, Throwable cause) {
        super("sns fail: " + message, cause);
    }

    public SnsTransportException(Throwable cause) {
        super(cause);
    }
}
