package com.example.atividade.controller;

import com.example.atividade.model.ProdutoModel;
import com.example.atividade.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<ProdutoModel> listar(){
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Map<String,Object>> salvar(@RequestBody ProdutoModel p){
        service.salvar(p);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensagem","Cadastrado com sucesso."));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String,Object>> atualizar(@PathVariable Long id, @RequestBody ProdutoModel p){
        service.atualizar(id,p);
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