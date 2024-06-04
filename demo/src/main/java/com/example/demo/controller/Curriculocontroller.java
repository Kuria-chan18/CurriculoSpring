package com.example.demo.controller;
import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curriculo")

public class Curriculocontroller {

    @Autowired
    private Curriculoservice curriculoService;

    @GetMapping
    public List<Curriculo> getAllCurriculos() {
        return curriculoService.getAllCurriculos();
    }

    @GetMapping("/{id}")
    public Optional<Curriculo> getCurriculoById(@PathVariable Long id) {
        return curriculoService.getCurriculoById(id);
    }

    @PostMapping
    public Curriculo criarCurriculo(@RequestBody Curriculo curriculo) {
        return curriculoService.criarCurriculo(curriculo);
    }

    @PutMapping("/{id}")
    public Curriculo atualizarCurriculo(@PathVariable Long id, @RequestBody Curriculo curriculoDetails) throws Exception {
        return curriculoService.atualizarCurriculo(id, curriculoDetails);
    }


    @DeleteMapping("/{id}")
    public void deletarCurriculo(@PathVariable Long id) {
        curriculoService.deletarCurriculo(id);
    }

}