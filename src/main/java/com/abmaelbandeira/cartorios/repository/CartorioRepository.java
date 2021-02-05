package com.abmaelbandeira.cartorios.repository;

import com.abmaelbandeira.cartorios.model.Cartorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartorioRepository extends JpaRepository<Cartorio, Long> {
}
