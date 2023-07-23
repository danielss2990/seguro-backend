package com.devsuperior.dslist.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Double valorUnitario;
    private Double valorTotal;
    List<GarantiaDTO> garantias = new ArrayList<>();

    public ItemDTO(){

    }

    public ItemDTO(Long id, Double valorUnitario, Double valorTotal) {
        this.id = id;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public List<GarantiaDTO> getGarantias() {
        return garantias;
    }

    public void setGarantias(List<GarantiaDTO> garantias) {
        this.garantias = garantias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemDTO itemDTO = (ItemDTO) o;
        return id.equals(itemDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
