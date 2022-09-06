package com.example.backend.repository;

import com.example.backend.models.Brod;
import com.example.backend.models.Cas;
import com.example.backend.models.Vikendica;
import com.example.backend.models.Zalba;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZalbaRepository extends JpaRepository<Zalba, Long> {

}