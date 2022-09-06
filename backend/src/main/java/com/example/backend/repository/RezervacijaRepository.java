package com.example.backend.repository;

import com.example.backend.models.Rezervacija;
import com.example.backend.models.User;
import com.example.backend.models.Vikendica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija, Long> {

    Rezervacija findByKlijentIdAndEntitetId(Long id, Long entitetId);

    Optional<Rezervacija> findByIdAndKlijentIdAndEntitetId(Long id, Long klijentId, Long entitetId);

    Optional<List<Rezervacija>> findAllByOrderByCenaAsc();

    Optional<List<Rezervacija>> findAllByOrderByDatumOdAsc();
    Optional<Rezervacija> findByEntitetIdAndZauzetoTrue(Long id);
    Optional<List<Rezervacija>> findAllByOrderByTrajanjeAsc();
    Optional<Rezervacija> findByIdAndKlijentId(Long rezervacijaId, Long id);
}
