package com.wu;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 权限认证服务
 * @author Haixin Wu
 * @date 2021/12/16 19:11
 * @since 1.0
 */
@SpringBootApplication
@EnableDubbo
public class OMCAuthApplication {
    public static void main( String[] args ) {
        SpringApplication.run(OMCAuthApplication.class, args);
    }
}
