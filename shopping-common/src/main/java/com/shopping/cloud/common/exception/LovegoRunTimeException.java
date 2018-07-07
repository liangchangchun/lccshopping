package com.shopping.cloud.common.exception;


/**
 * <p>运行时基础异常类</p>
 * @dateTime 2017/4/14 17:16
 * @author 朱文彬
 * @version 1.00
 */
public class LovegoRunTimeException extends  RuntimeException{

    private static final long serialVersionUID = 1L;

    private StatusAkResult statusAkResult;

    private  String stackTraceMessage;




    public LovegoRunTimeException(String message, Throwable e)
    {
        super(message, e);
    }
    
    public LovegoRunTimeException(String message)
    {
        super(message);
    }


    public LovegoRunTimeException(String message, String paramInfo)
    {
        super(message + " === 【DEBUG参考信息】" + paramInfo);
    }


    public LovegoRunTimeException(String message, Throwable e, String paramInfo)
    {
        super(message + " === 【DEBUG参考信息】" + paramInfo, e);
    }

    public LovegoRunTimeException(String message,StatusAkResult statusAkResult) {
        this(message, null,null, statusAkResult);
    }

    public LovegoRunTimeException(StatusAkResult statusAkResult) {
        this(statusAkResult.getErrMsg(), null,null, statusAkResult);
    }

    public LovegoRunTimeException(String message, String stackTraceMessage, StatusAkResult statusResult) {
        this(message, stackTraceMessage, null, statusResult);
    }

    public LovegoRunTimeException(String message, String stackTraceMessage, Throwable cause, StatusAkResult statusAkResult) {
        super(message, cause);
        this.statusAkResult = statusAkResult;
        this.stackTraceMessage = stackTraceMessage;
    }

    public StatusAkResult getStatusAkResult() {
        return statusAkResult;
    }

    public String getStackTraceMessage() {
        return stackTraceMessage;
    }
}
