//: com.nsv.timentry.manager.impl: LogItemManagerBean.java
package com.nsv.timentry.manager.impl;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nsv.timentry.manager.LogItemManagerLocal;
import com.nsv.timentry.entity.LogItem;


/**
 * LogItem manager bean perform basic CRUD and some query operation
 *
 * @version 1.0.0 $ 2016-04-01 17:08 $
 */
@Stateless( name = "LogItemManager" )
public class LogItemManagerBean extends GenericManagerBean< LogItem, Integer > implements LogItemManagerLocal {


    private static final Logger logger = LoggerFactory.getLogger( LogItemManagerBean.class );


    private static final String SQL_INSERT = "INSERT INTO LOG_ITEMS "
            + "( "
            + "DAY_LOG, "
            + "PROJ_ID, "
            + "TASK_ID, "
            + "TYPE, "
            + "CONTENT, "
            + "HOURS, "
            + "START_ON, "
            + "CLOSE_ON, "
            + "PLACE "
            + ") VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";

    @PersistenceContext( unitName = "NsvTimentry-JTA" )
    private EntityManager em;


    public LogItemManagerBean() {
        super( LogItem.class );
    }

    protected EntityManager em() {
        return em;
    }


    @Override
    public void update( LogItem logItem ) {

        Integer id = logItem.getId();

        if ( findById(id) == null ) {
            throw new IllegalArgumentException( "No LogItem entity with ID: " + id );
        }

        em.merge( logItem );

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
