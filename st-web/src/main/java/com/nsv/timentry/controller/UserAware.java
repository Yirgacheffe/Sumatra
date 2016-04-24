//: com.nsv.timentry.interceptor: UserAware.java
package com.nsv.timentry.controller;

import com.nsv.timentry.model.User;

/**
 * UserAware interface identify the which action contains User instance
 *
 * @version 1.0.0 $ 2016-04-17 20:12 $
 */
public interface UserAware {

    void setUser( User user );  // Set user into Action which in this session

} //:~
