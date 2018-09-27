package com.hh.webcollect.system.model.bo;

import com.hh.webcollect.common.model.BaseBO;
import lombok.Data;

/**
 * @author hongbo.pan
 * @date 2018/9/4
 */
@Data
public class PermissionBO extends BaseBO {

    /**
     * 权限code
     */
    private String code;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 模块code
     */
    private String moduleCode;

    /**
     * url地址
     */
    private String url;
}
