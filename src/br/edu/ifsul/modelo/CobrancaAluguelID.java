/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Larissa
 */
@Embeddable
public class CobrancaAluguelID implements Serializable{
    
    @NotNull(message = "O número deve ser informado")
    @Min(value = 1, message = "O número deve ser maior ou igual a 1")
    @Column(name = "numero", nullable = false)
    private Integer id;
    
    @NotNull(message = "O contrato deve ser informado")
    @ManyToOne
    @JoinColumn(name = "contrato", referencedColumnName = "id", nullable = false)
    private Contrato contrato;

    public CobrancaAluguelID() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final CobrancaAluguelID other = (CobrancaAluguelID) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
