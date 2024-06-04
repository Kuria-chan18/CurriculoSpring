package com.example.demo.service;

import java.util.List;
import java.util.Optional;
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

    public Optional<Curriculo> getCurriculoById(Long id) {
        return curriculoRepository.findById(id);
    }

    //public Optional<Curriculo> getCurriculoByDetails(String nome, String email, String telefone, String graduacao) {
        //return curriculoRepository.findByNomeAndEmailAndTelefoneAndGraduacao(nome, email, telefone, graduacao);
    //}

    public Curriculo criarCurriculo(Curriculo curriculo) {
        return curriculoRepository.save(curriculo);
    }

    public void deletarCurriculo(Long id) {
        curriculoRepository.deleteById(id);
    }

    public Curriculo atualizarCurriculo(Long id, Curriculo curriculoDetails) {
      
        throw new UnsupportedOperationException("Unimplemented method 'atualizarCurriculo'");
    }
}