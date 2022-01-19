package com.example.backend.repository;

import com.example.backend.models.Rezervacije;
import com.example.backend.models.Vlasnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RezervacijeRepository extends JpaRepository<Rezervacije, Long> {

  //    public List<Rezervacije> findByVlasnik(Vlasnik v);
}