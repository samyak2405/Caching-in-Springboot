package com.javahunter.redisdemo.service.impl;

import com.javahunter.redisdemo.constants.CacheNames;
import com.javahunter.redisdemo.dto.CountryDto;
import com.javahunter.redisdemo.entity.Country;
import com.javahunter.redisdemo.mapper.CountryMapper;
import com.javahunter.redisdemo.repository.CountryRepository;
import com.javahunter.redisdemo.service.interfaces.CountryServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CountryServiceImpl implements CountryServices {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;
    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Cacheable(CacheNames.COUNTRY_NAMES)
    @Override
    public List<String> findAllCountryNames() {
        log.info("Inside Country names service method");
        List<String> countries =  countryRepository.findAllCountryNames();
        log.info("No of items: {}",countries.size());
        return countries;
    }

    @Caching(
            evict = {
                    @CacheEvict(
                            value = CacheNames.COUNTRY_NAMES,
                            allEntries = true,
                            condition = "@country.code!=null")})
    @Override
    public List<Country> insertCountries(List<CountryDto> countryDtos) {
        log.info("Inside insert All countries service");
        List<Country> countries = new ArrayList<>();
        countryDtos.forEach(countryDto -> countries.add(countryMapper.toCountry(countryDto)));

        return countryRepository.saveAll(countries);
    }

    @Caching(
            evict = {
                    @CacheEvict(
                            value = CacheNames.COUNTRY_NAMES,
                            allEntries = true,
                            condition = "@country.code!=null")})
    @Override
    public Country insertCountry(Country country) {
        return countryRepository.save(country);
    }
}
