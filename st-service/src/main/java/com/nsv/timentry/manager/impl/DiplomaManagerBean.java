//: com.nsv.timentry.manager.impl: DiplomaManagerBean.java
package com.nsv.timentry.manager.impl;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nsv.timentry.manager.DiplomaManagerLocal;
import com.nsv.timentry.entity.Diploma;


/**
 * Diploma manager bean perform basic CRUD and some query operation
 *
 * @version 1.0.0 $ 2016-04-01 16:59 $
 */
@Stateless( name = "DiplomaManager" )
public class DiplomaManagerBean extends GenericManagerBean< Diploma, Short > implements DiplomaManagerLocal {


    private static final Logger logger = LoggerFactory.getLogger( DiplomaManagerBean.class );


    @PersistenceContext( unitName = "NsvTimentry-JTA" )
    private EntityManager em;


    public DiplomaManagerBean() {
        super( Diploma.class );
    }

    protected EntityManager em() {
        return em;
    }


    @Override
    public void update( Diploma diploma ) {

        Short id = diploma.getId();

        if ( findById(id) == null ) {
            throw new IllegalArgumentException( "No Diploma entity with ID: " + id );
        }

        em.merge( diploma );

    }


} //:~
