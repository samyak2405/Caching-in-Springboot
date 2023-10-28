package com.javahunter.redisdemo.mapper;

import com.javahunter.redisdemo.dto.CountryDto;
import com.javahunter.redisdemo.entity.Country;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    Country toCountry(CountryDto countryDto);
    CountryDto fromCountry(Country country);
}
