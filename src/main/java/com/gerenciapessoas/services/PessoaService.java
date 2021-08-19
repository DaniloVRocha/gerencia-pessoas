package com.gerenciapessoas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gerenciapessoas.dto.MessageResponseDTO;
import com.gerenciapessoas.entity.Pessoa;
import com.gerenciapessoas.repository.PessoaRepository;

@Service
public class PessoaService {

	private PessoaRepository pessoaRepository;
	
	
	public PessoaService() {
		super();
	}

	@Autowired
	public PessoaService(PessoaRepository pessoaRepository) {
		super();
		this.pessoaRepository = pessoaRepository;
	}

	public MessageResponseDTO criarPessoa(@RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		return MessageResponseDTO
				.builder()
				.message("Pessoa Criada Com Sucesso, ID:" + pessoaSalva.getId())
				.build();
	}

}
