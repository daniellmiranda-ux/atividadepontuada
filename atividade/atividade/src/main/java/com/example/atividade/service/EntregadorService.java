package com.example.atividade.service;

import com.example.atividade.model.EntregadorModel;
import com.example.atividade.repository.EntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregadorService {

    @Autowired
    private EntregadorRepository repository;

    public EntregadorModel salvar(EntregadorModel e){
        if(repository.findByEmail(e.getEmail()).isPresent()){
            throw new RuntimeException("Entregador já cadastrado.");
        }
        return repository.save(e);
    }

    public List<EntregadorModel> listar(){
        return repository.findAll();
    }

    public EntregadorModel atualizar(Long id, EntregadorModel e){
        if(!repository.existsById(id)){
            throw new RuntimeException("Entregador não encontrado.");
        }
        e.setId(id);
        return repository.save(e);
    }

    public void excluir(Long id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Entregador não encontrado.");
        }
        repository.deleteById(id);
    }
}
