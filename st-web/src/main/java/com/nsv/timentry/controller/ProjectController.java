//: com.nsv.timentry.controller: ProjectController.java
package com.nsv.timentry.controller;

import java.util.Date;
import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.google.gson.Gson;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import static org.apache.commons.lang3.StringUtils.isBlank;

import com.nsv.timentry.dto.ProjectDTO;
import com.nsv.timentry.service.ProjectFacadeLocal;

import com.nsv.timentry.model.User;
import com.nsv.timentry.model.Project;


/**
 * ProjectController collect all project related action, create, edit and delete etc.
 *
 * @version 1.0.0 $ 2016-04-22 16:16 $
 */
public class ProjectController extends ActionSupport implements UserAware {


    private static final long serialVersionUID = 4691238041210608197L;
    private static final Logger logger = LoggerFactory.getLogger( ProjectController.class );


    // ----------------------------------------------------------------------------------
    private ProjectFacadeLocal projFacade;

    public void setProjFacade( ProjectFacadeLocal projFacade ) {
        this.projFacade = projFacade;
    }

    private Project project = null;
    private User user;

    @Override
    public void setUser( User user ) {
        this.user = user;
    }

    public Project getProject() {
        return this.project;
    }

    public void setProject( Project project ) {
        this.project = project;
    }


    /**
     * Action for add new project into database, the only different from update is the
     * creator id
     */
    public String create() {

        ProjectDTO projDTO = buildDTOForInsert( project, user.getId() );
        boolean isCreated = projFacade.create( projDTO );

        if ( !isCreated ) {
            addActionError( getText("error.project.create") );
            return Action.INPUT;
        }

        logger.info( "Project create successfully with id: {}", projDTO.projNum() );
        return  Action.SUCCESS;

    }


    /**
     * Action for update project info, the only different from insert action is the
     * creator id, update action should not include creator id
     */
    public String update() {

        ProjectDTO projDTO = buildDTOForUpdate( project, user.getId() );
        boolean isUpdated = projFacade.update( projDTO );

        if ( !isUpdated ) {
            addActionError( getText("error.project.update") );
            return Action.INPUT;
        }

        logger.info( "Project update successfully with id: {}", projDTO.projNum() );
        return  Action.SUCCESS;

    }


    // Response result as Json string
    private String responseAsJson;

    public String getResponseAsJson() {
        return responseAsJson;
    }

    public void setResponseAsJson( String responseAsJson ) {
        this.responseAsJson = responseAsJson;
    }


    /**
     * Action for get project details
     */
    public String details() {

        Map<String, Object> req = ActionContext.getContext().getParameters();
        String projId = (String) req.get( "id" );

        if ( isBlank(projId) ) {
            addActionError( getText("error.project.details.link") );
            return Action.INPUT;
        }

        ProjectDTO dto = projFacade.findById( Integer.parseInt( projId ) );

        String jsonString = new Gson().toJson( dto );
        setResponseAsJson( jsonString );

        logger.debug("Send response as Json string, result is: {}", jsonString );
        return Action.SUCCESS;

    }


    private ProjectDTO buildDTOForInsert( Project proj, Short userId ) {
        return buildDTO( proj, userId, true  );
    }


    private ProjectDTO buildDTOForUpdate( Project proj, Short userId ) {
        return buildDTO( proj, userId, false );
    }


    private ProjectDTO buildDTO( Project proj, Short userId, boolean isInsert ) {

        // ..................................................
        Integer id           = proj.getId();
        String  projNum      = proj.getProjNum();
        String  name         = proj.getName();
        Date    startDate    = proj.getStartDate();
        Date    closeDate    = proj.getCloseDate();
        boolean isProj       = proj.isProj();
        int     budget       = proj.getBudget();
        char    status       = proj.getStatus();
        String  memo         = proj.getMemo();
        Short   leaderId     = proj.getLeaderId();

        ProjectDTO.Builder builder = new ProjectDTO.Builder();

        if ( isInsert ) {
            builder.creatorId( userId );
        }

        return builder.id( id ).projNum( projNum )
                      .name( name )
                      .startDate( startDate )
                      .closeDate( closeDate )
                      .isProj( isProj )
                      .budget( budget )
                      .status( status )
                      .memo( memo ).leaderId( leaderId ).lastUpdatedBy( userId ).build();
    }
    // ----------------------------------------------------------------------------------


} //:~
