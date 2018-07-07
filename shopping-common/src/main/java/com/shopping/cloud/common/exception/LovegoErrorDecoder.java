package com.shopping.cloud.common.exception;
/*****************************************************************************
 * Copyright (c) 
 *
 *****************************************************************************/


import com.shopping.cloud.common.helper.JacksonUtils;
import com.shopping.cloud.common.source.AKResult;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.apache.log4j.Logger;

/**
 * <p>描述：错误转码业务异常</p>
 *
 * @author 朱文彬 zhuwb@lovego.com
 * @date 2017/8/2
 */
public class LovegoErrorDecoder implements ErrorDecoder {

    private Logger logger = Logger.getLogger(LovegoErrorDecoder.class);

    @Override
    public Exception decode(String methodKey, Response response) {

        /**
         * 业务异常
         */
        if ((400 <= response.status() || response.status() < 500)){
            try {
                if (response.body() != null) {
                   String body = Util.toString(response.body().asReader());
                    AKResult result = JacksonUtils.json2pojo(body, AKResult.class);
                    return new LovegoRunTimeException(result.getErrMsg(), result.getErrMsg(), new StatusAkResult(){
                        @Override
                        public String getErrCode() {
                            return result.getErrCode();
                        }
                        @Override
                        public String getErrMsg() {
                            return result.getErrMsg();
                        }
                    });
                }
            } catch (Exception ignored) {
                logger.error("异常"+ignored);
            }
        }
        return new ErrorDecoder.Default().decode(methodKey, response);
    }
}
