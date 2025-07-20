package com.rs.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rs.domain.AppVersion;
import com.rs.service.AppVersionService;
import com.rs.mapper.AppVersionMapper;
import org.springframework.stereotype.Service;

/**
* @author it006
* @description 针对表【app_version】的数据库操作Service实现
* @createDate 2025-07-16 09:56:12
*/
@Service
public class AppVersionServiceImpl extends ServiceImpl<AppVersionMapper, AppVersion>
    implements AppVersionService{
    @Override
    public AppVersion getLatestVersion() {
        QueryWrapper<AppVersion> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("create_time").last("LIMIT 1");
        return this.getOne(queryWrapper, false); // 第二个参数表示不抛异常
    }
    @Override
    public AppVersion getByVersionCode(Long id) {
        QueryWrapper<AppVersion> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("version_code", id);
        return this.getOne(queryWrapper, false);
    }
}




