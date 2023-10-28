package com.javahunter.redisdemo.controller;

import com.javahunter.redisdemo.constants.CacheNames;
import com.javahunter.redisdemo.service.interfaces.CacheServices;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cache")
public class CacheController {
    private final CacheServices cacheServices;

    @DeleteMapping("/names/evict")
    public Boolean evictCountryNamesCache(){
        cacheServices.evictCacheValues(CacheNames.COUNTRY_NAMES);
        return true;
    }
}

