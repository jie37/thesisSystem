package com.thesis.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thesis.server.mapper.TeacherMapper;
import com.thesis.server.pojo.Teacher;
import com.thesis.server.pojo.User;
import com.thesis.server.service.ITeacherService;
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
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher getTeacherByUserId() {
        return teacherMapper.selectOne(new QueryWrapper<Teacher>().eq("T_id",((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()));
    }
}
