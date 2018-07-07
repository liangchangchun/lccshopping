package com.shopping.cloud.common.helper;
/*****************************************************************************
 * Copyright (c) 2017 前海乐富电子商务有限公司
 *
 *****************************************************************************/


import feign.Feign;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.WebMvcRegistrations;
import org.springframework.boot.autoconfigure.web.WebMvcRegistrationsAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * <p>描述：@FeignClient with top level @RequestMapping </p>
 *
 * @author 朱文彬
 * @date 2017/11/20
 */
@Configuration
@ConditionalOnClass({Feign.class})
public class FeignMappingDefaultConfig {

    @Bean
    public WebMvcRegistrations feignWebRegistrations() {
        return new WebMvcRegistrationsAdapter() {
            @Override
            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
                return new FeignFilterRequestMappingHandlerMapping();
            }
        };
    }

    private static class FeignFilterRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
        @Override
        protected boolean isHandler(Class<?> beanType) {
            return super.isHandler(beanType) && ((AnnotationUtils.findAnnotation(beanType, RestController.class) != null) || (AnnotationUtils.findAnnotation(beanType, Controller.class) != null));
        }
    }
}
