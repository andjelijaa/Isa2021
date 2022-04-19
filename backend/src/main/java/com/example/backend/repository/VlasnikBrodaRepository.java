package com.example.backend.repository;

import com.example.backend.models.VlasnikBroda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VlasnikBrodaRepository extends JpaRepository<VlasnikBroda, Long> {
}
