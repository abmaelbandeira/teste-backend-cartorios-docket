package com.abmaelbandeira.cartorios.repository;

import com.abmaelbandeira.cartorios.model.Cartorio;
import com.abmaelbandeira.cartorios.model.Certidao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertidaoRepository extends JpaRepository<Certidao, Long> {
    Iterable<Certidao> findByCartorio(Cartorio cartorio);
}