package br.com.etec.ana.trabalhoapietec.repository.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class ContasFilter {

    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate data;

    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate datavencimento;

    private BigDecimal valor;
    private String nome;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getDatavencimento() {
        return datavencimento;
    }

    public void setDatavencimento(LocalDate datavencimento) {
        this.datavencimento = datavencimento;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}