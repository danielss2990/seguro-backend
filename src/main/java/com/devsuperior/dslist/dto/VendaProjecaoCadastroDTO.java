package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.projections.VendaProjection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VendaProjecaoCadastroDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long vendaID;
    private List<InsertVendaDTO> itensVendidos;

    public VendaProjecaoCadastroDTO(){

    }

    public VendaProjecaoCadastroDTO(Long vendaID) {
        this.vendaID = vendaID;
    }


    public Long getVendaID() {
        return vendaID;
    }

    public void setVendaID(Long vendaID) {
        this.vendaID = vendaID;
    }

    public List<InsertVendaDTO> getItensVendidos() {
        return itensVendidos;
    }

    public void setItensVendidos(List<InsertVendaDTO> itensVendidos) {
        this.itensVendidos = itensVendidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendaProjecaoCadastroDTO that = (VendaProjecaoCadastroDTO) o;
        return vendaID == that.vendaID && itensVendidos.equals(that.itensVendidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendaID);
    }
}
