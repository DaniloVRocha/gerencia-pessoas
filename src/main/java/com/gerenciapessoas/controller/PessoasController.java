package com.gerenciapessoas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciapessoas.dto.request.PessoaDTO;
import com.gerenciapessoas.dto.response.MessageResponseDTO;
import com.gerenciapessoas.exception.PessoaNaoEncontradaException;
import com.gerenciapessoas.services.PessoaService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/pessoas")
@AllArgsConstructor( onConstructor = @__(@Autowired))
public class PessoasController {
	
	private PessoaService pessoaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO criarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
		return pessoaService.criarPessoa(pessoaDTO);
	}
	
	@GetMapping
	public List<PessoaDTO> listarTodos(){
		return pessoaService.listarTodos();	
	}
	
	@GetMapping("/{id}")
	public PessoaDTO buscarId(@PathVariable Long id) throws PessoaNaoEncontradaException {
		return pessoaService.buscarId(id);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO updatePessoa(@PathVariable Long id, @RequestBody @Valid PessoaDTO pessoaDTO) throws PessoaNaoEncontradaException {
		return pessoaService.updatePessoaId(id, pessoaDTO);	
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluirPessoaId(@PathVariable Long id) throws PessoaNaoEncontradaException {
		pessoaService.excluir(id);
	}

}
