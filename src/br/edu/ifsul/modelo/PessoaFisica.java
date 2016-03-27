/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author Larissa
 */
@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa implements Serializable{
    
    @NotBlank(message = "O RG deve ser informado")
    @Length(min = 5, max = 15, message = "o RG deve possui até {max} caracteres.")     
    @Column(name = "rg", length = 15, nullable = false)
    private String rg;
    
    @CPF(message = "Digite um CPF válido")
    @NotBlank(message = "O CPF deve ser informado")
    @Length( max = 14, message = "o RG deve possui até {max} caracteres.")     
    @Column(name = "cpf", length = 14, nullable = false)
    private String cpf;
    
    @NotNull(message = "O nascimento deve ser informado")
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento", nullable = false)
    private Calendar nascimento;
    
    @NotBlank(message = "O passaporte deve ser informado")
    @Length(min = 5, max = 20, message = "O passaporte deve possui até {max} caracteres.")     
    @Column(name = "passaporte", length = 20)
    private String passaporte;

    public PessoaFisica() {
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }
    
    
    
}
