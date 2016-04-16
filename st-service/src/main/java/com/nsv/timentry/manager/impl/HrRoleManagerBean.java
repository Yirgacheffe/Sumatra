//: com.nsv.timentry.manager.impl: HrRoleManagerBean.java
package com.nsv.timentry.manager.impl;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nsv.timentry.manager.HrRoleManagerLocal;
import com.nsv.timentry.entity.HrRole;


/**
 * HrRole manager bean perform basic CRUD and some query operation
 *
 * @version 1.0.0 $ 2016-04-01 17:05 $
 */
@Stateless( name = "HrRoleManager" )
public class HrRoleManagerBean extends GenericManagerBean< HrRole, Short > implements HrRoleManagerLocal {


    private static final Logger logger = LoggerFactory.getLogger( HrRoleManagerBean.class );


    @PersistenceContext( unitName = "NsvTimentry-JTA" )
    private EntityManager em;


    public HrRoleManagerBean() {
        super( HrRole.class );
    }

    protected EntityManager em() {
        return em;
    }


    @Override
    public void update( HrRole hrRole ) {

        Short id = hrRole.getId();

        if ( findById(id) == null ) {
            throw new IllegalArgumentException( "No HrRole entity with ID: " + id );
        }

        em.merge( hrRole );

    }


} //:~
