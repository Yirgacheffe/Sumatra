//: com.nsv.timentry.manager.impl: RoleManagerBean.java
package com.nsv.timentry.manager.impl;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nsv.timentry.manager.RoleManagerLocal;
import com.nsv.timentry.entity.Role;


/**
 * Role manager bean perform basic CRUD and some query operation
 *
 * @version 1.0.0 $ 2016-04-01 17:20 $
 */
@Stateless( name = "RoleManager" )
public class RoleManagerBean extends GenericManagerBean< Role, Short > implements RoleManagerLocal {


    private static final Logger logger = LoggerFactory.getLogger( RoleManagerBean.class );


    @PersistenceContext( unitName = "NsvTimentry-JTA" )
    private EntityManager em;


    public RoleManagerBean() {
        super( Role.class );
    }

    protected EntityManager em() {
        return em;
    }

    protected String insertSQL() {
        return "";
    }


    @Override
    public void update( Role role ) {

        Short id = role.getId();

        if ( findById(id) == null ) {
            throw new IllegalArgumentException( "No Role entity with ID: " + id );
        }

        em.merge( role );

    }


} //:~
