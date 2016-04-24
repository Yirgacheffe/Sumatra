//: com.nsv.timentry.controller: UserController.java
package com.nsv.timentry.controller;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.apache.commons.lang3.StringUtils.isBlank;

import com.nsv.timentry.dto.UserDTO;
import com.nsv.timentry.service.UserFacadeLocal;

import com.nsv.timentry.model.User;


/**
 * UserController
 *
 * @version 1.0.0 $ 2016-04-17 18:47 $
 */
public class UserController extends ActionSupport implements SessionAware {


    private static final long serialVersionUID = 6837677707228502069L;

    private static final
            Logger logger = LoggerFactory.getLogger( UserController.class );

    // ----------------------------------------------------------------------------------
    private UserFacadeLocal  userFacade = null;
    private Map<String, Object> session = null;

    private String email    = null;
    private String password = null;

    @Override
    public void setSession( Map<String, Object>   session ) {
        this.session = session;
    }

    public void setUserFacade( UserFacadeLocal userFacade ) {
        this.userFacade = userFacade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }


    /**
     * Execute logout action, clear the data in current session
     */
    public String logout() {

        logger.debug( "logout start..." );

        if ( session != null ) {
            session.clear();
        }

        logger.debug( "logout finished, now session clean..." );
        return Action.SUCCESS;

    }


    /**
     * Execute login action, if user no in session, get email and password
     * then you know, compare with the value in database, simple?
     */
    public String login()  {

        logger.debug( "login start, get email address: {}", email );

        if ( isBlank(email) || isBlank(password) ) {
            return Action.INPUT;
        }

        UserDTO loginUser = userFacade.login( email, password );

        if ( loginUser == null ) {
            addActionError( getText("error.login") );
            return Action.INPUT;
        }

        User sessionUser = buildFromDTO( loginUser );
        session.put( "LOGIN_USER", sessionUser );

        logger.debug( "login finished, user {} in session.", sessionUser.getName() );
        return Action.SUCCESS;

    }


    private User buildFromDTO( UserDTO userDTO ) {

        String name     = userDTO.name();
        Short  roleId   = userDTO.roleId();
        Short  id       = userDTO.id();

        Short  mgrId    = userDTO.managerId();
        String email    = userDTO.email();
        Short  empId    = userDTO.empId();
        String roleType = userDTO.roleType();
        Short  officeId = userDTO.officeId();

        return new User( id, empId, name, email, mgrId, roleId, roleType, officeId );

    }
    // ----------------------------------------------------------------------------------


} //:~
