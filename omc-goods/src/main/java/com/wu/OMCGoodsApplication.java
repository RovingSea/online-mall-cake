package com.wu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 商品服务启动器
 * @author Haixin Wu
 * @date 2021/12/16
 * @time 18:10
 * @since 1.0
 */
@SpringBootApplication
public class OMCGoodsApplication {
    public static void main(String[] args) {
        SpringApplication.run(OMCGoodsApplication.class, args);
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(OMCGoodsApplication.class);
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}

