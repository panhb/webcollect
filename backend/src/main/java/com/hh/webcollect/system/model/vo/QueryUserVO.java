package com.hh.webcollect.system.model.vo;

import com.hh.webcollect.common.model.PageVO;
import io.swagger.annotations.ApiParam;
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
    @ApiParam(name = "username", value = "用户名")
    private String username;

    /**
     * 用户昵称
     */
    @ApiParam(name = "nickname", value = "用户昵称")
    private String nickname;

    /**
     * 备注
     */
    @ApiParam(name = "remark", value = "备注")
    private String remark;

    /**
     * 分页排序条件
     */
    @NotNull
    private PageVO pageVO;

}
