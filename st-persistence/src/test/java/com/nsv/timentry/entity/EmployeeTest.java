//: com.nsv.timentry.entity: EmployeeTest.java
package com.nsv.timentry.entity;

import java.util.Collection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Persistence;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.AfterClass;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;


/**
 * Integration testcase for persistence layer, against table 'EMPLOYEE'
 *
 * @version 1.0.0 $ 2016-04-03 23:24 $
 */
public class EmployeeTest {


    private static final String TEST_USER_EMAIL = "Aaron.Yuu@outlook.com";

    private static EntityManagerFactory emf = null;
    private EntityManager em = null;


    @BeforeClass
    public static void setUpBeforeClass() {
        emf = Persistence.createEntityManagerFactory( "NsvTimentry-JSE" );
    }

    @Before
    public void startUp()  {
        em  = emf.createEntityManager();
        this.createTestData();
    }

    @After
    public void tearDown() {
        if ( em  != null ) { em.close();  }
    }

    @AfterClass
    public static void tearDownAfterClass() {
        if ( emf != null ) { emf.close(); }
    }


    @Test
    public void testFindByNameAndEmailWithLike() {

        Query q = em.createNamedQuery( "Employee.findByNameAndEmailWithLike", Employee.class )
                    .setParameter( "name",  "Aaron%" )
                    .setParameter( "email", TEST_USER_EMAIL + "%" )
                    .setParameter( "removed", false );

        Employee emp = (Employee) q.getSingleResult();

        assertThat( emp.getEmail(), is( equalTo(TEST_USER_EMAIL) ) );
        assertThat( emp.getName(),  is( equalTo("Aaron Yu") )      );

    }

    public void createTestData() {

    }


} //:~
