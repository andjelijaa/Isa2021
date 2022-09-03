package com.example.backend.repository;

import com.example.backend.models.Rezervacija;
import com.example.backend.models.User;
import com.example.backend.models.Vikendica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezervacijaRepository extends JpaRepository<Rezervacija, Long> {
    public Rezervacija findByIdAndBrodId(Long id, Long brodId);
    public Rezervacija findByIdAndCasId(Long id, Long brodId);
    public Rezervacija findByIdAndVikendicaId(Long id, Long brodId);
   public Rezervacija findByUserAndVikendica(User user, Vikendica vikendica);
}
