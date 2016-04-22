//: com.nsv.timentry.interceopter: LoginInterceptor.java
package com.nsv.timentry.interceptor;

import com.nsv.timentry.controller.UserAware;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.ActionInvocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nsv.timentry.dto.UserDTO;


/**
 * Check user login status, if not login redirect to index page
 *
 * @version 1.0.0 $ 2016-04-17 16:23 $
 */
public class LoginInterceptor extends AbstractInterceptor {


    private static final long serialVersionUID = 3613947491238633005L;
    private static final Logger logger = LoggerFactory.getLogger( LoginInterceptor.class );

    @Override
    public void destroy() {
        // nothing, place holder
    }

    @Override
    public void init() {
        // nothing, place holder
    }

    @Override
    public String intercept( ActionInvocation proxy ) throws Exception {

        // If action is 'login', go and execute
        ActionContext ctx = proxy.getInvocationContext();
        String actionName = ctx.getName();

        logger.debug( "Intercept started, target action: {}", actionName );

        if ( isLoginIgnoredAction(actionName) ) {
            return proxy.invoke();
        }

        Object user = ctx.getSession().get( "LOGIN_USER" );

        if ( user == null ) {
            return Action.LOGIN;
        }

        Action action = (Action) proxy.getAction();

        if ( action instanceof UserAware) {
            ( (UserAware) action ).setUser( (UserDTO) user );
        }

        logger.debug( "Intercept closed, invoke action: {}",  actionName );

        return proxy.invoke();

    }


    /**
     * Some pages do not need to login, as following
     */
    private boolean isLoginIgnoredAction( String action ) {
        return action.equals( "login" ) || action.equals( "index"  )
                                        || action.equals( "logout" )
                                        || action.equals( "forgotPassword" ) || action.equals( "resetPassword" );
    }


} //:~
