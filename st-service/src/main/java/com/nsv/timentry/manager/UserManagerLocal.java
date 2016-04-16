//: com.nsv.timentry.manager: UserManagerLocal.java
package com.nsv.timentry.manager;

import javax.ejb.Local;

import com.nsv.timentry.entity.User;


/**
 * User manager bean local interface perform basic CRUD operation
 * 
 * @version 1.0.0 $ 2016-03-29 22:45 $
 */
@Local
public interface UserManagerLocal extends GenericManagerLocal< User, Short > {

    User findByEmail( String email );
    User createBySQLThenGrab( String email, Object[] dbOrderedParams );

    boolean createBySQL( Object[] dbOrderedParams );

} //:~
