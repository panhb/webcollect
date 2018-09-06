package com.hh.webcollect.system.model.bo;

import com.hh.webcollect.common.model.BaseBO;
import lombok.Data;

/**
 * @author hongbo.pan
 * @date 2018/8/31
 */
@Data
public class ModuleBO extends BaseBO {

    /**
     * 模块code
     */
    private String code;

    /**
     * 模块名称
     */
    private String name;

}
