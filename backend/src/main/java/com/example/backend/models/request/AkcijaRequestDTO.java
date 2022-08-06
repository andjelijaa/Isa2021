package com.example.backend.models.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AkcijaRequestDTO {
    private Long id;
    private Date datumOd;
    private Date datumDo;
    private String tipAkcije;
}