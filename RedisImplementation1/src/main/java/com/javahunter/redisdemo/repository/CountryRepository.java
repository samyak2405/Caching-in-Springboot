package com.javahunter.redisdemo.repository;

import com.javahunter.redisdemo.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country,Long> {

    @Query(value = "SELECT c.name FROM country c",nativeQuery = true)
    List<String> findAllCountryNames();
}
