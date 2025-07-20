package com.rs.service;

import com.rs.domain.AppVersion;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

/**
* @author it006
* @description 针对表【app_version】的数据库操作Service
* @createDate 2025-07-16 09:56:13
*/
public interface AppVersionService extends IService<AppVersion> {
    AppVersion getLatestVersion();

    AppVersion getByVersionCode(Long id);
}
