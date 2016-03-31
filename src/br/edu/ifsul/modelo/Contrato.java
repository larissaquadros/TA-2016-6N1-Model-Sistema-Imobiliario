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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Larissa
 */
@Entity
@Table(name = "contrato")
public class Contrato implements Serializable{
    
    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "seq_contrato", sequenceName = "seq_contrato_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_contrato", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "A data de inicio deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "inicio", nullable = false)
    private Calendar data_inicio;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "encerramento")
    private Calendar data_encerramento;
    
    @NotNull(message = "A data de reajuste deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "reajuste", nullable = false)
    private Calendar data_reajuste;

    @Column(name = "observacao", columnDefinition = "text")
    private String observacao;
    
    @NotNull(message = "O valor do aluguel deve ser informado")
    @Column(name = "aluguel", nullable = false, columnDefinition = "decimal(12,2)")
    private Double aluguel;
    
    @NotNull(message = "O imóvel deve se informado")
    @ManyToOne 
    @JoinColumn(name = "imovel", referencedColumnName = "id", nullable = false)
    private Imovel imovel;
    
    @NotNull(message = "A pessoa deve se informada")
    @ManyToOne 
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;

    @OneToMany(mappedBy = "cobrancaID.contrato", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CobrancaAluguel> listaCobrancas = new ArrayList<>();
    
    @NotNull(message = "A quantidade de cobrancas deve ser informado")
    @Column(name = "quantidade_cobrancas", nullable = false, length = 10, columnDefinition = "integer")
    private Integer quantidade_cobrancas;
    
    public Contrato() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Contrato other = (Contrato) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Calendar data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Calendar getData_encerramento() {
        return data_encerramento;
    }

    public void setData_encerramento(Calendar data_encerramento) {
        this.data_encerramento = data_encerramento;
    }

    public Calendar getData_reajuste() {
        return data_reajuste;
    }

    public void setData_reajuste(Calendar data_reajuste) {
        this.data_reajuste = data_reajuste;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Double getAluguel() {
        return aluguel;
    }

    public void setAluguel(Double aluguel) {
        this.aluguel = aluguel;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public List<CobrancaAluguel> getListaCobrancas() {
        return listaCobrancas;
    }

    public void setListaCobrancas(List<CobrancaAluguel> listaCobrancas) {
        this.listaCobrancas = listaCobrancas;
    }
    
    public void gerarCobrancas(){
        Double valorCobranca = this.aluguel;
        for(int i = 1; i <= this.quantidade_cobrancas ; i++){
            CobrancaAluguel c = new CobrancaAluguel();
            c.setValor(valorCobranca);
            CobrancaAluguelID cid = new CobrancaAluguelID();
            cid.setContrato(this);
            cid.setId(i);
            c.setCobrancaID(cid);
            //usar o metodo clone para nao gerar parcelas com data igual
            Calendar vencimento = (Calendar) this.data_inicio.clone();
            //maneira errada de copiar a data = Calendar vencimento = this.data;
            vencimento.add(Calendar.MONTH, i);
            c.setVencimento(vencimento);
            this.listaCobrancas.add(c);
        }
    } 

    public Integer getQuantidade_cobrancas() {
        return quantidade_cobrancas;
    }

    public void setQuantidade_cobrancas(Integer quantidade_cobrancas) {
        this.quantidade_cobrancas = quantidade_cobrancas;
    }
    
    
    
    
}
