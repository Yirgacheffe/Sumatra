//: com.nsv.timentry.service: EmployeeBeanLocal.java
package com.nsv.timentry.service;

import java.util.Collection;

import javax.ejb.Local;

import com.nsv.timentry.dto.EmployeeDTO;
import com.nsv.timentry.dto.UserDTO;
import com.nsv.timentry.dto.CertificateDTO;


/**
 * Employee bean local interface
 * 
 * @version 1.0.0 $ 2016-03-28 18:24 $
 */
@Local
public interface EmployeeFacadeLocal {

    boolean register( EmployeeDTO employee, UserDTO user );
    boolean register( EmployeeDTO employee, UserDTO user, Collection<CertificateDTO> certificates );

    // Collection<EmployeeDTO> listByPage( int curPage, int pageSize );
    
} //:~
