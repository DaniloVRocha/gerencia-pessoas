package com.gerenciapessoas.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(name = "id", notes = "Id Product")
	private Long id;

	@Column(nullable = false)
	@ApiModelProperty(name = "firstName", notes = "First Name", value = "Danilo Vieira", required = true)
	@NotNull(message="Campo First Name Requerido")
	private String firstName;

	@Column(nullable = false)
	@ApiModelProperty(name = "lastName", notes = "Last Name", value = "Rocha", required = true)
	@NotNull(message="Campo lastName Requerido")
	private String lastName;

	@Column(nullable = false, unique = true)
	@ApiModelProperty(name = "cpf", notes = "CPF", value = "09232951002", required = true)
	@NotNull(message="Campo CPF Requerido")
	private String cpf;
	
	private LocalDate birthDate;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.PERSIST, CascadeType.REMOVE })
	private List<Telefone> telefones;



}
