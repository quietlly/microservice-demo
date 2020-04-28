package com.mic.pro.data.redis;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;

@Configuration
public class RedisConfig {

	@Bean
	public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
		RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
		RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig();
		defaultCacheConfig.entryTtl(Duration.ofSeconds(3000));
		RedisCacheManager cacheManager = new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
		return cacheManager;
	}

	@Bean
	public RedisTemplate redisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate template = new RedisTemplate<>();

		template.setEnableTransactionSupport(true); //打开事务支持
		template.setKeySerializer(RedisSerializer.string());
		template.setValueSerializer(RedisSerializer.json());
		template.setHashKeySerializer(RedisSerializer.json());
		template.setHashValueSerializer(RedisSerializer.json());
		template.setConnectionFactory(connectionFactory);
		template.afterPropertiesSet();

		return template;
	}
}
