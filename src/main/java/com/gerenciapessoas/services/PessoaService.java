package com.gerenciapessoas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gerenciapessoas.dto.request.PessoaDTO;
import com.gerenciapessoas.dto.response.MessageResponseDTO;
import com.gerenciapessoas.entity.Pessoa;
import com.gerenciapessoas.mapper.PessoaMapper;
import com.gerenciapessoas.repository.PessoaRepository;

@Service
public class PessoaService {

	private PessoaRepository pessoaRepository;
	private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;
	
	
	public PessoaService() {
		super();
	}

	@Autowired
	public PessoaService(PessoaRepository pessoaRepository) {
		super();
		this.pessoaRepository = pessoaRepository;
	}

	public MessageResponseDTO criarPessoa(@RequestBody PessoaDTO pessoaDTO) {
		Pessoa pessoaSalvar = pessoaMapper.toModel(pessoaDTO);
		
		
		Pessoa pessoaSalva = pessoaRepository.save(pessoaSalvar);
		return MessageResponseDTO
				.builder()
				.message("Pessoa Criada Com Sucesso, ID:" + pessoaSalva.getId())
				.build();
	}

}
