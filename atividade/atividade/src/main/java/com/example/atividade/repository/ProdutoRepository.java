package com.example.atividade.repository;

import com.example.atividade.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository {
    public interface Produtorepository extends JpaRepository<ProdutoModel, Long> {
        Optional<ProdutoModel> findByLote(String lote);
    }
}
