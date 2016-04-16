//: com.nsv.timentry.entity: UserTest.java
package com.nsv.timentry.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.*;
import static org.junit.Assert.*;

import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsEqual.*;


/**
 * Integration testcase for persistence layer, against table 'USER'
 *
 * @version 1.0.0 $ 2016-04-04 01:00 $
 */
public class UserTest {


    private static EntityManagerFactory emf = null;
    private EntityManager em  = null;

    private final static String email = "Aaron.Yuu@outlook.com";


    @BeforeClass
    public static void setUpBeforeClass() {
        emf = Persistence.createEntityManagerFactory( "NsvTimentry-JSE" );
    }

    @Before
    public void startUp()  {
        em  = emf.createEntityManager();
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
    public void testFindUserByEmail() throws Exception {

        User user = em.createNamedQuery( "User.findByEmail", User.class )
                      .setParameter( "email", email )
                      .getSingleResult();

        Employee emp    = user.getEmployee();
        Role     role   = user.getRole();
        Office   office = user.getOffice();
        Employee mgr    = user.getManager();

        assertThat( emp.getEmail(),           is( equalTo(email) )      );
        assertThat( emp.getName(),            is( equalTo("Aaron Yu") ) );
        assertThat( role.getType(),           is( equalTo("GU") )       );
        assertThat( mgr.getEmail(),           is( equalTo("Eric.Smith@outlook.com")) );
        assertThat( office.getWorkingHours(), is( equalTo((short) 75) ) );

    }

    @Test
    public void testPasswordReset() throws Exception {

        User user = em.createNamedQuery( "User.findByEmail", User.class )
                .setParameter( "email", email )
                .getSingleResult();

        user.setPassword( "987654321" );

        em.getTransaction().begin();
        em.merge( user );
        em.getTransaction().commit();

        assertThat( user.getPassword(), is( equalTo("987654321") ) );

    }


} //:~
