package com.example.backend.repository;

import com.example.backend.models.Entitet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EntitetRepository extends JpaRepository<Entitet, Long> {

    List<Entitet> findAllByVlasnikId(Long id);
    Optional<Entitet> findByIdAndVlasnikId(Long id, Long vlasnikId);
}