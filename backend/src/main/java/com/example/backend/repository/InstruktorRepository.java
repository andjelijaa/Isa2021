package com.example.backend.repository;

import com.example.backend.models.Instruktor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstruktorRepository extends JpaRepository<Instruktor, Long> {
    Optional<Instruktor> findByInstruktorId(int instruktorId);
}
