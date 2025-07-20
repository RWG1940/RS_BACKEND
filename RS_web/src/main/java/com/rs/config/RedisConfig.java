package com.rs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(org.springframework.data.redis.connection.RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        // 使用 StringRedisSerializer 来序列化/反序列化键
        template.setKeySerializer(new StringRedisSerializer());

        // 使用 GenericJackson2JsonRedisSerializer 来序列化/反序列化值（支持任何类型）
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        // 设置 hash 的 key 和 value 序列化器
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        template.afterPropertiesSet();
        return template;
    }
}
