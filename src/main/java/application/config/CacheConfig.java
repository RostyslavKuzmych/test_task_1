package application.config;

import application.dto.internal.GeneralAllDto;
import application.model.SalesAndTrafficByAsinEntity;
import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class CacheConfig {
    Map<String, RedisCacheConfiguration> cacheTypeConfiguration = new HashMap<>();

    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
        initCacheTypeConfiguration();
        return RedisCacheManager.builder(redisConnectionFactory)
                .cacheDefaults(getDefaultCacheConfiguration())
                .withInitialCacheConfigurations(cacheTypeConfiguration)
                .build();
    }

    private void initCacheTypeConfiguration() {
        putCacheNameGenericTtlTime("getSalesAndTrafficByDate", 5, GeneralAllDto.class);
        putCacheNameGenericTtlTime("getSalesAndTrafficByAsin", 5, SalesAndTrafficByAsinEntity.class);
        putCacheNameGenericTtlTime("getSalesAndTrafficByDateAll", 5, GeneralAllDto.class);
        putCacheNameGenericTtlTime("getSalesAndTrafficByAsinAll", 5, GeneralAllDto.class);
    }

    private RedisCacheConfiguration getDefaultCacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(1))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer(objectMapper())));
    }

    private void putCacheNameGenericTtlTime(String name, int minutes, Class clazz) {
        cacheTypeConfiguration.put(name, RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(minutes))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new FastJsonRedisSerializer<>(clazz))));
    }

    private ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.USE_BIG_DECIMAL_FOR_FLOATS, true);
        return objectMapper;
    }
}