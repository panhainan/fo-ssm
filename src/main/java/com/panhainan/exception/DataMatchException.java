package com.panhainan.exception;

/**
 * Created by FirePan on 2017/1/23.
 */
public class DataMatchException extends SystemException {
    public DataMatchException(String message) {
        super(message);
    }

    public DataMatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
