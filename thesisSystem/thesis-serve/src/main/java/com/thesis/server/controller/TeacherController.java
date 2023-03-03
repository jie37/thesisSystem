package com.thesis.server.controller;


import com.thesis.server.pojo.Teacher;
import com.thesis.server.service.ITeacherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzj
 * @since 2022-10-21
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private ITeacherService teacherService;

    @ApiOperation(value = "获取老师用户的信息")
    @GetMapping("/info")
    public Teacher getTeacherInfo(){
        Teacher teacher = teacherService.getTeacherByUserId();
        return teacher;
    }
}
