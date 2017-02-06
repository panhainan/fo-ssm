package com.panhainan.exception;

/**
 * Created by FirePan on 2017/1/23.
 */
public class DataExistException extends SystemException {

    public DataExistException(String message) {
        super(message);
    }

    public DataExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
