package com.gerenciapessoas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciapessoas.dto.MessageResponseDTO;
import com.gerenciapessoas.entity.Pessoa;
import com.gerenciapessoas.repository.PessoaRepository;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoasController {
	
	private PessoaRepository pessoaRepository;
	
	@Autowired
	public PessoasController(PessoaRepository pessoaRepository) {
		super();
		this.pessoaRepository = pessoaRepository;
	}


	@PostMapping
	public MessageResponseDTO criarPessoa(@RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		return MessageResponseDTO
								.builder()
								.message("Pessoa Criada Com Sucesso, ID:" + pessoaSalva.getId())
								.build();
	}

}
