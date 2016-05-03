//: com.nsv.timentry.manager.impl: DayLogManagerBean.java
package com.nsv.timentry.manager.impl;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nsv.timentry.manager.DayLogManagerLocal;
import com.nsv.timentry.entity.DayLog;


/**
 * DayLog manager bean perform basic CRUD and some query operation
 *
 * @version 1.0.0 $ 2016-04-01 16:52 $
 */
@Stateless( name = "DayLogManager" )
public class DayLogManagerBean extends GenericManagerBean< DayLog, Integer > implements DayLogManagerLocal {


    private static final Logger logger = LoggerFactory.getLogger( DayLogManagerBean.class );


    private static final String SQL_INSERT = "INSERT INTO DAY_LOGS "
            + "( "
            +   "WORK_DAY, "
            +   "EMP_ID, "
            +   "WEEK_LOG, "
            +   "STATUS, "
            +   "HOURS,  "
            +   "MEAL "
            + ") VALUES ( ?, ?, ?, ?, ?, ? )";


    @PersistenceContext( unitName = "NsvTimentry-JTA" )
    private EntityManager em;


    public DayLogManagerBean() {
        super( DayLog.class );
    }

    protected EntityManager em() {
        return em;
    }

    protected String insertSQL() {
        return SQL_INSERT;
    }

    @Override
    public void update( DayLog dayLog ) {

        Integer id = dayLog.getId();

        if ( findById(id) == null ) {
            throw new IllegalArgumentException( "No DayLog entity with ID: " + id );
        }

        em.merge( dayLog );

    }


    @Override
    public boolean createBySQL( Object[] dbOrderedParams ) {

        Query q = em.createNativeQuery( SQL_INSERT );

        for ( int i = 0, n = dbOrderedParams.length; i < n; i++ ) {
            q.setParameter( i + 1, dbOrderedParams[i] );
        }

        return q.executeUpdate() == 1;  // Created successful , god knows... ???

    }


} //:~
