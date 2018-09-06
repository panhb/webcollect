package com.hh.webcollect.system.model.vo;

import com.hh.webcollect.common.model.BaseVO;
import lombok.Data;

/**
 * @author hongbo.pan
 * @date 2018/8/31
 */
@Data
public class ModuleVO extends BaseVO {

    /**
     * 模块code
     */
    private String code;

    /**
     * 模块名称
     */
    private String name;

}
