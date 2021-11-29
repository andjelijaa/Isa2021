package com.example.ISA2021.Repository;

import com.example.ISA2021.Models.Brod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrodRepository extends JpaRepository<Brod, Long> {
}
