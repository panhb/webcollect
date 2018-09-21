package com.hh.webcollect.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
public enum NotifyToTypeEnum {

    /**
     * 角色
     */
    ROLE("ROLE","角色"),

    /**
     * 用户
     */
    USER("USER","用户");

    private static Map<String, NotifyToTypeEnum> enum_map = Maps.newHashMap();

    static {
        for (NotifyToTypeEnum as : NotifyToTypeEnum.values()) {
            enum_map.put(as.code, as);
        }
    }

    public static NotifyToTypeEnum getByCode(String code) {
        return enum_map.get(code);
    }

    /** 类型编码 */
    private String code;

    /** 描述 */
    private String desc;

    /**
     * @return 类型编码
     */
    public String getCode() {
        return code;
    }

    /**
     * @return 描述
     */
    public String getDesc() {
        return desc;
    }

    NotifyToTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
