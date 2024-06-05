package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Curriculo;
import com.example.demo.repository.Curriculorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Curriculoservice {
    
    @Autowired
    private Curriculorepository curriculoRepository;

    public List<Curriculo> getAllCurriculos() {
        return curriculoRepository.findAll();
    }

    public Optional<Curriculo> getCurriculoById(UUID id) {
        return curriculoRepository.findById(id);
    }

    //public Optional<Curriculo> getCurriculoByDetails(String nome, String email, String telefone, String graduacao) {
        //return curriculoRepository.findByNomeAndEmailAndTelefoneAndGraduacao(nome, email, telefone, graduacao);
    //}

    public Curriculo criarCurriculo(Curriculo curriculo) {
        return curriculoRepository.save(curriculo);
    }

    public void deletarCurriculo(UUID id) {
        curriculoRepository.deleteById(id);
    }

    public Curriculo atualizarCurriculo(UUID id, Curriculo curriculoDetails) {
      
        throw new UnsupportedOperationException("Unimplemented method 'atualizarCurriculo'");
    }

    public Optional<Curriculo> CurriculoId(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'CurriculoId'");
    }
}