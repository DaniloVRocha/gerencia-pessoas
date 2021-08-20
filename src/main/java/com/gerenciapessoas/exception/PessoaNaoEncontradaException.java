package com.gerenciapessoas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaNaoEncontradaException extends Exception{


	public PessoaNaoEncontradaException(Long id) {
		super("Pessoa Não Encontrada com o ID: " + id);
		
	}

}
