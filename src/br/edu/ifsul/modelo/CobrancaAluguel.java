/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Larissa
 */
@Entity
@Table(name = "cobranca_contrato")
public class CobrancaAluguel implements Serializable{
    
    @EmbeddedId    
    private CobrancaAluguelID cobrancaID;
    
    @NotNull(message = "O valor deve ser informado")
    @Column(name = "valor", nullable = false, columnDefinition = "decimal(10,2)")
    private Double valor;
    
    @NotNull(message = "O vencimento deve ser informado")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_vencimento", nullable = false)
    private Calendar vencimento;

    @Column(name = "valor_pagamento", columnDefinition = "decimal(10,2)")
    private Double valorPagamento;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "data_pagamento")
    private Calendar dataPagamento;
    
    @Column(name = "observacao", columnDefinition = "text")
    private String observacao;

    public CobrancaAluguel() {
    }

    public CobrancaAluguelID getCobrancaID() {
        return cobrancaID;
    }

    public void setCobrancaID(CobrancaAluguelID cobrancaID) {
        this.cobrancaID = cobrancaID;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Calendar getVencimento() {
        return vencimento;
    }

    public void setVencimento(Calendar vencimento) {
        this.vencimento = vencimento;
    }

    public Double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Calendar dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.cobrancaID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CobrancaAluguel other = (CobrancaAluguel) obj;
        if (!Objects.equals(this.cobrancaID, other.cobrancaID)) {
            return false;
        }
        return true;
    }
    
    

    
    
}
