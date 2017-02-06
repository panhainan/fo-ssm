package com.panhainan.exception;

/**
 * Created by FirePan on 2017/1/23.
 */
public class SystemException extends RuntimeException {

    public SystemException() {
        super("系统异常");
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
