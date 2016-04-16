package cn.com.nsv.ejb.dto;

import java.util.Date;

public class ProjectDto {

	private Integer projectSn;
	private String projectId;
	private String projectName;
	private String projectLeaderId;
	private String projectLeaderName;
	private String projectType;
	private String projectTypeShow;
	private Float expenseBudget;
	private Date projectStartTime;
	private String projectStatus;
	private String memo;
	
	
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public String getProjectTypeShow() {
		return projectTypeShow;
	}
	public void setProjectTypeShow(String projectTypeShow) {
		this.projectTypeShow = projectTypeShow;
	}
	public String getProjectLeaderName() {
		return projectLeaderName;
	}
	public void setProjectLeaderName(String projectLeaderName) {
		this.projectLeaderName = projectLeaderName;
	}
	public Integer getProjectSn() {
		return projectSn;
	}
	public void setProjectSn(Integer projectSn) {
		this.projectSn = projectSn;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectLeaderId() {
		return projectLeaderId;
	}
	public void setProjectLeaderId(String projectLeaderId) {
		this.projectLeaderId = projectLeaderId;
	}
	public Float getExpenseBudget() {
		return expenseBudget;
	}
	public void setExpenseBudget(Float expenseBudget) {
		this.expenseBudget = expenseBudget;
	}
	public Date getProjectStartTime() {
		return projectStartTime;
	}
	public void setProjectStartTime(Date projectStartTime) {
		this.projectStartTime = projectStartTime;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
	
	
	
}
