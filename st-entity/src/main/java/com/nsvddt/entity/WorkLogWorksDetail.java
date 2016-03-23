package cn.com.nsv.ejb.entity;

// Generated 2014-3-19 10:42:29 by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.Length;

/**
 * WorkLogWorksDetail generated by hbm2java
 */
@Entity
@Table(name = "work_log_works_detail", catalog = "nsvims")
public class WorkLogWorksDetail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer wlwdSn;
    private int workLogDetailSerialNum;
    private Character wlwdType;
    private Character workPart;
    private String projectId;
    private String workContent;
    private Float partHour;
    private Date wlwdStartTime;
    private Date wlwdEndTime;
    private Character workPlace;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "wlwd_sn", unique = true, nullable = false)
    public Integer getWlwdSn() {
        return this.wlwdSn;
    }

    public void setWlwdSn(Integer wlwdSn) {
        this.wlwdSn = wlwdSn;
    }

    @Column(name = "work_log_detail_serial_num", nullable = false)
    public int getWorkLogDetailSerialNum() {
        return this.workLogDetailSerialNum;
    }

    public void setWorkLogDetailSerialNum(int workLogDetailSerialNum) {
        this.workLogDetailSerialNum = workLogDetailSerialNum;
    }

    @Column(name = "wlwd_type", length = 1)
    public Character getWlwdType() {
        return this.wlwdType;
    }

    public void setWlwdType(Character wlwdType) {
        this.wlwdType = wlwdType;
    }

    @Column(name = "work_part", length = 1)
    public Character getWorkPart() {
        return this.workPart;
    }

    public void setWorkPart(Character workPart) {
        this.workPart = workPart;
    }

    @Column(name = "project_id", length = 50)
    @Length(max = 50)
    public String getProjectId() {
        return this.projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Column(name = "work_content", length = 500)
    @Length(max = 500)
    public String getWorkContent() {
        return this.workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    @Column(name = "part_hour", precision = 12, scale = 0)
    public Float getPartHour() {
        return this.partHour;
    }

    public void setPartHour(Float partHour) {
        this.partHour = partHour;
    }

    @Temporal(TemporalType.TIME)
    @Column(name = "wlwd_startTime", length = 8)
    public Date getWlwdStartTime() {
        return this.wlwdStartTime;
    }

    public void setWlwdStartTime(Date wlwdStartTime) {
        this.wlwdStartTime = wlwdStartTime;
    }

    @Temporal(TemporalType.TIME)
    @Column(name = "wlwd_endTime", length = 8)
    public Date getWlwdEndTime() {
        return this.wlwdEndTime;
    }

    public void setWlwdEndTime(Date wlwdEndTime) {
        this.wlwdEndTime = wlwdEndTime;
    }

    @Column(name = "work_place", length = 1)
    public Character getWorkPlace() {
        return this.workPlace;
    }

    public void setWorkPlace(Character workPlace) {
        this.workPlace = workPlace;
    }


}