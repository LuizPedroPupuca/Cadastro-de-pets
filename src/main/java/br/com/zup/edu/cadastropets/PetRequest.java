package br.com.zup.edu.cadastropets;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class PetRequest {
    @NotBlank(message = "O campo nome é obrigatório")
    private String nome;

    @NotNull(message = "O campo data de nascimento é obrigatório")
    @PastOrPresent(message = "A data de nascimento tem que estar no passado ou presente")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull(message = "O campo tipo é obrigatório")
    private Tipo tipo;

    @NotBlank(message = "O campo raça é obrigatório")
    private String raca;

    public PetRequest(String nome, LocalDate dataNascimento, Tipo tipo, String raca) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.tipo = tipo;
        this.raca = raca;
    }

    public PetRequest() {
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public String getRaca() {
        return raca;
    }

    public Pet toModel() {
        return new Pet(nome, dataNascimento, tipo, raca);
    }
}
