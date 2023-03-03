package com.thesis.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.thesis.server.mapper.ManagerMapper;
import com.thesis.server.pojo.Manager;
import com.thesis.server.pojo.User;
import com.thesis.server.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.management.Query;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lzj
 * @since 2022-10-21
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements IManagerService {

    @Autowired
    private ManagerMapper managerMapper;
    @Override
    public Manager getManagerInfo() {
        return managerMapper.selectOne(new QueryWrapper<Manager>().eq("M_id",((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()));
    }
}
