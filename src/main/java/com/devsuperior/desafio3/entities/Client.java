package com.devsuperior.desafio3.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Entity
@Table(name = "tb_client")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min = 2, max = 100, message = "Nome de ter no mínimo 2 e no máximo 100 carateres")
    @Pattern(regexp = "^[A-Za-zÀ-ÿ ]+$", message = "Nome deve conter apenas letras")
    String name;

    @CPF(message = "CPF inválido")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos")
    @NotBlank(message = "CPF é obrigatório")
    String cpf;

    @NotNull(message = "Renda é obrigatória")
    @Positive(message = "Renda deve ser maior que zero")
    Double income;

    @PastOrPresent(message = "Data de nascimento não pode ser uma data futura")
    LocalDate birthDate;

    @PositiveOrZero(message = "Quantidade de filhos deve ser zero ou um número inteiro positivo")
    Integer children;
}
