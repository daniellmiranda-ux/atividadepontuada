package com.example.atividade.controller;

import com.example.atividade.model.EntregadorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {

    @Autowired
    private EntregadorService service;

    @GetMapping
    public List<EntregadorModel> listar(){
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Map<String,Object>> salvar(@RequestBody EntregadorModel e){
        service.salvar(e);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensagem","Cadastrado com sucesso."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>> atualizar(@PathVariable Long id, @RequestBody EntregadorModel e){
        service.atualizar(id,e);
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