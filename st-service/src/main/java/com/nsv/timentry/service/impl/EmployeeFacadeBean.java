//: com.nsv.timentry.service.impl: EmployeeFacadeBean.java
package com.nsv.timentry.service.impl;

import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import com.nsv.timentry.manager.*;
import com.nsv.timentry.service.*;

import com.nsv.timentry.entity.Employee;

import com.nsv.timentry.dto.CertificateDTO;
import com.nsv.timentry.dto.UserDTO;
import com.nsv.timentry.dto.EmployeeDTO;


/**
 * Employee facade bean
 * 
 * @version 1.0.0 $ 2016-03-28 18:21 $
 */
@Stateless( name = "EmployeeFacade" )
public class EmployeeFacadeBean implements EmployeeFacadeLocal, EmployeeFacade {


    private static final Logger logger = LoggerFactory.getLogger( EmployeeFacadeBean.class );

    @EJB
    private CertificateManagerLocal  certMgr;

    @EJB
    private UserManagerLocal         userMgr;

    @EJB
    private EmployeeManagerLocal employeeMgr;

/*
    @Override
    public Collection<EmployeeDTO> listByPage( int curPage, int pageSize ) {
        return null;
    }
*/
    @Override
    public boolean register( EmployeeDTO employee, UserDTO user ) {

        String email = employee.email();

        // Insert into table 'EMPLOYEES' using SQL
        Object[] empParams = employee.asArrayInDBOrder();
        Employee empInDB   = employeeMgr.createBySQLThenGrab( email, empParams );

        if ( empInDB == null ) {
            logger.info( "Not able to create employee, get a null." );
            return false;
        }

        // Get empId then set it into object parameters
        Short empId = empInDB.getId();

        // Insert into table 'USERS' using SQL
        Object[] userParams = user.asArrayInDBOrder();
        userParams[2] = empId;  // TODO: Awkward, who knows this magic number ???

        return userMgr.createBySQL( userParams );

    }


    @Override
    public boolean register( EmployeeDTO employee, UserDTO user, Collection<CertificateDTO> certs ) {

        if ( !register( employee, user ) ) {
            return false;
        }

        if ( certs == null || certs.isEmpty() ) {
            return true;
        }

        // Loop collection of certs then insert into table 'CERTIFICATIONS', ignore
        String email = employee.email();
        Short  empId = employeeMgr.findByEmail( email ).getId();

        Object[] params;

        for ( CertificateDTO cert : certs ) {

            params = cert.asArrayInDBOrder();
            params[1] = empId; // TODO: Again, magic number

            if ( !certMgr.createBySQL( params ) ) {
                logger.info(
                        "Not able to create certificate {}, but ignored...", cert.certName() );
            }

        }

        return true;

    }


} //:~
