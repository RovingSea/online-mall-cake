package com.wu;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 商品服务启动器
 * @author Haixin Wu
 * @date 2021/12/16 18:10
 * @since 1.0
 */
@SpringBootApplication
@EnableDubbo
@EnableCaching
public class OMCGoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(OMCGoodsApplication.class, args);
    }
}

