package com.rs.controller;


import com.rs.controller.base.BaseController;
import com.rs.domain.YmDomains;
import com.rs.service.YmDomainsService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/ymdq")
@Api(tags = "域名控制器")
public class YmDomainsController  extends BaseController<YmDomains, YmDomainsService> {

    @Autowired
    public YmDomainsController(YmDomainsService service) {
        super(service, YmDomains.class);
    }

    @GetMapping("/update-all")
    public String updateAll() {
        service.updateAllDomainExpiries();
        return "更新完成";
    }

}