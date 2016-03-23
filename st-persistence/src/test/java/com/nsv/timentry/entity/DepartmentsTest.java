//: com.nsv.timentry.entity: DepartmentsTest.java
package com.nsv.timentry.entity;

import java.util.List;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class DepartmentsTest {

    private EntityManagerFactory emf = null;
    
    @Before
    public void startUp()  {
        emf = Persistence.createEntityManagerFactory( "NsvTimentry-JSE" );
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void smokeTest() {
        EntityManager em = emf.createEntityManager();
        List<Departments> departments = em.createNativeQuery( "SELECT * FROM DEPARTMENTS" ).getResultList();
        
        for ( Departments dept : departments ) {
            System.out.println( dept.getName() );
        }
        
        em.close();
        
    }
    

} //:~
