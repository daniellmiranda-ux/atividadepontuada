package com.example.atividade.controller;

import com.example.atividade.model.ClienteModel;
import com.example.atividade.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public List<ClienteModel> listar(){
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Map<String,Object>> salvar(@RequestBody ClienteModel c){
        service.salvar(c);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensagem","Cadastrado com sucesso."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>> atualizar(@PathVariable Long id, @RequestBody ClienteModel c){
        service.atualizar(id,c);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem","Atualizado com sucesso."));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Object>> excluir(@PathVariable Long id){
        service.excluir(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("mensagem","Excluído com sucesso."));
    }
}
