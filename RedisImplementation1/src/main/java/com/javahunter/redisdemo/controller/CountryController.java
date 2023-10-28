package com.javahunter.redisdemo.controller;

import com.javahunter.redisdemo.dto.CountryDto;
import com.javahunter.redisdemo.entity.Country;
import com.javahunter.redisdemo.mapper.CountryMapper;
import com.javahunter.redisdemo.service.interfaces.CountryServices;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/countries")
@Slf4j
public class CountryController {

    private final CountryServices countryServices;
    private final CountryMapper countryMapper;

    @GetMapping("/get")
    public List<Country> getAllCountries(){
        return countryServices.getAllCountries();
    }

    @PostMapping("/insert")
    public ResponseEntity<CountryDto> insertCountry(@RequestBody CountryDto countryDto){
        Country mappedCountry = countryMapper.toCountry(countryDto);
        Country country = countryServices.insertCountry(mappedCountry);
        return ResponseEntity.ok(countryMapper.fromCountry(country));
    }

    @GetMapping("/names")
    public ResponseEntity<List<String>> getAllCountryNames(){
        log.info("Inside Get All CountryNames API");
        List<String> countries = countryServices.findAllCountryNames();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }

    @PostMapping("/insert-all")
    public List<Country> insertCountries(@RequestBody List<CountryDto> countryDtos){
        log.info("Inside Insert All countries API");
        return countryServices.insertCountries(countryDtos);
    }
}