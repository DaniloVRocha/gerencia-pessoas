package com.gerenciapessoas.dto.request;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.gerenciapessoas.entity.Telefone;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {
	
	private Long id;
	
	@NotEmpty
	@Size(min=2, max=100)
	@ApiModelProperty(name = "firstName", notes = "First Name", value = "Danilo Vieira", required = true)
	private String firstName;
	
	@NotEmpty
	@Size(min=2, max=100)
	@ApiModelProperty(name = "lastName", notes = "Last Name", value = "Rocha", required = true)
	private String lastName;
	
	@NotEmpty
	@CPF
	@ApiModelProperty(name = "cpf", notes = "CPF", value = "09232951002", required = true)
	private String cpf;

	private LocalDate birthDate;
	
	@Valid
	@NotEmpty
	private List<Telefone> telefones;


}
