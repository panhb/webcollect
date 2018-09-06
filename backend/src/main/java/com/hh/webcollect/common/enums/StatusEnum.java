package com.hh.webcollect.common.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
public enum StatusEnum {

    /**
     * 生效
     */
    E("E","生效"),

    /**
     * 失效
     */
    D("D","失效");

    private static Map<String, StatusEnum> enum_map = Maps.newHashMap();

    static {
        for (StatusEnum as : StatusEnum.values()) {
            enum_map.put(as.code, as);
        }
    }

    public static StatusEnum getByCode(String code) {
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

    StatusEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
