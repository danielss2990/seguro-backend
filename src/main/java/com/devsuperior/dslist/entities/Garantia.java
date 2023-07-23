package com.devsuperior.dslist.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_garantia")
public class Garantia implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;
    private Double valor;
    private Integer prazo;

    @ManyToMany(mappedBy = "garantias")
    private Set<Produto> produtos =  new HashSet<>();


    public Garantia()
    {

    }
    public Garantia(Long id, String nome, Double valor, Integer prazo) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garantia garantia = (Garantia) o;
        return id.equals(garantia.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
