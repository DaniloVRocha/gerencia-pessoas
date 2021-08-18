package com.gerenciapessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciapessoas.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
