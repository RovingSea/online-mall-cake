package com.wu.goods.service;

import com.sun.glass.ui.Application;
import com.wu.OMCGoodsApplication;
import com.wu.common.domain.Goods;
import com.wu.goods.service.impl.GoodsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Base64;

/**
 * @author Haixin Wu
 * @date 2021/12/16 20:26
 * @since 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OMCGoodsApplication.class)
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
        goods.setName("ceshi1");
        goods.setImage1("12312312");
        boolean insert = goodsService.insert(goods);
        System.out.println(insert);
        Goods goods1 = goodsService.selectById(10);
        System.out.println(goods1);
    }
}

