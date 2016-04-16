//: com.nsv.timentry.manager: GenericManagerLocal.java
package com.nsv.timentry.manager;

import java.io.Serializable;

/**
 * Generic manager bean local interface perform basic CRUD operation
 *
 * @version 1.0.0 $ 2016-04-01 11:11 $
 */
public interface GenericManagerLocal<T, PK extends Serializable> {

    void create( T entity );
    void update( T entity );

    void remove( PK id );
    void remove( T entity );

    T findById( PK id );
    T findByIdWithQuery( PK id );

} //:~
