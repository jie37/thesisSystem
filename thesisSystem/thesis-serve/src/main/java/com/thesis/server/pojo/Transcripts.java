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
@ApiModel(value="Transcripts对象", description="")
public class Transcripts implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "学生学号")
    @TableId("Stu_id")
    private String stuId;

    @ApiModelProperty(value = "课题编号")
    @TableField("Sub_id")
    private String subId;

    @ApiModelProperty(value = "成绩")
    @TableField("Grades")
    private String Grades;

    @ApiModelProperty(value = "评语")
    @TableField("Comments")
    private String Comments;


}
