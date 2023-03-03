package com.thesis.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.thesis.server.pojo.RespBean;
import com.thesis.server.pojo.RespPageBean;
import com.thesis.server.pojo.Subject;


/**
 * <p>
 * 课题信息 服务类
 * </p>
 *
 * @author lzj
 * @since 2022-10-21
 */
public interface ISubjectService extends IService<Subject> {


    /**
     * 获取所有论文
     * @param currenPage
     * @param size
     * @param subject
     * @return
     */
    RespPageBean getThesisByPage(Integer currenPage, Integer size, Subject subject);

    /**
     * 添加论文题目
     * @param thesis
     * @return
     */
    RespBean addThesis(Subject thesis);
}
