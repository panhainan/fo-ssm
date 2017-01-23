package com.panhainan.exception;

/**
 * Created by FirePan on 2017/1/23.
 */
public class DataInsertException  extends  SystemException{
    public DataInsertException(String message) {
        super(message);
    }

    public DataInsertException(String message, Throwable cause) {
        super(message, cause);
    }
}
