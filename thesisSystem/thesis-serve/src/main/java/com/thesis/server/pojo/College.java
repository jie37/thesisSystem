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
 * @since 2022-10-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="College对象", description="")
public class College implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "系编号")
    @TableId("Depar_id")
    private String deparId;

    @ApiModelProperty(value = "系名称")
    @TableField("Depar_name")
    private String deparName;


}
