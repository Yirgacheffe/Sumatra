// com.nsv.timentry.manager.impl: UserManagerBean.java
package com.nsv.timentry.manager.impl;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nsv.timentry.manager.UserManagerLocal;
import com.nsv.timentry.entity.User;


/**
 * User manager bean perform basic CRUD and some query operation
 * 
 * @version 1.0.0 $ 2016-03-29 22:51 $
 */
@Stateless( name = "UserManager" )
public class UserManagerBean extends GenericManagerBean< User, Short > implements UserManagerLocal {

    
    private static final Logger logger = LoggerFactory.getLogger( UserManagerBean.class );

    private static final String SQL_INSERT = "INSERT INTO USERS "
            + "( "
            +   "EMAIL, "
            +   "PASSWORD, "
            +   "EMP_ID, "
            +   "ROLE_ID, "
            +   "MGR_ID, "
            +   "IS_REMOVED, "
            +   "OFFICE_ID "
            + ") VALUES ( ?, ?, ?, ?, ?, ?, ? )";

    @PersistenceContext( unitName = "NsvTimentry-JTA" )
    private EntityManager em;

    public UserManagerBean() {
        super( User.class );
    }

    @Override
    protected EntityManager em() {
        return em;
    }


    @Override
    public void update( User user ) {

        Short id = user.getId();

        if ( findById(id) == null ) {
            throw new IllegalArgumentException( "No user entity with ID: " + id );
        }

        em.merge( user );

    }

    @Override
    public User findByEmail( String email ) {

        return em.createNamedQuery( "User.findByEmail", User.class ).setParameter( "email", email )
                 .getSingleResult();

    }

    @Override
    public boolean createBySQL( Object[] dbOrderedParams ) {

        Query q = em.createNativeQuery( SQL_INSERT );

        for ( int i = 0, n = dbOrderedParams.length; i < n; i++ ) {
            q.setParameter( i + 1, dbOrderedParams[i] );
        }

        return q.executeUpdate() == 1;  // Created successful , god knows?

    }

    @Override
    public User createBySQLThenGrab( String email, Object[] dbOrderedParams ) {

        boolean isCreated = this.createBySQL( dbOrderedParams );

        if ( !isCreated ) {
            logger.debug(
                    "Employee.SQL: exec {} not able to create new record.", SQL_INSERT );
            return null;
        } else {
            return this.findByEmail( email );  // Return persistence user entity
        }

    }
    
    
} //:~
