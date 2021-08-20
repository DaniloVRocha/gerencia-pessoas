package com.gerenciapessoas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gerenciapessoas.dto.request.PessoaDTO;
import com.gerenciapessoas.dto.response.MessageResponseDTO;
import com.gerenciapessoas.entity.Pessoa;
import com.gerenciapessoas.exception.PessoaNaoEncontradaException;
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
		return createMethodResponse(pessoaSalva, "Pessoa Criada com Sucesso");
	}

	public List<PessoaDTO> listarTodos() {
		List<Pessoa> todasAsPessoas = pessoaRepository.findAll();
		return todasAsPessoas.stream().map(pessoaMapper::toDTO).collect(Collectors.toList());
	}

	public PessoaDTO buscarId(Long id) throws PessoaNaoEncontradaException {
		Pessoa pessoa = verificarExistencia(id);
		return pessoaMapper.toDTO(pessoa);
	}

	public void excluir(Long id) throws PessoaNaoEncontradaException {
		verificarExistencia(id);
		pessoaRepository.deleteById(id);
	}

	public MessageResponseDTO updatePessoaId(Long id, PessoaDTO pessoaDTO) throws PessoaNaoEncontradaException {
		verificarExistencia(id);

		Pessoa pessoaEditar = pessoaMapper.toModel(pessoaDTO);
		Pessoa pessoaEditada = pessoaRepository.save(pessoaEditar);

		return createMethodResponse(pessoaEditada, "Pessoa Editada com Sucesso");
	}

	private MessageResponseDTO createMethodResponse(Pessoa pessoa, String s) {
		return MessageResponseDTO.builder().message(s + pessoa.getId()).build();
	}

	private Pessoa verificarExistencia(Long id) throws PessoaNaoEncontradaException {
		return pessoaRepository.findById(id).orElseThrow(() -> new PessoaNaoEncontradaException(id));
	}

}
