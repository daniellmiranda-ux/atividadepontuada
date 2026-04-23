package com.example.atividade.service;

import com.example.atividade.model.ClienteModel;
import com.example.atividade.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public ClienteModel salvar(ClienteModel c){
        if(repository.findByEmail(c.getEmail()).isPresent()){
            throw new RuntimeException("Cliente já cadastrado.");
        }
        return repository.save(c);
    }

    public List<ClienteModel> listar(){
        return repository.findAll();
    }

    public ClienteModel atualizar(Long id, ClienteModel c){
        if(!repository.existsById(id)){
            throw new RuntimeException("Cliente não encontrado.");
        }
        c.setId(id);
        return repository.save(c);
    }

    public void excluir(Long id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Cliente não encontrado.");
        }
        repository.deleteById(id);
    }
}