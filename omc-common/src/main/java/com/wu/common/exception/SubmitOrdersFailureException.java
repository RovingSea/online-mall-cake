package com.wu.common.exception;

/**
 * @author Haixin Wu
 * @date 2021/12/22 23:51
 * @since 1.0
 */
public class SubmitOrdersFailureException extends RuntimeException{
    public SubmitOrdersFailureException(){
        super("提交订单失败");
    }
}

