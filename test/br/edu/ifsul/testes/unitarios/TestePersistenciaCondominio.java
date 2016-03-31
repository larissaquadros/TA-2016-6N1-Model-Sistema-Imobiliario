/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.unitarios;

import br.edu.ifsul.modelo.Caracteristica;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Condominio;
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
public class TestePersistenciaCondominio {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistenciaCondominio() {
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
            
            Condominio c = new Condominio();
            c.setNome("San Martim");
            c.setCidade(em.find(Cidade.class, 1));
            c.setBairro("Petrópolis");
            c.setEndereco("Avenida Brasil Leste");
            c.setNumero("544");
            c.setReferencia("Próximo ao hotel maytá");                     
                    
            em.getTransaction().begin();
            em.persist(c);            
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception); //verifico se o esperado ocorreu 
        
    }
    
}
