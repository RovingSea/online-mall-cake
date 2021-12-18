package com.wu.user;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 用户服务启动器
 * @author Haixin Wu
 * @date 2021/12/16 18:11
 * @since 1.0
 */
@SpringBootApplication
@EnableDubbo
public class OMCUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(OMCUserApplication.class, args);
    }
}

