package com.thesis.server.controller;


import com.thesis.server.pojo.RespBean;
import com.thesis.server.pojo.Student;
import com.thesis.server.pojo.Transcripts;
import com.thesis.server.service.IStudentService;
import com.thesis.server.service.ITranscriptsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzj
 * @since 2022-10-21
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private ITranscriptsService transcriptsService;

    @ApiOperation(value = "获取学生用户的信息")
    @GetMapping("/info")
    public Student getStudentInfo(){
        return studentService.getStudentByUserId();
    }

    @ApiOperation(value = "选题")
    @PostMapping("/chooseThesis")
    public RespBean chooseThesis(@RequestBody Transcripts transcripts){

        return transcriptsService.chooseThesis(transcripts);
    }
    @ApiOperation(value = "退选")
    @DeleteMapping("/{stuId}")
    public RespBean withdrawThesis(@PathVariable String stuId){
        if( transcriptsService.removeById(stuId)){
            return RespBean.success("退选成功");
        }return RespBean.error("退选失败!");
    }
}
