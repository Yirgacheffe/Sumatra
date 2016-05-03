//: com.nsv.timentry.manager: ProjectManagerLocal.java
package com.nsv.timentry.manager;

import java.util.List;

import javax.ejb.Local;
import com.nsv.timentry.entity.Project;


/**
 * Project manager bean local interface perform basic CRUD operation
 *
 * @version 1.0.0 $ 2016-04-01 13:11 $
 */
@Local
public interface ProjectManagerLocal extends GenericManagerLocal<Project, Integer> {

    List<Project> findByProjLeader( String leaderName );

    Project findByProjNum( String projNum );

    List<Project> findByProjName( String projName );
    boolean createBySQL( Object[] dbOrderedParams );


} //:~
