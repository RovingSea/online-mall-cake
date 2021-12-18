package com.wu.common.domain.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 角色枚举<br>
 * <li>0代表消费者
 * <li>1代表管理员
 * @author Haixin Wu
 * @date 2021/12/17 17:13
 * @since 1.0
 */
@Getter
public enum RoleEnum {

    USER(false, "用户"),
    ADMIN( true, "管理员");

    private final boolean isAdmin;
    private final String name;

    RoleEnum(boolean isAdmin, String name) {
        this.isAdmin = isAdmin;
        this.name = name;
    }

    private static final Map<Boolean, String> keyMap = new HashMap<>();

    static {
        for (RoleEnum value : RoleEnum.values()) {
            keyMap.put(value.isAdmin, value.getName());
        }
    }

    public static String getName(boolean isAdmin){
        return keyMap.get(isAdmin);
    }
}
