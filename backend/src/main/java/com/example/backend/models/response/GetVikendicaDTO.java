package com.example.backend.models.response;


import com.example.backend.models.Vikendica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetVikendicaDTO {
    private Vikendica vikendica;
    private boolean daLiJeTrenutniUserVlasnik;
}