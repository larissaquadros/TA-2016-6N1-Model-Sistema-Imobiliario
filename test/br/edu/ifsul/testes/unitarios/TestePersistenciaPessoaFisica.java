/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.unitarios;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaFisica;
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
public class TestePersistenciaPessoaFisica {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistenciaPessoaFisica() {
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
            
            PessoaFisica pf = new PessoaFisica();
            pf.setNome("Larissa de Quadros");
            pf.setEmail("larissa@metasig.com.br");
            pf.setCpf("022.328.330-46");
            pf.setRg("1123456789");                      
            pf.setCidade(em.find(Cidade.class, 1));
            pf.setBairro("Petrópolis");
            pf.setEndereco("Avenida Brasil Leste");
            pf.setNumero("544");
            pf.setComplemento("Ap 23");
            pf.setNascimento(new GregorianCalendar(1995, Calendar.FEBRUARY, 14));
            pf.setPassaporte("123456789");
            
            
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
