package com.nsv.timentry.manager;

import javax.ejb.Local;
import com.nsv.timentry.entity.LogItem;


/**
 * LogItem manager bean local interface perform basic CRUD operation
 *
 * @version 1.0.0 $ 2016-04-01 13:02 $
 */
@Local
public interface LogItemManagerLocal extends GenericManagerLocal<LogItem, Integer> {

    boolean createBySQL( Object[] dbOrderedParams );

} //:~
