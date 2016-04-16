//: com.nsv.timentry.manager: CertificateManagerLocal.java
package com.nsv.timentry.manager;

import javax.ejb.Local;
import com.nsv.timentry.entity.Certificate;


/**
 * Certificate manager bean local interface perform basic CRUD operation
 *
 * @version 1.0.0 $ 2016-04-01 12:34 $
 */
@Local
public interface CertificateManagerLocal extends GenericManagerLocal<Certificate, Short> {

    boolean createBySQL( Object[] dbOrderedParams );

} //:~
