/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Larissa
 */
@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements Serializable{
    
   @Id
    
    @SequenceGenerator(name = "seq_pessoa", sequenceName = "seq_pessoa_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_pessoa", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotEmpty
    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 150, message = "O nome deve possui até {max} caracteres.")
    @Column(name = "nome", length = 150, nullable = false)
    private String nome;
    
    @NotEmpty
    @NotBlank(message = "o email deve ser informado")    
    @Length(max = 50, message = "O email deve possui até {max} caracteres.")
    @Column(name = "email", length = 50, nullable = false)
    private String email;
       
    @NotBlank(message = "O bairro deve ser informado")
    @Length(max = 40, message = "O bairro deve possuir até {max} caracteres.")     
    @Column(name = "bairro", length = 14, nullable = false)
    private String bairro;
    
    @NotBlank(message = "O endereço deve ser informado")
    @Length(max = 90, message = "O endereço deve possuir até {max} caracteres.")     
    @Column(name = "endereco", length = 90, nullable = false)
    private String endereco;
    
    @NotBlank(message = "O número deve ser informado")
    @Length(max = 15, message = "O número deve possuir até {max} caracteres.")     
    @Column(name = "numero", length = 15, nullable = false)
    private String numero;
    
    @Length(max = 30, message = "O complemento deve possuir até {max} caracteres.")     
    @Column(name = "complemento", length = 30)
    private String complemento;
    
    @NotNull(message = "A cidade deve se informada")
    @ManyToOne //muitos estados para um pais
    @JoinColumn(name = "cidade", referencedColumnName = "id", nullable = false)
    private Cidade cidade;

    public Pessoa() {
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + '}';
    }
    
    
}
