//: com.nsv.timentry.service: ProjectFacadeLocal.java
package com.nsv.timentry.service;

import com.nsv.timentry.dto.ProjectDTO;

import javax.ejb.Local;


/**
 * Project bean local interface
 *
 * @version 1.0.0 $ 2016-04-16 15:32 $
 */
@Local
public interface ProjectFacadeLocal {

    boolean create( ProjectDTO project );
    boolean update( ProjectDTO project );


} //:~
