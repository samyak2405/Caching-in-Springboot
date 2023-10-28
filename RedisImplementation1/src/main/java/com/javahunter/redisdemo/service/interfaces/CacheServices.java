package com.javahunter.redisdemo.service.interfaces;

import org.springframework.stereotype.Service;

@Service
public interface CacheServices {

    void evictCacheValues(String cacheName);
}
