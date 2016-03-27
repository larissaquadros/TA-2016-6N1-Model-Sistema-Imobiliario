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
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author Larissa
 */
@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa implements Serializable{
    
    @NotBlank(message = "A Inscrição estadual deve ser informada")
    @Length(min = 5, max = 15, message = " Inscrição estadual deve possui até {max} caracteres.")     
    @Column(name = "ie", length = 15, nullable = false)
    private String ie;
    
    @CNPJ(message = "Digite um CNPJ válido")
    @NotBlank(message = "O CNPJ deve ser informado")
    @Length( max = 18, message = "O CNPJ deve possui até {max} caracteres.")     
    @Column(name = "cnpj", length = 18, nullable = false, unique = true)
    private String cnpj;
    
    @NotEmpty
    @NotBlank(message = "O nome fantasia deve ser informado")
    @Length(max = 150, message = "O nome fantasia deve possui até {max} caracteres.")
    @Column(name = "nome_fantasia", length = 150, nullable = false)
    private String nome_fantasia;
    
    @NotNull(message = "A data fundação deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_fundacao", nullable = false)
    private Calendar data_fundacao;

    public PessoaJuridica() {
    }

    public String getIe() {
        return ie;
    }

    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome_fantasia() {
        return nome_fantasia;
    }

    public void setNome_fantasia(String nome_fantasia) {
        this.nome_fantasia = nome_fantasia;
    }

    public Calendar getData_fundacao() {
        return data_fundacao;
    }

    public void setData_fundacao(Calendar data_fundacao) {
        this.data_fundacao = data_fundacao;
    }
    
    
}
