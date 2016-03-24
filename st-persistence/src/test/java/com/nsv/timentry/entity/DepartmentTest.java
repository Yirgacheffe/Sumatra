//: com.nsv.timentry.entity: DepartmentsTest.java
package com.nsv.timentry.entity;

import java.util.List;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class DepartmentTest {

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
        List<Department> departments = 
                em.createNativeQuery( "SELECT * FROM DEPARTMENTS", Department.class ).getResultList();
        
        for ( Department dept : departments ) {
            System.out.println( dept.toString() );
        }
        
        em.close();
        
    }
    

} //:~
