package com.example.backend.repository;

import com.example.backend.models.Rezervacije;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RezervacijeRepository extends JpaRepository<Rezervacije, Long> {
}