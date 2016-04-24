//: com.nsv.timentry.manager.impl: EmployeeManagerBean.java
package com.nsv.timentry.manager.impl;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.nsv.timentry.manager.EmployeeManagerLocal;
import com.nsv.timentry.entity.Employee;


/**
 * Employee manager bean perform basic CRUD and some query operation
 * 
 * @version 1.0.0 $ 2016-03-29 15:26 $
 */
@Stateless( name = "EmployeeManager" )
public class EmployeeManagerBean extends GenericManagerBean< Employee, Short >
        implements EmployeeManagerLocal {

    
    private static final Logger logger = LoggerFactory.getLogger( EmployeeManagerBean.class );

    private static final String SQL_INSERT = "INSERT INTO EMPLOYEES "
            + "( "
            +   "NAME, "
            +   "GENDER, "
            +   "EMAIL, "
            +   "ON_BOARD_DATE, "
            +   "DEPT_ID, "
            +   "PROBATION_END, "
            +   "DIPLOMA_ID, "
            +   "GRADUATION_YR, "
            +   "COLLEGE, "
            +   "MAJOR, "
            +   "HR_ROLE_ID, "
            +   "POSITION, "
            +   "NATION, "
            +   "IS_MARRIED, "
            +   "POLITICAL_TYPE, "
            +   "RESIDENCE, "
            +   "IS_AGRICULTURAL, "
            +   "IDCARD_NUM, "
            +   "LAST_WORKING_DAY, "
            +   "ARCHIVE_FILE, "
            +   "MEMO "
            + ") VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";


    @PersistenceContext( unitName = "NsvTimentry-JTA" )
    private EntityManager em;

    public EmployeeManagerBean() {
        super( Employee.class );
    }

    @Override
    protected EntityManager em() {
        return em;
    }


    @Override
    public void update( Employee employee ) {
        
        Short id = employee.getId();
        
        if( findById( id ) == null ) {
            throw new IllegalArgumentException( "No employee with ID: " + id );
        }
        
        em.merge( employee );
        
    }


    @Override
    public Employee findByEmail( String email ) {

        return em.createNamedQuery( "Employee.findByEmail", Employee.class )
                 .setParameter( "email", email )
                 .getSingleResult();

    }


    @Override
    public Employee createBySQLThenGrab( String email, Object[] dbOrderedParams ) {

        Query q = em.createNativeQuery( SQL_INSERT );

        for ( int i = 0, n = dbOrderedParams.length; i < n; i++ ) {
            q.setParameter( i + 1, dbOrderedParams[i] );
        }

        int affectRows = q.executeUpdate();

        if ( affectRows != 1 ) {
            logger.debug(
                    "Employee.SQL: exec {} not able to create new record.", SQL_INSERT );
            return null;
        } else {
            return this.findByEmail( email );
        }

    }


    @Override
    public Collection<Employee> queryByNameAndEmailInLikeStyle( String name, String email, boolean isRemoved ) {

        //: TODO: not quite well
        final String nameLikeSql = name  + "%";
        final String mailLikeSql = email + "%";

        return em.createNamedQuery( "Employee.findByNameAndEmailWithLike", Employee.class )
                .setParameter( "name",    nameLikeSql )
                .setParameter( "email",   mailLikeSql )
                .setParameter( "removed", isRemoved ).getResultList();

    }


} //:~
