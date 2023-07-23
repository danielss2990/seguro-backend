package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Garantia;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

public class GarantiaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private Double valor;
    private Integer prazo;

    public GarantiaDTO(){

    }
    public GarantiaDTO(Garantia entity){
        BeanUtils.copyProperties(entity, this);
    }

    public GarantiaDTO(Long id, String nome, Double valor, Integer prazo) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.prazo = prazo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getPrazo() {
        return prazo;
    }

    public void setPrazo(Integer prazo) {
        this.prazo = prazo;
    }
}
