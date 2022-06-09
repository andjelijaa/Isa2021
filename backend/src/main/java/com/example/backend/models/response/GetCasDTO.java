package com.example.backend.models.response;

import com.example.backend.models.Cas;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCasDTO {
    private Cas cas;
    private boolean daLiJeTrenutniUserVlasnik;
}