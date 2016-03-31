/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.unitarios;

import br.edu.ifsul.modelo.Contrato;
import br.edu.ifsul.modelo.Imovel;
import br.edu.ifsul.modelo.Pessoa;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
public class TestePersistenciaContrato {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistenciaContrato() {
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
            
            Contrato c = new Contrato();
            c.setAluguel(400.00);
            c.setObservacao("Teste");
            c.setPessoa(em.find(Pessoa.class, 1));
            c.setImovel(em.find(Imovel.class, 7));
            c.setData_inicio(new GregorianCalendar(1995, Calendar.FEBRUARY, 14));
            c.setData_reajuste(new GregorianCalendar(1995, Calendar.FEBRUARY, 14));
            c.setData_encerramento(new GregorianCalendar(1995, Calendar.FEBRUARY, 14));
            c.setQuantidade_cobrancas(12);
            
            
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
