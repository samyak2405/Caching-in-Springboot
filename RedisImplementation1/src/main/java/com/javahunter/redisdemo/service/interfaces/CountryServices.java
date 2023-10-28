package com.javahunter.redisdemo.service.interfaces;

import com.javahunter.redisdemo.dto.CountryDto;
import com.javahunter.redisdemo.entity.Country;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CountryServices {
    List<Country> getAllCountries();
    List<String> findAllCountryNames();
    List<Country> insertCountries(List<CountryDto> countryDtos);
    Country insertCountry(Country country);
}
