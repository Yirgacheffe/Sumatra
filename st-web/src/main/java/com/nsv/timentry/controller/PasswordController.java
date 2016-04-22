//: package com.nsv.timentry.controller: PasswordController.java
package com.nsv.timentry.controller;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.apache.commons.lang3.StringUtils.isBlank;

import com.nsv.timentry.service.UserFacadeLocal;


/**
 * PasswordController collect all password related action, include password forgot and reset
 *
 * @version 1.0.0 $ 2016-04-18 17:13 $
 */
public class PasswordController extends ActionSupport implements SessionAware {


    private static final long serialVersionUID = 1249749164556123920L;
    private static final
            Logger logger = LoggerFactory.getLogger( PasswordController.class );

    // ----------------------------------------------------------------------------------

    private Map<String, Object> session = null;

    private String email      = null;
    private String randomCode = null;
    private String password   = null;

    // Actually this is the new password value, strange name, right?
    // Just don't want to repeat the word 'password'
    private String secretKey  = null;


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

    public String getRandomCode() {
        return this.randomCode;
    }

    public void setRandomCode( String randomCode ) {
        this.randomCode = randomCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey( String secretKey ) {
        this.secretKey = secretKey;
    }

    private UserFacadeLocal userFacade = null;

    public void setUserFacade( UserFacadeLocal userFacade ) {
        this.userFacade = userFacade;
    }


    /**
     * Reset password to default, this action will be called from a url link in email
     * TODO: Unfinished action.
     */
    public String resetToDefault() {

        Map<String, Object> reqParams = ActionContext.getContext().getParameters();

        if ( reqParams == null || reqParams.isEmpty() ) {
            addActionError( getText("error.invalid.link") );
            return Action.ERROR;
        }

        String mailAddr = (String) reqParams.get( "mailAddr" );
        String randCode = (String) reqParams.get( "randCode" );

        if ( logger.isDebugEnabled() ) {
            logger.debug(
                "Get params {} and {}.", new Object[] { mailAddr, randCode } );
        }

        if ( isBlank(mailAddr) || isBlank(randCode) ) {
            addActionError( getText("error.invalid.link") );
            return Action.ERROR;
        }

        String s3cret = "s3cret_pwd";
        boolean isReset = userFacade.resetPassword( email, randCode, s3cret );

        if ( !isReset ) {
            addActionError( getText("error.reset.default.password") );
            return Action.ERROR;
        }

        logger.info( "Password reset to default for: {}", new Object[] { mailAddr } );
        return   Action.SUCCESS;

    }


    /**
     * Reset password for user, in this action 'secretKey' is the new password, just rename it
     * hope you are not confused.
     */
    public String reset() {

        if ( logger.isDebugEnabled() ) {
            logger.debug(
                "Start to reset the password for user: {}", new Object[] { email } );
        }

        if ( isBlank(email) || isBlank(password) || isBlank(secretKey) ) {
            addActionError( getText("error.invalid.parameter") );
            return Action.ERROR;
        }

        boolean isReset = userFacade.resetPassword( email,
            password, secretKey );

        if ( !isReset ) {
            addActionError( getText("error.reset.password") );
            return Action.ERROR;
        }

        logger.info( "Password reset succeed for user: {}", new Object[] { email } );
        return   Action.SUCCESS;
    }


    /**
     * Execute action in case user forgot his/her password, a email will be sent, include a url
     * in the mail
     * if link was clicked then password will be reset to default
     */
    public String forgot() {

        if ( logger.isDebugEnabled() ) {
            logger.debug(
                "Started, email: {} random code: {}", new Object[] { email, randomCode } );
        }

        if ( isBlank( email ) || isBlank( randomCode ) ) {
            addActionError( getText("error.input") );
            return Action.INPUT;
        }

        String randomCodeHidden = (String) session.get( "RANDOM_CODE_HIDDEN" );

        if ( !randomCode.equalsIgnoreCase(randomCodeHidden) ) {
            addActionError(
                getText("error.random.code.not.match") );
            return Action.INPUT;
        }

        // Call backend ejb to check if it is valid email address
        boolean isDelivered = userFacade.sendPasswordResetVerificationMail( email );

        if ( !isDelivered ) {
            addActionError( getText("error.invalid.email") );
            return Action.ERROR;
        }

        logger.info( "Password reset email delivered to: {}.", new Object[] { email } );
        return   Action.SUCCESS;

    }


} //:~
