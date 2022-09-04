package com.example.backend.repository;

import com.example.backend.models.Rezervacija;
import com.example.backend.models.User;
import com.example.backend.models.Vikendica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija, Long> {
    public Rezervacija findByIdAndBrodId(Long id, Long brodId);
    public Rezervacija findByIdAndCasId(Long id, Long brodId);
    public Rezervacija findByIdAndVikendicaId(Long id, Long brodId);
    public Rezervacija findByUserAndVikendica(User user, Vikendica vikendica);

    List<Rezervacija> findByIdAndVikendicaIdOrderByDatumPocetkaAsc(Long id, Long vikendicaId);

    List<Rezervacija> findByIdAndVikendicaIdOrderByCenaAsc(Long id, Long vikendicaId);

    List<Rezervacija> findByIdAndVikendicaIdOrderByTrajanjeAsc(Long id, Long vikendicaId);

    List<Rezervacija> findByIdAndBrodIdOrderByDatumPocetkaAsc(Long id, Long vikendicaId);

    List<Rezervacija> findByIdAndBrodIdOrderByCenaAsc(Long id, Long vikendicaId);

    List<Rezervacija> findByIdAndBrodIdOrderByTrajanjeAsc(Long id, Long vikendicaId);

    List<Rezervacija> findByIdAndCasIdOrderByCenaAsc(Long id, Long vikendicaId);

    List<Rezervacija> findByIdAndCasIdOrderByDatumPocetkaAsc(Long id, Long vikendicaId);

    List<Rezervacija> findByIdAndCasIdOrderByTrajanjeAsc(Long id, Long vikendicaId);
}
