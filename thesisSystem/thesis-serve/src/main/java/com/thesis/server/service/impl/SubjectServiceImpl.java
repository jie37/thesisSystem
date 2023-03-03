package com.thesis.server.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thesis.server.mapper.SubjectMapper;
import com.thesis.server.pojo.RespBean;
import com.thesis.server.pojo.RespPageBean;
import com.thesis.server.pojo.Subject;
import com.thesis.server.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 课题信息 服务实现类
 * </p>
 *
 * @author lzj
 * @since 2022-10-21
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements ISubjectService {
    @Autowired
    private SubjectMapper subjectMapper;

    /**
     * 获取所有论文
     * @param currenPage
     * @param size
     * @param subject
     * @return
     */
    @Override
    public RespPageBean getThesisByPage(Integer currenPage, Integer size, Subject subject) {
        //开启分页
        Page<Subject> page =new Page<>(currenPage,size);
        IPage<Subject> subjectByPage =subjectMapper.getThesisByPage(page,subject);
        return new RespPageBean(subjectByPage.getTotal(),subjectByPage.getRecords());
    }

    /**
     * 添加论文题目
     * @param thesis
     * @return
     */
    @Override
    public RespBean addThesis(Subject thesis) {
        if(1==subjectMapper.insert(thesis)){
            return RespBean.success("添加成功!");
        }
        return RespBean.error("添加失败！");
    }
}
