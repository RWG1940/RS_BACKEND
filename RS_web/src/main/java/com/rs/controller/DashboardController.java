package com.rs.controller;

import com.rs.exception.pojo.vo.ResultResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/dashboard")
@Api(tags = "仪表盘控制器")
public class DashboardController {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/click")
    @ApiOperation("记录按钮点击次数")
    public ResultResponse recordClick(@RequestParam("key") String key) {
        if (key == null || key.trim().isEmpty()) {
            return ResultResponse.error("key 参数不能为空");
        }

        // 显式判断 key 是否存在
        if (Boolean.FALSE.equals(redisTemplate.hasKey(key))) {
            redisTemplate.opsForValue().set(key, 1);
            return ResultResponse.success("首次点击，已初始化为 1 次");
        }

        Long count = redisTemplate.opsForValue().increment(key);
        return ResultResponse.success("点击记录成功，当前次数: " + count);
    }

    @GetMapping("/click-count")
    @ApiOperation("获取按钮点击次数")
    public ResultResponse getClickCount(@RequestParam("key") String key) {
        System.out.println(11111111);
        if (key == null || key.trim().isEmpty()) {
            return ResultResponse.error("key 参数不能为空");
        }

        Object value = redisTemplate.opsForValue().get(key);
        Integer count = value != null ? Integer.parseInt(value.toString()) : 0;

        return ResultResponse.success(count);
    }
}
