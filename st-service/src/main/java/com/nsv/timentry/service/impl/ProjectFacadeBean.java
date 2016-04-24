//: com.nsv.timentry.service.impl: ProjectFacadeBean.java
package com.nsv.timentry.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import org.apache.commons.lang3.StringUtils;

import com.nsv.timentry.entity.Project;
import com.nsv.timentry.dto.ProjectDTO;

import com.nsv.timentry.manager.ProjectManagerLocal;
import com.nsv.timentry.service.ProjectFacade;
import com.nsv.timentry.service.ProjectFacadeLocal;


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


    @Override
    public boolean update( ProjectDTO project ) {


        // project




        return true;
    }


} //:~
