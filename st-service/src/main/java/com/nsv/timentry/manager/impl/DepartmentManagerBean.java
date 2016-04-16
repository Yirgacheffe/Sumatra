//: com.nsv.timentry.manager.impl: DepartmentManagerBean.java
package com.nsv.timentry.manager.impl;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nsv.timentry.manager.DepartmentManagerLocal;
import com.nsv.timentry.entity.Department;


/**
 * Department manager bean perform basic CRUD and some query operation
 *
 * @version 1.0.0 $ 2016-04-01 16:55 $
 */
@Stateless( name = "DepartmentManager" )
public class DepartmentManagerBean extends GenericManagerBean< Department, Short > implements DepartmentManagerLocal {


    private static final Logger logger = LoggerFactory.getLogger( DepartmentManagerBean.class );


    @PersistenceContext( unitName = "NsvTimentry-JTA" )
    private EntityManager em;


    public DepartmentManagerBean() {
        super( Department.class );
    }

    protected EntityManager em() {
        return em;
    }


    @Override
    public void update( Department dept ) {

        Short id = dept.getId();

        if ( findById(id) == null ) {
            throw new IllegalArgumentException( "No Department entity with ID: " + id );
        }

        em.merge( dept );

    }


} //:~
