package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/curriculo")
public class CurriculoController {
    @Autowired
    private CurriculoService curriculoService;

    @GetMapping
    public List<Curriculo> getAllCurriculos() {
        return curriculoService.getAllCurriculos();
    }

    @PostMapping
    public ResponseEntity<Curriculo> createCurriculo(@RequestBody Curriculo curriculo) {
        Optional<Curriculo> existingCurriculo = curriculoService.getCurriculoByDetails(
            curriculo.getNome(),
            curriculo.getEmail(),
            curriculo.getTelefone(),
            curriculo.getGraduacao()
        );

        if (existingCurriculo.isPresent()) {
            return ResponseEntity.ok(existingCurriculo.get());
        } else {
            Curriculo newCurriculo = curriculoService.saveCurriculo(curriculo);
            return ResponseEntity.ok(newCurriculo);
        }
    }

    @DeleteMapping
    public ResponseEntity<String> deleteCurriculo(@RequestBody Curriculo curriculo) {
        Optional<Curriculo> existingCurriculo = curriculoService.getCurriculoByDetails(
            curriculo.getNome(),
            curriculo.getEmail(),
            curriculo.getTelefone(),
            curriculo.getGraduacao()
        );

        if (existingCurriculo.isPresent()) {
            curriculoService.deleteCurriculo(existingCurriculo.get().getId());
            return ResponseEntity.ok("Registro removido com sucesso");
        } else {
            return ResponseEntity.status(404).body("Registro não encontrado");
        }
    }
}