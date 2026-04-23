package com.example.atividade.repository;

import com.example.atividade.model.EntregadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntregadorRepository extends JpaRepository<EntregadorModel, Long> {
    Optional<EntregadorModel> findByEmail(String email);
}
