//: com.nsv.timentry: QueryUtil.java
package com.nsv.timentry;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


/**
 * QueryUtil provide, provide what? Huh, this is bullshit
 *
 * @version 1.0.0 $ 2016-05-03 21:45 $
 */
public class QueryUtil {


    /**
     *
     */
    public static int execUpdate( EntityManager em, String sql, Object[] params ) {

        Query q = em.createNativeQuery( sql );

        for ( int i = 0, n = params.length; i < n; i++ ) {
            q.setParameter( i + 1, params[i] );
        }

        return q.executeUpdate();   // Return effect result for update

    }


    /**
     *
     */
    public static <T> T execAndGetSR( EntityManager em, String namedQuery,
                                      Class<T> clazz,
                                      Object...params ) {

        TypedQuery<T> q = em.createNamedQuery( namedQuery, clazz );

        for ( int i = 0, n = params.length; i < n; i ++ ) {
            q.setParameter( i + 1, params[i] );
        }

        return q.getSingleResult();    // Run query and get single result object

    }


    /**
     *
     */
    public static <T> List<T> execAndGetRL( EntityManager em, String namedQuery,
                                            Class<T> clazz,
                                            Object...params ) {

        TypedQuery<T> q = em.createNamedQuery( namedQuery, clazz );

        for ( int i = 0, n = params.length; i < n; i ++ ) {
            q.setParameter( i + 1, params[i] );
        }

        return Collections.unmodifiableList( q.getResultList() );   // Get result list

    }


} //:~
