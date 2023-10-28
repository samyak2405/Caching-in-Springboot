package com.javahunter.redisdemo.config;

import com.javahunter.redisdemo.constants.CacheNames;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

/**
 * This configuration sets up caching in a springboot application using Redis as the cache store.
 * Customizes the TTL for cache enteries based on the properties.
 */

@EnableCaching
@Configuration
public class RedisConfig {

    @Value("${cache.config.entryTtl:60}")
    private int entryTtl;

    @Value("${cache.config.countryNames.entryTtl:30}")
    private int countryNamesEntryTtl;

    /**
     * This method defines the configuration for the default cache.
     * It sets the TTL for cache enteries using the entryTtl property value.
     * It disables caching of null values.
     * It specifies that cache values should be serialized using the GenericJackson2JsonRedisSerializer
     * that means data stored in cache will be serialized as JSON
     * @return
     */
    @Bean
    public RedisCacheConfiguration cacheConfiguration(){
        return RedisCacheConfiguration
                .defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(entryTtl))
                .disableCachingNullValues()
                .serializeValuesWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }

    /**
     * This method configures a custom Redis cache manager for a specific cache named COUNTRY_NAMES.
     * Sets the TTL for cache enteries using countryNamesEntryTtl property value.
     * Used to customize the Redis cache manager's behavior.
     * @return
     */
    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer(){
        return builder -> {
          var countryNamesConf = RedisCacheConfiguration.defaultCacheConfig()
                  .entryTtl(Duration.ofMinutes(countryNamesEntryTtl));
          builder.withCacheConfiguration(CacheNames.COUNTRY_NAMES,countryNamesConf);
        };
    }
}
