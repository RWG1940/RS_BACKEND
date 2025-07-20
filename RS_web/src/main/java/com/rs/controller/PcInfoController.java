package com.rs.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rs.controller.base.BaseController;
import com.rs.domain.PcInfo;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.service.PcInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/pcInfo")
public class PcInfoController extends BaseController<PcInfo, PcInfoService> {

    @Autowired
    public PcInfoController(PcInfoService pcInfoService) {
        super(pcInfoService, PcInfo.class);
    }

    @Override
    @PostMapping
    public ResultResponse add(@RequestBody PcInfo entity) {
        // 使用 QueryWrapper 根据 IP 查重
        QueryWrapper<PcInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ip", entity.getIp());

        PcInfo existing = service.getOne(queryWrapper);

        if (existing != null) {
            // 如果 IP 已存在，进行更新操作
            existing.setMemoryTotal(entity.getMemoryTotal());
            existing.setMemoryUsage(entity.getMemoryUsage());
            existing.setDiskList(entity.getDiskList());
            existing.setEmpName(entity.getEmpName());
            existing.setUpdateTime(Timestamp.valueOf(LocalDateTime.now())); // 更新当前时间为更新时间

            // 执行更新
            boolean success = service.updateById(existing);
            return success ? ResultResponse.success("更新成功") : ResultResponse.error("更新失败");
        } else {
            // 如果 IP 不存在，进行插入操作
            entity.setCreateTime(Timestamp.valueOf(LocalDateTime.now())); // 设置创建时间
            entity.setUpdateTime(Timestamp.valueOf(LocalDateTime.now())); // 设置更新时间

            boolean success = service.save(entity);
            return success ? ResultResponse.success("添加成功") : ResultResponse.error("添加失败");
        }
    }
}