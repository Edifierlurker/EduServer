package com.pinke.uni.lottery.http;

public class SnsInitException extends RuntimeException {

    public SnsInitException() {
    }

    public SnsInitException(String message) {
        super("init sns fail: " + message);
    }

    public SnsInitException(String message, Throwable cause) {
        super("init sns fail: " + message, cause);
    }

    public SnsInitException(Throwable cause) {
        super(cause);
    }
}
