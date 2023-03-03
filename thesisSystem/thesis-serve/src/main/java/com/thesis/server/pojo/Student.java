package com.thesis.server.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.List;

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
@ApiModel(value="Student对象", description="")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学生学号")
    @Excel(name="学号")
    @TableId("Stu_id")
    private String stuId;

    @ApiModelProperty(value = "学生姓名")
    @Excel(name="姓名")
    @TableField("Stu_name")
    private String stuName;

    @ApiModelProperty(value = "学生性别")
    @Excel(name="性别")
    @TableField("Stu_sex")
    private String stuSex;

    @ApiModelProperty(value = "学生所在院系编号")
    @Excel(name="所在系")
    @TableField("Depar_id")
    private String deparId;

    @ApiModelProperty(value = "学生联系方式")
    @Excel(name="学生联系方式")
    @TableField("Phone")
    private String phone;

}
