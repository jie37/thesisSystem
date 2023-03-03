package com.thesis.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thesis.server.mapper.StudentMapper;
import com.thesis.server.mapper.TranscriptsMapper;
import com.thesis.server.pojo.RespBean;
import com.thesis.server.pojo.Student;
import com.thesis.server.pojo.Transcripts;
import com.thesis.server.pojo.User;
import com.thesis.server.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.List;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzj
 * @since 2022-10-21
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentByUserId() {
        return studentMapper.selectOne(new QueryWrapper<Student>().eq("Stu_id",((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()));
    }

    @Override
    public RespBean addStudent(Student student) {
        if (1==studentMapper.insert(student)){
            return RespBean.success("导入成功");
        }
        return RespBean.error("导入失败!");
    }

}
