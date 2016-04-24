//: com.nsv.timentry.manager: ProjectManagerLocal.java
package com.nsv.timentry.manager;

import javax.ejb.Local;
import com.nsv.timentry.entity.Project;


/**
 * Project manager bean local interface perform basic CRUD operation
 *
 * @version 1.0.0 $ 2016-04-01 13:11 $
 */
@Local
public interface ProjectManagerLocal extends GenericManagerLocal<Project, Integer> {

    boolean createBySQL( Object[] dbOrderedParams );
    Project findByProjNum( String projNum );

} //:~
