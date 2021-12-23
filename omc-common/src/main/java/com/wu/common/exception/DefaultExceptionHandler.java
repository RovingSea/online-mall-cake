package com.wu.common.exception;

import com.wu.common.utility.http.RestResponse;
import com.wu.common.utility.http.SystemCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Haixin Wu
 * @date 2021/12/23 10:22
 * @since 1.0
 */
@ControllerAdvice
@Slf4j
public class DefaultExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RestResponse handle (Exception ex){
        log.error("捕获异常：[{}]", ex.getMessage());
        return new RestResponse(SystemCode.InnerError.getCode(), SystemCode.InnerError.getMessage());
    }

}

