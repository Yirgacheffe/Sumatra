//: com.nsv.timentry.manager.impl: ProjectManagerBean.java
package com.nsv.timentry.manager.impl;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nsv.timentry.manager.ProjectManagerLocal;
import com.nsv.timentry.entity.Project;


/**
 * Project manager bean perform basic CRUD and some query operation
 *
 * @version 1.0.0 $ 2016-04-01 17:16 $
 */
@Stateless( name = "ProjectManager" )
public class ProjectManagerBean extends GenericManagerBean< Project, Integer > implements ProjectManagerLocal {


    private static final Logger logger = LoggerFactory.getLogger( ProjectManagerBean.class );


    private static final String SQL_INSERT = "INSERT INTO PROJECTS "
            + "( "
            + "PROJ_NUM, "
            + "NAME, "
            + "START_DATE, "
            + "CLOSE_DATE, "
            + "IS_PROJ, BUDGET, "
            + "STATUS, "
            + "MEMO, "
            + "CREATOR_ID, "
            + "LAST_UPDATED_BY "
            + ") "
            + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";


    @PersistenceContext( unitName = "NsvTimentry-JTA" )
    private EntityManager em;


    public ProjectManagerBean() {
        super( Project.class );
    }

    protected EntityManager em() {
        return em;
    }


    @Override
    public void update( Project project ) {

        Integer id = project.getId();

        if ( findById(id) == null ) {
            throw new IllegalArgumentException( "No Project entity with ID: " + id );
        }

        em.merge( project );

    }

    @Override
    public boolean createBySQL( Object[] dbOrderedParams ) {

        Query q = em.createNativeQuery( SQL_INSERT );

        for ( int i = 0, n = dbOrderedParams.length; i < n; i++ ) {
            q.setParameter( i + 1, dbOrderedParams[i] );
        }

        return q.executeUpdate() == 1;  // Created successful? god knows...

    }

    @Override
    public Project findByProjNum( String projNum ) {

        if ( logger.isDebugEnabled() ) {
            logger.debug( "Find project by project number: {}", projNum );
        }

        return em.createNamedQuery(
            "Project.findByProjNum", Project.class ).setParameter( "projNum", projNum ).getSingleResult();
    }


} //:~
