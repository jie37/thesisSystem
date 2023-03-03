package com.thesis.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thesis.server.pojo.Teacher;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lzj
 * @since 2022-10-21
 */
public interface ITeacherService extends IService<Teacher> {

    Teacher getTeacherByUserId();
}
