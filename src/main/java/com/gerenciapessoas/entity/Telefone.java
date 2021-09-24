package com.gerenciapessoas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.gerenciapessoas.enums.TipoTelefone;

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
public class Telefone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	@ApiModelProperty(name = "tipo", notes = "Tipo", value = "MOVEL", required = true)
	@NotNull(message="O campo tipo é obrigatório")
	private TipoTelefone tipo;

	@Column(nullable = false)
	@ApiModelProperty(name = "tipo", notes = "Tipo", value = "(61)99990810", required = true)
	@NotNull(message="o campo telefone é obrigatório")
	private String number;

}
