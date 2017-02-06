package com.panhainan.exception;

/**
 * Created by FirePan on 2017/1/23.
 */
public class DataInsertException  extends  SystemException{
    public DataInsertException() {
        super("数据插入失败");
    }

    public DataInsertException(String message) {
        super(message);
    }

    public DataInsertException(String message, Throwable cause) {
        super(message, cause);
    }
}
