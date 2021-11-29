package com.example.ISA2021.Repository;


import com.example.ISA2021.Models.Vikendica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VikendicaRepository extends JpaRepository<Vikendica, Long>  {
}
