package com.example.backend.repository;

import com.example.backend.models.Brod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrodRepository extends JpaRepository<Brod, Long> {

}
