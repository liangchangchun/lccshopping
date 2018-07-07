package com.shopping.cloud.common.helper;

import com.shopping.cloud.common.exception.LovegoRunTimeException;
import com.shopping.cloud.common.source.AKResult;
import com.shopping.cloud.common.enums.ResultMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>类的详细说明</p>
 * @dateTime 2017/7/5 17:53 
 * @author 朱文彬
 * @version 1.00
 */
@RestControllerAdvice
public class GlobalMicroExceptionHandlerConfig {

    private static Logger logger= LoggerFactory.getLogger(GlobalMicroExceptionHandlerConfig.class);

    /**
     * 添加全局异常处理流程，根据需要设置需要处理的异常，@Valid异常
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value=MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public AKResult MethodArgumentNotValidHandler(MethodArgumentNotValidException exception)
    {
    	logger.error("运行时异常", exception);
    	 exception.printStackTrace();
        //按需重新封装需要返回的错误信息
        StringBuffer errorString=new StringBuffer();
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            errorString.append("["+error.getField()+":"+error.getDefaultMessage()+"]");
        }
        return ResultMsg.HTTP_PARAM_ERROR.setMsg(errorString.toString()).info();
    }

    /**
     * 业务逻辑捕获转换
     * @param exception
     * @return
     */
    @ExceptionHandler(value=LovegoRunTimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public AKResult handleLovegoBusinessException(LovegoRunTimeException exception) {
        logger.error("业务逻辑异常:", exception);
        exception.printStackTrace();
        return exception.getStatusAkResult().info(exception);
    }

    /**
     * 异常捕获转换
     * @param exception
     * @return
     */
    @ExceptionHandler(value=Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public AKResult handleException(Exception exception) {
        logger.error("异常:",exception);
        exception.printStackTrace();
        return ResultMsg.HTTP_STATUS_CODE_500.info(exception);
    }
}
