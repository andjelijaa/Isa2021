package com.example.backend.repository;

import com.example.backend.models.Akcija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AkcijaRepository extends JpaRepository<Akcija, Long> {


}