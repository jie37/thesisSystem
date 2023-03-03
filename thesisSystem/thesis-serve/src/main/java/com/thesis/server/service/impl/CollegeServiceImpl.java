package com.thesis.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thesis.server.mapper.CollegeMapper;
import com.thesis.server.pojo.College;
import com.thesis.server.service.ICollegeService;
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
public class CollegeServiceImpl extends ServiceImpl<CollegeMapper, College> implements ICollegeService {

}
