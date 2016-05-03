//: com.nsv.timentry.manager.impl: ProjectManagerBean.java
package com.nsv.timentry.manager.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nsv.timentry.QueryUtil;

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

    protected String insertSQL() {
        return SQL_INSERT;
    }


    @Override
    public Project findByProjNum( String projNum ) {

        if ( logger.isDebugEnabled() ) {
            logger.debug( "Find project by project number: {}",  projNum );
        }

        final String query = "Project.findByProjLeader";
        return QueryUtil.execAndGetSR( em, query, Project.class, projNum );

    }


    @Override
    public List<Project> findByProjLeader( String leaderName ) {

        if ( logger.isDebugEnabled() ) {
            logger.debug(
                "Find projects by project leader: {}",
                leaderName );
        }

        final String query = "Project.findByProjLeader";
        final String keyWord = leaderName + "%";

        return QueryUtil.execAndGetRL( em, query, Project.class, keyWord );

    }


    public List<Project> findByProjName( String projName ) {

        if ( logger.isDebugEnabled() ) {
            logger.debug(
                "Find projects by project number: {}",
                projName );
        }

        final String query   = "Project.findByProjName";
        final String keyWord = projName + "%";

        return QueryUtil.execAndGetRL( em, query, Project.class, keyWord  );

    }







} //:~
