package com.hh.webcollect.system.model.vo;

import com.hh.webcollect.common.model.PageVO;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author hongbo.pan
 * @date 2018/8/31
 */
@Data
public class QueryUserVO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 备注
     */
    private String remark;

    /**
     * 分页排序条件
     */
    @NotNull
    private PageVO pageVO;

}
