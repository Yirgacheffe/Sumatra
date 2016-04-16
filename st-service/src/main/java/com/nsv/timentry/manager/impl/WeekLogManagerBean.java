//: com.nsv.timentry.manager.impl: WeekLogManagerBean.java
package com.nsv.timentry.manager.impl;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nsv.timentry.manager.WeekLogManagerLocal;
import com.nsv.timentry.entity.WeekLog;


/**
 * WeekLog manager bean perform basic CRUD and some query operation
 *
 * @version 1.0.0 $ 2016-04-01 17:23 $
 */
@Stateless( name = "WeekLogManager" )
public class WeekLogManagerBean extends GenericManagerBean< WeekLog, Integer > implements WeekLogManagerLocal {


    private static final Logger logger = LoggerFactory.getLogger( WeekLogManagerBean.class );


    private static final String SQL_INSERT = "INSERT INTO WEEK_LOGS "
                                           + "( "
                                           + "YEAR, WEEK, EMP_ID, STATUS ) VALUES ( ?, ?, ?, ? );";


    @PersistenceContext( unitName = "NsvTimentry-JTA" )
    private EntityManager em;


    public WeekLogManagerBean() {
        super( WeekLog.class );
    }

    protected EntityManager em() {
        return em;
    }


    @Override
    public void update( WeekLog weekLog ) {

        Integer id = weekLog.getId();

        if ( findById(id) == null ) {
            throw new IllegalArgumentException( "No WeekLog entity with ID: " + id );
        }

        em.merge( weekLog );

    }


    @Override
    public boolean createBySQL( Object[] dbOrderedParams ) {

        Query q = em.createNativeQuery( SQL_INSERT );

        for ( int i = 0, n = dbOrderedParams.length; i < n; i++ ) {
            q.setParameter( i + 1, dbOrderedParams[i] );
        }

        return q.executeUpdate() == 1;  // Created successful , god knows?

    }


} //:~
