package com.wu.common.exception;

/**
 * @author Haixin Wu
 * @date 2021/12/22 21:29
 * @since 1.0
 */
public class GenerateOrdersFailureException extends RuntimeException{
    public GenerateOrdersFailureException(){
        super("生成订单失败");
    }
}

