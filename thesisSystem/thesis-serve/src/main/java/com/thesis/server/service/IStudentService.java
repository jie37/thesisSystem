package com.thesis.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thesis.server.pojo.RespBean;
import com.thesis.server.pojo.Student;
import com.thesis.server.pojo.Transcripts;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lzj
 * @since 2022-10-21
 */
public interface IStudentService extends IService<Student> {

   Student getStudentByUserId();

    RespBean addStudent(Student student);

}
