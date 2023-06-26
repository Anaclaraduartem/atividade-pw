package br.com.etec.ana.trabalhoapietec.projections;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResumoContasPagar {

    private Integer id;
    private LocalDate data;
    private LocalDate datavencimento;
    private BigDecimal valor;
    private String nome;


    public ResumoContasPagar(Integer id, LocalDate data, LocalDate datavencimento, BigDecimal valor, String nome){
        this.id = id;
        this.data = data;
        this.datavencimento = datavencimento;
        this.valor = valor;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
