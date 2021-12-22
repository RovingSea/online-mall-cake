package com.wu.common.base;

import com.wu.common.utility.ModelMapperSingle;
import org.modelmapper.ModelMapper;

/**
 * 各模块Controller的祖先<br>
 * 为各个Controller提供业务会用到的属性
 * @author Haixin Wu
 * @date 2021/12/18 17:27
 * @since 1.0
 */
public class BaseController {
    protected final static ModelMapper MODEL_MAPPER = ModelMapperSingle.instance();
}

