/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.unitarios;

import br.edu.ifsul.modelo.Caracteristica;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Telefone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Larissa
 */
public class TestePersistenciaPessoaTelefone {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistenciaPessoaTelefone() {
    }
    
    @Before
    public void setUp() {
        emf =  Persistence.createEntityManagerFactory("TA-2016-6N1-Model-Sistema-ImobiliarioPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        boolean exception = false; //meu teste nao vai ter exessão é isso que significa isso

        //testar persistencia
        try{
            
            PessoaFisica pf = em.find(PessoaFisica.class, 23);
            Telefone t = new Telefone();
            t.setNumero("(54)3333-9067");
            t.setDescricao("Celular");
            pf.adicionarTelefone(t);
            
            em.getTransaction().begin();
            
            em.persist(pf);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception); //verifico se o esperado ocorreu 
        
    }
    
}
