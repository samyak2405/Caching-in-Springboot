package com.javahunter.redisdemo.repository;

import com.javahunter.redisdemo.entity.KeyValuePair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyValuePairRepository extends JpaRepository<KeyValuePair,Long> {
    KeyValuePair findByKey(String key);
}
