package com.javahunter.redisdemo.service;

import com.javahunter.redisdemo.entity.KeyValuePair;
import com.javahunter.redisdemo.repository.KeyValuePairRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KeyValuePairServiceImpl implements KeyValuePairService{
    private final KeyValuePairRepository keyValuePairRepository;

    @Override
    @Cacheable(value = "myCache",key = "#key",condition = "#key.startsWith('frequent_')")
    public KeyValuePair findByKey(String key){
        log.info("Inside find by key service");
        return keyValuePairRepository.findByKey(key);
    }

    @Override
    @CacheEvict(value = "myCache",key = "#keyValuePair.key")
    public void save(KeyValuePair keyValuePair){
        log.info("Inside save key service");
        keyValuePairRepository.save(keyValuePair);
    }
}
