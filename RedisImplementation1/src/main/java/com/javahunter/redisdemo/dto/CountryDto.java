package com.javahunter.redisdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountryDto {
    private Long id;
    private String code;
    private String name;
    private String nativeName;
    private int phone;
    private String capital;
    private String continent;
    private String currency;
    private String language;
    private String flag;
}
