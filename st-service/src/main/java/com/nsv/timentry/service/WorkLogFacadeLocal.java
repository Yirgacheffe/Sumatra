//: com.nsv.timentry.service: WorkLogFacadeLocal.java
package com.nsv.timentry.service;

import java.util.Collection;
import javax.ejb.Local;

/**
 *
 */
@Local
public interface WorkLogFacadeLocal {

    Collection<String> retrievalEmailsWhoNotSubmitWorkLog(int year, int workWeek );

} //:~
