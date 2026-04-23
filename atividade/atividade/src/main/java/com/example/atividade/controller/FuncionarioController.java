package com.example.atividade.controller;

import com.example.atividade.model.FuncionarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public List<FuncionarioModel> listar(){
        return service.listar;
    }

    @PostMapping
    public ResponseEntity<Map<String,Object>> salvar(@RequestBody FuncionarioModel f){
        service.salvar(f);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensagem","Cadastrado com sucesso."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>> atualizar(@PathVariable Long id, @RequestBody FuncionarioModel f){
        service.atualizar(id,f);
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