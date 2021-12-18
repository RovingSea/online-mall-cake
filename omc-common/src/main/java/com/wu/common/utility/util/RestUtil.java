package com.wu.common.utility.util;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import com.wu.common.utility.http.RestResponse;
import com.wu.common.utility.http.SystemCode;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 通常用在不需要Spring MVC支持时，使用该工具类可以返回{@link com.wu.common.utility.http.RestResponse}格式数据
 * @author Haixin Wu
 * @date 2021/12/17 12:55
 * @since 1.0
 */
public class RestUtil {
    private static final Logger logger = LoggerFactory.getLogger(RestUtil.class);


    public static void response(HttpServletResponse response, SystemCode systemCode) {
        response(response, systemCode.getCode(), systemCode.getMessage());
    }

    public static void response(HttpServletResponse response, int systemCode, String msg) {
        response(response, systemCode, msg, null);
    }

    public static void response(HttpServletResponse response, int systemCode, String msg, Object content) {
        try {
            RestResponse res = new RestResponse<>(systemCode, msg, content);
            String resStr = JsonUtil.toJsonStr(res);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(resStr);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }
}

