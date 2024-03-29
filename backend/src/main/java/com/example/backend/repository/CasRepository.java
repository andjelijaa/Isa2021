package com.example.backend.repository;

import com.example.backend.models.Cas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CasRepository extends JpaRepository<Cas, Long> {

}
