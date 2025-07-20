package com.rs.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.rs.domain.AppVersion;
import com.rs.exception.pojo.vo.ResultResponse;
import com.rs.service.AppVersionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/version")
@Api(tags = "更新控制器")
public class UpdateController {

    @Autowired
    private AppVersionService versionService;

    @ApiOperation("获取版本列表")
    @GetMapping("/list")
    public ResultResponse list(@RequestParam int page, @RequestParam int pageSize) {
        Page<AppVersion> pageInfo = new Page<>(page, pageSize);
        versionService.page(pageInfo, new QueryWrapper<>());
        return ResultResponse.success(pageInfo);
    }
    @ApiOperation("上传安装包")
    @PostMapping("/upload")
    public ResultResponse upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResultResponse.error("文件为空");
        }

        String uploadDirPath = System.getProperty("user.dir") + "/upload"; // 项目根目录下的 upload 文件夹
        String originalFilename = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String newFileName = uuid + "_" + originalFilename;

        File targetFile = new File(uploadDirPath, newFileName);

        // 确保目录存在
        File parentDir = targetFile.getParentFile();
        if (!parentDir.exists()) {
            parentDir.mkdirs();
        }

        try {
            file.transferTo(targetFile);
            String filePath = targetFile.getAbsolutePath();
            Map<String, Object> result = new HashMap<>();
            result.put("fileUrl", filePath);
            return ResultResponse.success(result);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultResponse.error("上传失败：" + e.getMessage());
        }
    }


    @ApiOperation("创建新版本")
    @PostMapping("/create")
    public ResultResponse create(@RequestBody AppVersion version) {
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        version.setCreateTime(date);
        version.setUpdateTime(date);
        versionService.save(version);
        return ResultResponse.success();
    }

    @ApiOperation("更新版本信息")
    @PutMapping("/update/{id}")
    public ResultResponse update(@PathVariable Long id, @RequestBody AppVersion version) {
        version.setId(id);
        LocalDateTime localDateTime = LocalDateTime.now();
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        version.setUpdateTime(date);
        versionService.updateById(version);
        return ResultResponse.success();
    }

    @ApiOperation("删除版本")
    @DeleteMapping("/delete/{id}")
    public ResultResponse delete(@PathVariable Long id) {
        versionService.removeById(id);
        return ResultResponse.success("删除成功");
    }

    @ApiOperation("客户端检查版本")
    @GetMapping("/check")
    public ResultResponse checkVersion(@RequestParam String version) {
        AppVersion latest = versionService.getLatestVersion();
        boolean needUpdate = !latest.getVersionName().equals(version);
        return ResultResponse.success(new VersionCheckResponse(needUpdate, latest));
    }

    @ApiOperation("客户端下载版本")
    @GetMapping("/download/{id}")
    public void download(@PathVariable Long id, javax.servlet.http.HttpServletResponse response) throws IOException {
        AppVersion version = versionService.getByVersionCode(id);
        File file = new File(version.getFileUrl());
        if (!file.exists()) {
            response.setStatus(404);
            return;
        }
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
        java.nio.file.Files.copy(file.toPath(), response.getOutputStream());
        response.flushBuffer();
    }

    // 内部类：客户端更新检查响应结构
    public static class VersionCheckResponse {
        public boolean needUpdate;
        public AppVersion latest;
        public VersionCheckResponse(boolean needUpdate, AppVersion latest) {
            this.needUpdate = needUpdate;
            this.latest = latest;
        }
    }
}

