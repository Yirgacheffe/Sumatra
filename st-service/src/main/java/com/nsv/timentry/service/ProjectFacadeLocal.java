//: com.nsv.timentry.service: ProjectFacadeLocal.java
package com.nsv.timentry.service;

import java.util.Date;
import java.util.Collection;
import javax.ejb.Local;

import com.nsv.timentry.dto.ProjectDTO;


/**
 * Project bean local interface
 *
 * @version 1.0.0 $ 2016-04-16 15:32 $
 */
@Local
public interface ProjectFacadeLocal {

    boolean create( ProjectDTO project );
    boolean update( ProjectDTO project );

    ProjectDTO findById( Integer id );


    Collection<ProjectDTO> queryByProjLeader( String leaderName );

    Collection<ProjectDTO> queryByProjNum( String projNum );

    /*
    Collection<ProjectDTO> queryByProjName( String projName );
    Collection<ProjectDTO> queryByProjectDate( Date startDate, Date closeDate );
    */

} //:~
