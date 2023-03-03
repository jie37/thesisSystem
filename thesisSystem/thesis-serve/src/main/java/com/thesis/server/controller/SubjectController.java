package com.thesis.server.controller;


import com.thesis.server.pojo.RespBean;
import com.thesis.server.pojo.RespPageBean;
import com.thesis.server.pojo.Subject;
import com.thesis.server.service.ISubjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 * 课题信息 前端控制器
 * </p>
 *
 * @author lzj
 * @since 2022-10-21
 */
@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    private ISubjectService subjectService;

    @ApiOperation(value = "获取论文题目")
    @GetMapping("/info")
   public RespPageBean getThesis(@RequestParam(defaultValue = "1" )Integer currenPage,
                                 @RequestParam(defaultValue = "10") Integer size,
                                 Subject subject){
        return subjectService.getThesisByPage(currenPage,size,subject);
    }
    @ApiOperation(value = "添加论文题目")
    @PostMapping("/addThesis")
    public RespBean addThesis(@RequestBody Subject thesis){
     return subjectService.addThesis(thesis);
    }
}
