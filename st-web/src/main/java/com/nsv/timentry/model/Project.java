//: com.nsv.timentry.model: Project.java
package com.nsv.timentry.model;

import java.util.Date;
import java.io.Serializable;


/**
 * Model object only be used for struts framework
 *
 * @version 1.0.0 $ 2016-04-24 14:07 $
 */
public final class Project implements Serializable {


    private static final long serialVersionUID = 3921471775506400810L;

    // ------------------------------------------------------------------------
    private Integer id;
    private String  projNum;
    private String  name;

    private Date    startDate;
    private Date    closeDate;

    private boolean isProj;
    private int     budget;
    private char    status;
    private String  memo;
    private Short   leaderId;


    public Project() {
        // ......
    }

    public Project( Integer id, String projNum, String name,
                    Date startDate,
                    Date closeDate,
                    boolean isProj,
                    int  budget, char status, String memo, Short leaderId ) {

        this.id        = id;
        this.projNum   = projNum;
        this.name      = name;
        this.startDate = startDate;
        this.closeDate = closeDate;
        this.isProj    = isProj;
        this.budget    = budget;
        this.status    = status;
        this.memo      = memo;
        this.leaderId  = leaderId;
    }


    // ------------------------------------------------------------------------
    public Integer getId() {
        return this.id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getProjNum() {
        return projNum;
    }

    public void setProjNum( String projNum ) {
        this.projNum = projNum;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate( Date startDate ) {
        this.startDate = startDate;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate( Date closeDate ) {
        this.closeDate = closeDate;
    }

    public boolean isProj() {
        return isProj;
    }

    public void setProj( boolean isProj ) {
        this.isProj = isProj;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget( int budget ) {
        this.budget = budget;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus( char status ) {
        this.status = status;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo( String memo ) {
        this.memo = memo;
    }

    public Short getLeaderId() {
        return leaderId;
    }

    public void setLeaderId( Short leaderId ) {
        this.leaderId = leaderId;
    }
    // ------------------------------------------------------------------------


} //:~
