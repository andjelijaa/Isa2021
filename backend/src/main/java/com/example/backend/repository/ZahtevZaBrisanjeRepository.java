package com.example.backend.repository;


import com.example.backend.models.ZahtevZaBrisanje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ZahtevZaBrisanjeRepository extends JpaRepository<ZahtevZaBrisanje, Long> {
    Optional<List<ZahtevZaBrisanje>> findAllByIzbrisanFalse();
}