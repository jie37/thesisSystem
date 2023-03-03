package com.thesis.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thesis.server.mapper.StudentMapper;
import com.thesis.server.mapper.TranscriptsMapper;
import com.thesis.server.pojo.RespBean;
import com.thesis.server.pojo.Student;
import com.thesis.server.pojo.Transcripts;
import com.thesis.server.pojo.User;
import com.thesis.server.service.ITranscriptsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzj
 * @since 2022-10-21
 */
@Service
public class TranscriptsServiceImpl extends ServiceImpl<TranscriptsMapper, Transcripts> implements ITranscriptsService {

    @Autowired
    private TranscriptsMapper transcriptsMapper;

    @Override
    public RespBean chooseThesis(Transcripts transcripts) {
        if (transcriptsMapper.selectOne(new QueryWrapper<Transcripts>()
                .eq("Stu_id",
                        ((User) SecurityContextHolder
                                .getContext()
                                .getAuthentication()
                                .getPrincipal())
                                .getId())) == null) {
            if (1 == transcriptsMapper.insert(transcripts)) {
                return RespBean.success("选题成功");
            }
            return RespBean.error("选题失败!");
        }
        return RespBean.error("已选题，不可再选");
    }

}
