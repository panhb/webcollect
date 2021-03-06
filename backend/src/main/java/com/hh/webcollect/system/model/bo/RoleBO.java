package com.hh.webcollect.system.model.bo;

import com.hh.webcollect.common.model.BaseBO;
import lombok.Data;

/**
 * @author hongbo.pan
 * @date 2018/8/31
 */
@Data
public class RoleBO extends BaseBO {

    /**
     * 角色编码
     */
    private String code;

    /**
     * 角色名称
     */
    private String name;

}
