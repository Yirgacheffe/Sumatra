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
    private Map<String, Object> session = null;

    private String email    = null;
    private String password = null;

    @Override
    public void setSession( Map<String, Object> session ) {
        this.session = session;
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


    private UserFacadeLocal userFacade = null;

    public void setUserFacade( UserFacadeLocal userFacade ) {
        this.userFacade = userFacade;
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

        session.put( "LOGIN_USER", loginUser);

        logger.debug( "login finished, user {} is in session.", loginUser );
        return Action.SUCCESS;

    }
    // ----------------------------------------------------------------------------------

} //:~
