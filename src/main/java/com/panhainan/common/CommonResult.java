package com.panhainan.common;

/**
 * HTTP请求返回结果公共类
 * @author panhainan
 * @email panhainan@yeah.net
 * @version 1.0 */
public class CommonResult {
    public static final int SUCCESS_CODE = 1;
    public static final int FAIL_CODE=0;

    /**
     * 操作结果码，对应上面的定义的SUCCESS_CODE、FAIL_CODE
     */
    private Integer resultCode;
    /**
     * 操作结果信息，主要用来存储操作失败时对异常信息做出的提示信息
     */
    private String resultMsg;
    /**
     * 操作结果数据集，用来存储要返回给前端的数据，可以是对象、集合等等
     */
    private Object resultData;

    public CommonResult(Integer resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }

    public CommonResult(Integer resultCode, String resultMsg, Object resultData) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.resultData = resultData;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }
}
