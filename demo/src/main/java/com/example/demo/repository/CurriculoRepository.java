package com.example.demo.repository;

import com.example.demo.model.Curriculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

import java.util.Optional;

public interface CurriculoRepository extends JpaRepository<Curriculo, Long> {
    Optional<Curriculo> findByNomeAndEmailAndTelefoneAndGraduacao(String nome, String email, String telefone, String graduacao);
}