package com.javahunter.redisdemo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "country")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long id;

    @Column(unique = true)
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
