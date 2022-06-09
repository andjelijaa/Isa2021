package com.example.backend.models.response;


import com.example.backend.models.Brod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetBrodDTO {
    private Brod brod;
    private boolean daLiJeTrenutniUserVlasnik;
}