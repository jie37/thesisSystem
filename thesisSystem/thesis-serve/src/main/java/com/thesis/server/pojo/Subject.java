package com.thesis.server.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 课题信息
 * </p>
 *
 * @author lzj
 * @since 2022-10-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Subject对象", description="课题信息")
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "题目编号")
    @TableId("Sub_id")
    private String subId;

    @ApiModelProperty(value = "题目名称")
    @TableField("Sub_name")
    private String subName;

    @ApiModelProperty(value = "题目内容")
    @TableField("Introduce")
    private String Introduce;

    @ApiModelProperty(value = "参与学生上限")
    @TableField("Part_num")
    private Integer partNum;

    @ApiModelProperty(value = "审核状态（0未审核，1审核通过，2审核未通过）")
    @TableField("Postil_flag")
    private String postilFlag;


}
