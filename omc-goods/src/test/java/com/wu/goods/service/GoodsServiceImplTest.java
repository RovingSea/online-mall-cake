package com.wu.goods.service;

import com.sun.glass.ui.Application;
import com.wu.OMCGoodsApplication;
import com.wu.common.domain.Goods;
import com.wu.goods.service.impl.GoodsServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Haixin Wu
 * @date 2021/12/16
 * @time 20:26
 * @since 1.0
 */
@SpringBootTest
public class GoodsServiceImplTest {
    @Autowired
    private GoodsServiceImpl goodsService;
    @Test
    public void test(){
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(OMCGoodsApplication.class);
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }
        Goods goods = new Goods();
        goods.setName("邵雪平蛋糕");
        boolean insert = goodsService.insert(goods);
        System.out.println(insert);
    }
}

