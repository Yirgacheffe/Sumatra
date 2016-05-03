//: com.nsv.timentry.manager.impl: TaskManagerBean.java
package com.nsv.timentry.manager.impl;

import javax.ejb.Stateless;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nsv.timentry.manager.TaskManagerLocal;
import com.nsv.timentry.entity.Task;


/**
 * Task manager bean perform basic CRUD and some query operation
 *
 * @version 1.0.0 $ 2016-04-01 17:23 $
 */
@Stateless( name = "TaskManager" )
public class TaskManagerBean extends GenericManagerBean< Task, Integer > implements TaskManagerLocal {


    private static final Logger logger = LoggerFactory.getLogger( TaskManagerBean.class );

    private static final String SQL_INSERT = "INSERT INTO TASKS "
            + "( "
            + "PROJ_ID, "
            + "NAME, "
            + "IS_EXTENAL, "
            + "START_DATE, "
            + "CLOSE_DATE, "
            + "ESTIMATION, "
            + "PHASE_ID, "
            + "MEMO, "
            + "CREATOR_ID, "
            + "LAST_UPDATED_BY "
            + ") "
            + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

    @PersistenceContext( unitName = "NsvTimentry-JTA" )
    private EntityManager em;


    public TaskManagerBean() {
        super( Task.class );
    }

    protected EntityManager em() {
        return em;
    }

    protected String insertSQL() {
        return SQL_INSERT;
    }


    @Override
    public void update( Task task ) {

        Integer id = task.getId();

        if ( findById(id) == null ) {
            throw new IllegalArgumentException( "No Task entity with ID: " + id );
        }

        em.merge( task );

    }


} //:~
