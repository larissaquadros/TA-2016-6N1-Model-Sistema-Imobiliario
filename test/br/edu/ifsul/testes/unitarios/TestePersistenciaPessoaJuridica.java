/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.unitarios;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.PessoaJuridica;
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
public class TestePersistenciaPessoaJuridica {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistenciaPessoaJuridica() {
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
            
            PessoaJuridica pj = new PessoaJuridica();
            pj.setNome("Metasig Ltda");
            pj.setNome_fantasia("Metasig");
            pj.setEmail("metasig@metasig.com.br");
            pj.setIe("12345667");
            pj.setCnpj("13.468.523/0001-09");
            pj.setCidade(em.find(Cidade.class, 1));
            pj.setBairro("Petrópolis");
            pj.setEndereco("Avenida Brasil Leste");
            pj.setNumero("544");
            pj.setComplemento("Sala 203");
            pj.setData_fundacao(new GregorianCalendar(1995, Calendar.FEBRUARY, 14));
                       
            
            em.getTransaction().begin();
            em.persist(pj);
            em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        
        Assert.assertEquals(false, exception); //verifico se o esperado ocorreu 
        
    }
    
}
