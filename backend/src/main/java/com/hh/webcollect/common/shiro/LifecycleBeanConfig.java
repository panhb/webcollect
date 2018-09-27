package com.hh.webcollect.common.shiro;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 解决bean加载问题
 *
 * @author hongbo.pan
 * @date 2018/9/21
 */
@Configuration
public class LifecycleBeanConfig {

    /**
     * Shiro生命周期处理器
     */
    @Bean
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

}
