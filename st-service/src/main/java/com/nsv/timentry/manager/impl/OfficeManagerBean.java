//: com.nsv.timentry.manager.impl: OfficeManagerBean.java
package com.nsv.timentry.manager.impl;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nsv.timentry.manager.OfficeManagerLocal;
import com.nsv.timentry.entity.Office;


/**
 * Office manager bean perform basic CRUD and some query operation
 *
 * @version 1.0.0 $ 2016-04-01 17:16 $
 */
@Stateless( name = "OfficeManager" )
public class OfficeManagerBean extends GenericManagerBean< Office, Short > implements OfficeManagerLocal {


    private static final Logger logger = LoggerFactory.getLogger( NonWorkingDayManagerBean.class );


    @PersistenceContext( unitName = "NsvTimentry-JTA" )
    private EntityManager em;


    public OfficeManagerBean() {
        super( Office.class );
    }

    protected EntityManager em() {
        return em;
    }

    protected String insertSQL() {
        return "";
    }

    @Override
    public void update( Office office ) {

        Short id = office.getId();

        if ( findById(id) == null ) {
            throw new IllegalArgumentException( "No Office entity with ID: " + id );
        }

        em.merge( office );

    }


} //:~
