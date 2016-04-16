//: com.nsv.timentry.service.impl: UserFacadeBean.java
package com.nsv.timentry.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nsv.timentry.manager.UserManagerLocal;
import com.nsv.timentry.service.UserFacade;
import com.nsv.timentry.service.UserFacadeLocal;

import com.nsv.timentry.entity.Employee;
import com.nsv.timentry.entity.User;
import com.nsv.timentry.entity.Role;
import com.nsv.timentry.entity.Office;

import com.nsv.timentry.dto.UserDTO;


/**
 * User facade bean
 *
 * @version 1.0.0 $ 2016-04-02 16:16 $
 */
@Stateless( name = "UserFacade" )
public class UserFacadeBean implements UserFacade, UserFacadeLocal {


    private static final Logger logger = LoggerFactory.getLogger( UserFacadeBean.class );

    @PersistenceContext( unitName = "NsvTimentry-JTA" )
    private EntityManager em;

    @EJB
    private UserManagerLocal userMgr;

    @Override
    public UserDTO login( String email, String password ) {

        User user = checkUserStatusThenGetIfOK( email, password );

        if ( user == null ) {
            return null;
        }

        final Employee empInfo = user.getEmployee();
        final Role     role    = user.getRole();
        final Office   office  = user.getOffice();
        final Employee manager = user.getManager();

        // Nothing, for fun and might be easy to remember
        Short  id       = user.getId();
        Short  empId    = empInfo.getId();
        Short  mgrId    = manager.getId();
        Short  roleId   = role.getId();
        String roleType = role.getType();
        Short  officeId = office.getId();
        String name     = empInfo.getName();

        return ( new UserDTO.Builder() ).id( id ).name( name ).roleId( roleId )
                                        .roleType( roleType )
                                        .email( email )
                                        .empId( empId )
                                        .managerId( mgrId ).officeId( officeId ).build();

    }

    @Override
    public boolean resetPassword( String email,
                                  String password, String newPassword ) {

        User user = checkUserStatusThenGetIfOK( email, password );

        if ( user == null ) {
            return false;
        } else {
            user.setPassword( newPassword );
            userMgr.update( user );

            return true;    // Reset password OK? We hope so...
        }

    }

    private User checkUserStatusThenGetIfOK( String email, String password ) {

        User user = userMgr.findByEmail( email );

        if ( user.isRemoved() ) {
            logger.info(
                    "The user with email {} was removed.",
                    new Object[] { email } );

            return null;
        }

        String passwordInDB = user.getPassword();

        if ( !passwordInDB.equals( password ) ) {
            logger.info(
                    "Incorrect password input for user {}.",
                    new Object[] { email } );

            return null;
        }

        return user;  // Seems user status is OK , not removed, password is OK

    }


} //:~
