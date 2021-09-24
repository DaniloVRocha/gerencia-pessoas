package com.gerenciapessoas.controller;

import java.util.ArrayList;
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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import lombok.AllArgsConstructor;

@Api(value = "PessoasController", tags = {"PessoasController"})
@SwaggerDefinition(tags= {@Tag(name="Pessoas Controller",
	description="CRUD in REST for PessoasController")
})
@RestController
@RequestMapping("/api/v1/pessoas")
@AllArgsConstructor( onConstructor = @__(@Autowired))
public class PessoasController {
	
	private PessoaService pessoaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Salvar Nova Pessoa")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Ok"),
			@ApiResponse(code=500, message="Error server Internal"),
	})
	public MessageResponseDTO criarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
		return pessoaService.criarPessoa(pessoaDTO);
	}
	
	@GetMapping
	@ApiOperation(value="Listar todas as Pessoas", response= ArrayList.class)
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Ok"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=401, message="Error Permission")
	})
	public List<PessoaDTO> listarTodos(){
		return pessoaService.listarTodos();	
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value="Listar pessoa por ID")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Ok"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=401, message="Error Permission")
	})
	public PessoaDTO buscarId(@PathVariable Long id) throws PessoaNaoEncontradaException {
		return pessoaService.buscarId(id);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value="Update pessoa")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Ok"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=401, message="Error Permission")
	})
	public MessageResponseDTO updatePessoa(@PathVariable Long id, @RequestBody @Valid PessoaDTO pessoaDTO) throws PessoaNaoEncontradaException {
		return pessoaService.updatePessoaId(id, pessoaDTO);	
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="Excluir pessoa")
	@ApiResponses(value = {
			@ApiResponse(code=200, message="Ok"),
			@ApiResponse(code=404, message="Not Found"),
			@ApiResponse(code=401, message="Error Permission")
	})
	public void excluirPessoaId(@PathVariable Long id) throws PessoaNaoEncontradaException {
		pessoaService.excluir(id);
	}

}
