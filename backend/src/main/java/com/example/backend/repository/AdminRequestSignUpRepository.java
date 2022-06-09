package com.example.backend.repository;


import com.example.backend.models.request.AdminRequestSignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRequestSignUpRepository extends JpaRepository<AdminRequestSignUp, Long> {
}
