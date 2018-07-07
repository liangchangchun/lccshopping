package com.shopping.cloud.common.helper;

import com.shopping.cloud.common.exception.LovegoRunTimeException;
import com.shopping.cloud.common.source.AKConstants;
import com.shopping.cloud.common.source.AKResult;
import com.shopping.cloud.common.enums.ResultMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>类的详细说明</p>
 * @dateTime 2017/11/20 17:53
 * @author 朱文彬
 * @version 1.00
 */
@RestControllerAdvice
public class GlobalControllerExceptionHandlerConfig {

    private static Logger logger= LoggerFactory.getLogger(GlobalControllerExceptionHandlerConfig.class);

    /**
     * 添加全局异常处理流程，根据需要设置需要处理的异常，@Valid异常
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value=MethodArgumentNotValidException.class)
    @ResponseBody
    public AKResult MethodArgumentNotValidHandler(MethodArgumentNotValidException exception) {
    	logger.error("WEB参数校验不通过", exception);
        //按需重新封装需要返回的错误信息
        StringBuffer errorString=new StringBuffer();
        for (FieldError error : exception.getBindingResult().getFieldErrors()) {
            errorString.append("["+error.getField()+":"+error.getDefaultMessage()+"]");
        }
        return ResultMsg.HTTP_PARAM_ERROR.info(errorString.toString());
    }

    /**
     * 业务逻辑捕获转换
     * @param exception
     * @return
     */
    @ExceptionHandler(value=LovegoRunTimeException.class)
    public AKResult handleLovegoBusinessException(LovegoRunTimeException exception) {
        logger.error("业务逻辑异常:", exception);
        return exception.getStatusAkResult().info(exception);
    }

    /**
     * 异常捕获转换
     * @param exception
     * @return
     */
    @ExceptionHandler(value=Exception.class)
    public AKResult handleException(Exception exception) {
        logger.error("异常:",exception);
        return ResultMsg.HTTP_STATUS_CODE_500.info(AKConstants.ERR_FAIL_MSG);
    }
}
