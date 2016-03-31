/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.unitarios;

import br.edu.ifsul.modelo.Caracteristica;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
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
public class TestePersistenciaCaracteristica {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistenciaCaracteristica() {
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
            Caracteristica c = new Caracteristica();
            c.setNome("2 dormitórios");
            
            Caracteristica c1 = new Caracteristica();
            c1.setNome("1 dormitório");
            
            Caracteristica c2 = new Caracteristica();
            c2.setNome("Banheiro");
            
            Caracteristica c3 = new Caracteristica();
            c3.setNome("Sala de antar");

            Caracteristica c4 = new Caracteristica();
            c4.setNome("Cozinha");          
                    
            em.getTransaction().begin();
            em.persist(c);
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.persist(c4);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception); //verifico se o esperado ocorreu 
        
    }
    
}
