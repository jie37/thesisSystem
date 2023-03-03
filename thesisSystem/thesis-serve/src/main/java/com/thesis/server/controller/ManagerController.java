package com.thesis.server.controller;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.thesis.server.pojo.Manager;
import com.thesis.server.pojo.RespBean;
import com.thesis.server.pojo.Student;
import com.thesis.server.pojo.Subject;
import com.thesis.server.service.IManagerService;
import com.thesis.server.service.IStudentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lzj
 * @since 2022-10-21
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private IManagerService managerService;
    @Autowired
    private IStudentService studentService;

    @ApiOperation(value="获取管理员信息")
    @GetMapping("/info")
    public Manager getManagerInfo(){
        return managerService.getManagerInfo();
    }

    @ApiOperation(value = "添加学生")
    @PostMapping("/addStudent")
    public RespBean addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @ApiOperation(value = "导入学生")
    @PostMapping(value = "/import")
    public RespBean importStudent(MultipartFile file){
        ImportParams params = new ImportParams();
        try {
            List<Student> list = ExcelImportUtil.importExcel(file.getInputStream(), Student.class, params);
            if(studentService.saveBatch(list)){
                return RespBean.success("导入成功!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return RespBean.error("导入失败！");
    }
}

