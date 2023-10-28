package com.javahunter.redisdemo.service.impl;

import com.javahunter.redisdemo.service.interfaces.CacheServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
@Slf4j
public class CacheServiceImpl implements CacheServices {

    private final CacheManager cacheManager;
    @Override
    public void evictCacheValues(String cacheName) {
        Objects.requireNonNull(cacheManager.getCache(cacheName)).clear();
        log.info("All values evicted for cache {}",cacheName);
    }
}
