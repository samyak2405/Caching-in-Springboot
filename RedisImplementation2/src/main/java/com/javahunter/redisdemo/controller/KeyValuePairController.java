package com.javahunter.redisdemo.controller;

import com.javahunter.redisdemo.entity.KeyValuePair;
import com.javahunter.redisdemo.service.KeyValuePairService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class KeyValuePairController {

    private final KeyValuePairService keyValuePairService;

    @GetMapping("/get/{key}")
    public KeyValuePair getByKey(@PathVariable("key") String key){
        log.info("Inside get by key controller");
        return keyValuePairService.findByKey(key);
    }

    @PostMapping("/save")
    public void create(@RequestBody KeyValuePair keyValuePair){
        log.info("Inside create controller");
        keyValuePairService.save(keyValuePair);
    }
}
