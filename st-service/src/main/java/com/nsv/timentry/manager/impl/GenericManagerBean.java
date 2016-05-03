//: com.nsv.timentry.manager.impl: GenericManagerBean.java
package com.nsv.timentry.manager.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nsv.timentry.QueryUtil;
import com.nsv.timentry.manager.GenericManagerLocal;


/**
 * Generic manager bean perform basic CRUD and some query operation
 *
 * @version 1.0.0 $ 2016-04-01 13:30 $
 */
public abstract class GenericManagerBean< T, PK extends Serializable > implements GenericManagerLocal< T, PK > {


    private static final Logger logger = LoggerFactory.getLogger( GenericManagerBean.class );

    protected abstract EntityManager em();


    // Persistence entity class, will be initialized in constructor
    // reflect or setter style
    private final Class<T> entityClazz;

    public GenericManagerBean( Class<T> entityClazz ) {
        this.entityClazz = entityClazz;
    }

    /*
    public GenericManagerBean() {
        entityClazz = (Class<T>) (
                (ParameterizedType) getClass().getGenericSuperclass() ).getActualTypeArguments()[0];
    }
    */

    protected Class<T> getEntityClazz() {
        return entityClazz;
    }

    protected String entityClazzNameLogStyle() {
        return "[" + this.getEntityClazz().getSimpleName() + "]";
    }


    // ------------------------------------------------------------------------------------------------------------
    @Override
    public void create( T entity ) {

        if ( entity == null ) {
            throw new IllegalArgumentException(
                    "Entity object " + entityClazzNameLogStyle() + " is null, can't create." );
        }
        em().persist( entity );

    }

    @Override
    public T findById( PK id ) {
        return em().find( entityClazz, id );
    }

    @Override
    public void remove( PK id ) {
        remove( findById(id) );
    }

    @Override
    public void remove( T entity ) {

        if ( entity != null ) {
            em().remove( entity );
        } else {
            logger.info(
                    "Entity object " + entityClazzNameLogStyle() + "is null, nothing happen." );
        }

    }

    @Override
    public void update( T entity ) {
        em().merge( entity );
    }

    /**
     * NamedQuery placed in entity class as annotation, this method trying to get the
     * named query as string
     *
     * Example:
     *  - Given @NamedQuery( name = "User.findById", query = "SELECT u.* FROM User WHERE u.id = :id" )
     *  - Then  "User.findById" will be return, seems a little bit fragile
     */
    private String queryNameFromEntityAnnotation( String queryName ) {
        return
                entityClazz.getSimpleName() + "." + queryName;
    }

    @Override
    public T findByIdWithQuery( PK id ) {

        return em().createNamedQuery( queryNameFromEntityAnnotation( "findById" ), entityClazz )
                   .setParameter( "id", id )
                   .getSingleResult();
    }

    protected abstract String insertSQL();

    @Override
    public boolean createBySQL( Object[] params ) {
        return QueryUtil.execUpdate( em(), insertSQL(), params ) == 1;
    }


} //:~
