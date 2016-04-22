//: com.nsv.timentry.service: UserFacadeLocal.java
package com.nsv.timentry.service;

import javax.ejb.Local;
import com.nsv.timentry.dto.UserDTO;


/**
 * User bean local interface
 *
 * @version 1.0.0 $ 2016-04-04 02:11 $
 */
@Local
public interface UserFacadeLocal {

    boolean sendPasswordResetVerificationMail( String email );
    UserDTO login( String email, String password );

    boolean resetPassword( String email, String password, String secretKey );

} //:~
