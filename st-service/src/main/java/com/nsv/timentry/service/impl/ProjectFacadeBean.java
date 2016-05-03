//: com.nsv.timentry.service.impl: ProjectFacadeBean.java
package com.nsv.timentry.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Collection;
import java.util.Collections;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.apache.commons.lang3.StringUtils;

import com.nsv.timentry.manager.ProjectManagerLocal;
import com.nsv.timentry.service.ProjectFacade;
import com.nsv.timentry.service.ProjectFacadeLocal;

import com.nsv.timentry.entity.Project;
import com.nsv.timentry.entity.Employee;
import com.nsv.timentry.dto.ProjectDTO;


/**
 * Project facade bean
 *
 * @version 1.0.0 $ 2016-04-16 15:30 $
 */
@Stateless( name = "ProjectFacade" )
public class ProjectFacadeBean implements ProjectFacade, ProjectFacadeLocal {


    private static final Logger logger = LoggerFactory.getLogger( ProjectFacade.class );

    @EJB
    private ProjectManagerLocal  projMgr;


    /**
     * Create new project, check first. if the project with that number
     * is exist or not
     */
    @Override
    public boolean create( ProjectDTO project ) {

        String projNum = project.projNum();

        if ( StringUtils.isBlank( projNum ) ) {
            logger.info(
                "Create project failed caused by invalid projNum: {}",
                projNum
            );
            return false;
        }

        // If project existed
        Project entity = projMgr.findByProjNum( projNum );
        Integer projId = entity.getId();

        if ( projId != null ) {
            logger.info(
                "Target project exists in database: {}",
                entity.getName()
            );
            return false;
        } else {
            return projMgr.createBySQL( project.asArrayInDBOrder() );
        }

    }


    /**
     * Project update, if target project not exist, return false, no exception
     * will be thrown
     */
    @Override
    public boolean update( ProjectDTO project ) {

        Integer projId = project.id();
        Project entity = projMgr.findById( projId );

        if ( entity != null ) {
            projMgr.update( entity );
            return true;
        } else {
            logger.info( "No Project entity with ID: {}, update failed.", projId );
            return false;
        }

    }


    @Override
    public ProjectDTO findById( Integer id ) {

        Project proj = projMgr.findById( id );

        if ( proj == null ) {
            logger.info( "No Project entity with Id: {}.", id );
            return null;
        }

        return this.buildFromEntity(  proj  );

    }


    @Override
    public Collection<ProjectDTO> queryByProjLeader( String leaderName ) {


        if ( StringUtils.isBlank( leaderName ) ) {
            logger.info(
                "Invalid query parameter: {} ", leaderName );
            return Collections.emptyList();
        }

        Collection<Project> projs = projMgr.findByProjLeader( leaderName );

        if ( projs == null || projs.isEmpty() ) {
            logger.info(
                "No projects found by: {}", leaderName );
            return Collections.emptyList();
        }

        Collection<ProjectDTO> resultList = new ArrayList<>();

        for ( Project proj : projs ) {
            resultList.add( buildFromEntity(proj) );
        }

        return Collections.unmodifiableCollection( resultList ); // Seems can not modified

    }


    @Override
    public Collection<ProjectDTO> queryByProjNum( String projNum ) {




        return null;

    }


    /**
     * Build dto from the original entity object, considered move it into dto...
     *
     */
    private ProjectDTO buildFromEntity( Project project ) {

        if ( project == null ) {
            return null;
        }

        // Nothing, for fun and might be easy to remember
        Integer id            = project.getId();
        String  projNum       = project.getProjNum();
        String  name          = project.getName();
        Date    startDate     = project.getStartDate();
        Date    closeDate     = project.getCloseDate();
        boolean isProj        = project.isProj();
        int     budget        = project.getBudget();
        char    status        = project.getStatus().value();
        String  memo          = project.getMemo();
        short   creatorId     = project.getCreatorId();
        short   lastUpdatedBy = project.getLastUpdatedBy();

        // Get entity leader
        Employee leader = project.getLeader();

        Short    leaderId    = leader.getId();
        String   leaderName  = leader.getName();

        return ( new ProjectDTO.Builder() ).id( id ).projNum( projNum ).name( name )
                                           .status( status )
                                           .startDate( startDate )
                                           .closeDate( closeDate )
                                           .isProj( isProj )
                                           .budget( budget )
                                           .memo( memo )
                                           .creatorId( creatorId )
                                           .lastUpdatedBy( lastUpdatedBy )
                                           .leaderId( leaderId ).leaderName( leaderName ).build();

    }


} //:~
