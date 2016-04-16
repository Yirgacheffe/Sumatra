//: com.nsv.timentry.dto: PageSetting.java
package com.nsv.timentry.dto;

import java.io.Serializable;


/**
 * Read only page settings for search result to display
 * 
 * @version 1.0.0 $ 2016-03-28 16:45 $
 */
public final class PageSetting implements Serializable {

    
    private static final long serialVersionUID = 2270814783289909260L;
    
    private final String  sortedId;
    private final String  sortOrder;

    private Integer pageStarted = 0;
    private Integer pageSize    = 10;
    
    
    public PageSetting( String  sortedId, String sortOrder, 
                        Integer pageStarted, 
                        Integer pageSize ) {
    
        this.sortedId    = sortedId;
        this.sortOrder   = sortOrder;
        this.pageStarted = pageStarted;
        this.pageSize    = pageSize;
    
    }
    
    public String sortedId() {
        return this.sortedId;
    }
    
    public String sortOrder() {
        return this.sortOrder;
    }
    
    public Integer pageStarted() {
        return this.pageStarted;
    }
    
    public Integer pageSize() {
        return this.pageSize;
    }
    
    
    
    
} //:~
