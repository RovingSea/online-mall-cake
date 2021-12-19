package com.wu.common.utility;

import org.modelmapper.ModelMapper;

/**
 * @author Haixin Wu
 * @date 2021/12/19 22:43
 * @since 1.0
 */
public class ModelMapperSingle {

    private ModelMapperSingle(){

    }

    private static class InstanceHolder{
        private static final ModelMapper INSTANCE = new ModelMapper();
    }

    public static ModelMapper instance(){
        return InstanceHolder.INSTANCE;
    }

}

