package com.example.atividade.service;

import com.example.atividade.model.ProdutoModel;
import com.example.atividade.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public ProdutoModel salvar(ProdutoModel p){
        if(repository.findBylote(p.getLote()).isPresent()){
            throw new RuntimeException("Produto já cadastrado.");
        }
        return repository.save(p);
    }

    public List<ProdutoModel> listar(){
        return repository.findAll();
    }

    public ProdutoModel atualizar(Long id, ProdutoModel p){
        if(!repository.existsById(id)){
            throw new RuntimeException("Produto não encontrado.");
        }
        p.setId(id);
        return repository.save(p);
    }

    public void excluir(Long id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Produto não encontrado.");
        }
        repository.deleteById(id);
    }
}
}
