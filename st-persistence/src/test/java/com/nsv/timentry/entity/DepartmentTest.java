//: com.nsv.timentry.entity: DepartmentTest.java
package com.nsv.timentry.entity;

import java.util.List;

import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;


/**
 * Integration testcase for persistence layer, against table 'DEPARTMENT'
 *
 * @version 1.0.0 $ 2016-04-03 23:22 $
 */
public class DepartmentTest {


    private EntityManagerFactory emf = null;
    private EntityManager        em  = null;

    @Before
    public void startUp()  {
        emf = Persistence.createEntityManagerFactory( "NsvTimentry-JSE" );
        em  = emf.createEntityManager();
        this.createTestData();
    }

    @After
    public void tearDown() {
        if ( em  != null ) { em.close();  }
        if ( emf != null ) { emf.close(); }
    }
    

    @Test
    public void smokeTest() {

        List<Department> departments = 
                em.createNativeQuery( "SELECT * FROM DEPARTMENTS", Department.class ).getResultList();
        
        for ( Department dept : departments ) {
            System.out.println( dept.toString() );
        }
        
    }


    private void createTestData() {
        // Placeholder method.................................................
    }
    

} //:~
