package com.javahunter.redisdemo.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import java.time.Duration;

/**
 * This configuration class sets up the Redis caching infrastructure.
 * It has two beans one for a RedisTemplate to interact with Redis and
 * another for configuring how caching should work
 */
@EnableCaching
@Configuration
@RequiredArgsConstructor
public class RedisConfiguration {

    /**
     * Instance of RedisSerializer for serializing strings
     */
    private final RedisSerializer<String> stringSerializer = RedisSerializer.string();

    /**
     * Instance of RedisSerializer for serializing object likely in JSON format
     */
    private final RedisSerializer<Object> objectRedisSerializer = RedisSerializer.json();

    /**
     * Duration object representing a Time-to-live for cached items(set to 6 hrs)
     */
    private final Duration ttl = Duration.ofHours(6);

    /**
     * This method configures and provides a RedisTemplate bean that is
     * initialized with the specified RedisConnectionFactory. This bean
     * can be injected into other parts of the Spring application and
     * perform various Redis operations like caching, reading and writing
     * data to a Redis server
     *
     * @param redisConnectionFactory: automatically injected by spring. represents
     *                              the connection factory used to establish a connection
     *                              to the Redis server
     * @return redisTemplate: used to interact with Redis in the Spring application
     */
    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }

    /**
     * This method creates and configures a RedisCacheConfiguration bean
     * that specifies how caching should be handled when using Redis as the
     * caching provider. Sets up key and value serialization methods and defines
     * the time-to-live for cache enteries.
     * This configuration can be injected into the Redis cache manager to control
     * the caching behavior in Spirng app.
     * @return RedisCacheConfiguration: used when configuring the Redis cache manager
     */
    @Bean
    public RedisCacheConfiguration redisCacheConfiguration(){
        return
                RedisCacheConfiguration
                        .defaultCacheConfig()
                        .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(stringSerializer))
                        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(objectRedisSerializer))
                        .entryTtl(ttl);
    }

}
