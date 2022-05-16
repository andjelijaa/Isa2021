package com.example.backend.repository;

import com.example.backend.models.Cenovnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenovnikRepository extends JpaRepository<Cenovnik, Long> {
}