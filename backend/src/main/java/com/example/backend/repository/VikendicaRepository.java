package com.example.backend.repository;

import com.example.backend.models.Vikendica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VikendicaRepository extends JpaRepository<Vikendica, Long> {
}