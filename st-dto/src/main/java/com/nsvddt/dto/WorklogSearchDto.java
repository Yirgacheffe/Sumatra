package cn.com.nsv.ejb.dto;

import java.util.ArrayList;
import java.util.List;


public class WorklogSearchDto extends SearchCommonDto{

	private static final long serialVersionUID = 1L;
	
	private String year;
	
	private String week;
	
	private String employeeId;
	
	private String worklogStatus;
	
	private String approvallerId;
	
	private String approvalStatus;
	
	private List<String> employeeIdList = new ArrayList<String>();
	
	private String month;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getWorklogStatus() {
		return worklogStatus;
	}

	public void setWorklogStatus(String worklogStatus) {
		this.worklogStatus = worklogStatus;
	}

	public String getApprovallerId() {
		return approvallerId;
	}

	public void setApprovallerId(String approvallerId) {
		this.approvallerId = approvallerId;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public List<String> getEmployeeIdList() {
		return employeeIdList;
	}

	public void setEmployeeIdList(List<String> employeeIdList) {
		this.employeeIdList = employeeIdList;
	}

	
	
	
	
}
