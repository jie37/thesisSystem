package com.thesis.server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author lzj
 * @since 2022-11-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Manager对象", description="")
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工号")
    @TableId("M_id")
    private String mId;

    @ApiModelProperty(value = "姓名")
    @TableField("M_name")
    private String mName;

    @ApiModelProperty(value = "联系方式")
    @TableField("M_phone")
    private String mPhone;


}
