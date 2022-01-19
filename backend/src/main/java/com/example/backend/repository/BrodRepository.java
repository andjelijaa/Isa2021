package com.example.backend.repository;

import com.example.backend.models.Brod;
import com.example.backend.models.VlasnikBroda;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrodRepository extends JpaRepository<Brod, Long> {

}
