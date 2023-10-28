package com.javahunter.redisdemo.service;

import com.javahunter.redisdemo.entity.KeyValuePair;
import org.springframework.stereotype.Service;

@Service
public interface KeyValuePairService {
    KeyValuePair findByKey(String key);
    void save(KeyValuePair keyValuePair);
}
