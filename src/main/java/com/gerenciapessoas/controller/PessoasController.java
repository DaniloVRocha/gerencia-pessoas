package com.gerenciapessoas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciapessoas.dto.MessageResponseDTO;
import com.gerenciapessoas.entity.Pessoa;
import com.gerenciapessoas.repository.PessoaRepository;
import com.gerenciapessoas.services.PessoaService;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoasController {
	
	private PessoaService pessoaService;
	
	@Autowired
	public PessoasController(PessoaService pessoaService) {
		super();
		this.pessoaService = pessoaService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO criarPessoa(@RequestBody Pessoa pessoa) {
		return pessoaService.criarPessoa(pessoa);
	}

}
