package com.rs.service;

import com.rs.domain.YmDomains;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author it006
* @description 针对表【ym_domains】的数据库操作Service
* @createDate 2025-07-17 09:32:58
*/
public interface YmDomainsService extends IService<YmDomains> {
    void updateAllDomainExpiries();
}
