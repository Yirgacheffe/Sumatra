//: com.nsv.timentry.manager.impl: NonWorkingDayManagerBean.java
package com.nsv.timentry.manager.impl;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nsv.timentry.manager.NonWorkingDayManagerLocal;
import com.nsv.timentry.entity.NonWorkingDay;


/**
 * NonWorkingDay manager bean perform basic CRUD and some query operation
 *
 * @version 1.0.0 $ 2016-04-01 17:10 $
 */
@Stateless( name = "NonWorkingDayManager" )
public class NonWorkingDayManagerBean extends GenericManagerBean< NonWorkingDay, Integer >
        implements NonWorkingDayManagerLocal {


    private static final Logger logger = LoggerFactory.getLogger( NonWorkingDayManagerBean.class );


    private static final String SQL_INSERT = "INSERT INTO NON_WORKINGDAY "
            + "( "
            + "HOLI_DATE, "
            + "NAME, "
            + "TYPE, "
            + "WEEK, "
            + "MEMO "
            + ") VALUES ( ?, ?, ?, ?, ? )";


    @PersistenceContext( unitName = "NsvTimentry-JTA" )
    private EntityManager em;


    public NonWorkingDayManagerBean() {
        super( NonWorkingDay.class );
    }

    protected EntityManager em() {
        return em;
    }

    protected String insertSQL() {
        return SQL_INSERT;
    }

    @Override
    public void update( NonWorkingDay nonWorkingDay ) {

        Integer id = nonWorkingDay.getId();

        if ( findById(id) == null ) {
            throw new IllegalArgumentException( "No NonWorkingDay entity with ID: " + id );
        }

        em.merge( nonWorkingDay );

    }


} //:~
