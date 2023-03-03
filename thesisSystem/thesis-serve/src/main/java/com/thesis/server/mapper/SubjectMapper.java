package com.thesis.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.thesis.server.pojo.Subject;
import org.apache.ibatis.annotations.Param;


/**
 * <p>
 * 课题信息 Mapper 接口
 * </p>
 *
 * @author lzj
 * @since 2022-10-21
 */
public interface SubjectMapper extends BaseMapper<Subject> {

    /**
     * 获取所有论文
     * @param page
     * @param subject
     * @return
     */
    IPage <Subject> getThesisByPage(Page<Subject> page,
                                   @Param("subject")Subject subject);
}
