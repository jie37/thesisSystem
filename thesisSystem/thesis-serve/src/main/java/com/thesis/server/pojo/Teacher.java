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
@ApiModel(value="Teacher对象", description="")
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工号")
    @TableId("T_id")
    private String tId;

    @ApiModelProperty(value = "教师姓名")
    @TableField("T_name")
    private String tName;

    @ApiModelProperty(value = "教师所在院系")
    @TableField("Depar_id")
    private String deparId;

    @ApiModelProperty(value = "教师性别")
    @TableField("T_sex")
    private String tSex;

    @ApiModelProperty(value = "教师联系方式")
    @TableField("T_phone")
    private String tPhone;

    @ApiModelProperty(value = "教师职位（0为主任,1为普通教师）")
    @TableField("T_posts")
    private String tPosts;


}
