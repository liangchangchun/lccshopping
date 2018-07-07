package com.shopping.cloud.common.exception;
/*****************************************************************************
 * Copyright (c) 2017 
 *
 *****************************************************************************/


import com.shopping.cloud.common.helper.FeignMappingDefaultConfig;
import com.shopping.cloud.common.helper.GlobalControllerExceptionHandlerConfig;
import com.shopping.cloud.common.helper.GlobalMicroExceptionHandlerConfig;
import feign.codec.ErrorDecoder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * <p>描述：controller服务基本配置</p>
 *
 * @author 朱文彬
 * @date 2017/11/20
 */
@SpringBootApplication(exclude=GlobalMicroExceptionHandlerConfig.class)
@EnableEurekaClient
@EnableCircuitBreaker
@Import({GlobalControllerExceptionHandlerConfig.class,FeignMappingDefaultConfig.class})
public abstract class AbstractControllerApplication {

    /**
     * 错误转码业务异常
     * @return
     */
    @Bean
    public ErrorDecoder errorDecoder(){
        return new LovegoErrorDecoder();
    }
}
