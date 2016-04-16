package cn.com.nsv.ejb.dto;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorklogDto {
	
	private Integer workLogSN;
	
	private String workLogYear;
	
	private Integer workLogWeek;
	
	private String workLogStatus;
	
	private String workLogStatusShow;
	
	private String employeeId;
	
	private String employeeName;
	
	private Float totalNormalHours;
	
	private Float totalOvertimeHours;
	
	private Float totalLeaveHours;
	
	
	
	private Map<String,String> projectMap = new HashMap<String,String>();
	
	private String projectString;
	
	private String projectIds;
	
	private String normalPercent;
	
	private List<WorklogDetailDto> worklogDetailDtoList = new ArrayList<WorklogDetailDto>();
	
	private List<WorklogRecordDto> worklogRecordDtoList = new ArrayList<WorklogRecordDto>();
	
	private String workDate;
	
	private Float totalxiuHours;
	
	public Float getTotalxiuHours() {
		return totalxiuHours;
	}

	public void setTotalxiuHours(Float totalxiuHours) {
		this.totalxiuHours = totalxiuHours;
	}

	public String getWorkDate() {
		return workDate;
	}

	public void setWorkDate(String workDate) {
		this.workDate = workDate;
	}

	public Integer getWorkLogSN() {
		return workLogSN;
	}

	public void setWorkLogSN(Integer workLogSN) {
		this.workLogSN = workLogSN;
	}

	public String getWorkLogYear() {
		return workLogYear;
	}

	public void setWorkLogYear(String workLogYear) {
		this.workLogYear = workLogYear;
	}

	public Integer getWorkLogWeek() {
		return workLogWeek;
	}

	public void setWorkLogWeek(Integer workLogWeek) {
		this.workLogWeek = workLogWeek;
	}

	public String getWorkLogStatus() {
		return workLogStatus;
	}

	public void setWorkLogStatus(String workLogStatus) {
		this.workLogStatus = workLogStatus;
	}

	public String getWorkLogStatusShow() {
		return workLogStatusShow;
	}

	public void setWorkLogStatusShow(String workLogStatusShow) {
		this.workLogStatusShow = workLogStatusShow;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public List<WorklogDetailDto> getWorklogDetailDtoList() {
		return worklogDetailDtoList;
	}

	public void setWorklogDetailDtoList(List<WorklogDetailDto> worklogDetailDtoList) {
		this.worklogDetailDtoList = worklogDetailDtoList;
	}

	public List<WorklogRecordDto> getWorklogRecordDtoList() {
		return worklogRecordDtoList;
	}

	public void setWorklogRecordDtoList(List<WorklogRecordDto> worklogRecordDtoList) {
		this.worklogRecordDtoList = worklogRecordDtoList;
	}

	public Float getTotalNormalHours() {
		return totalNormalHours;
	}

	public void setTotalNormalHours(Float totalNormalHours) {
		this.totalNormalHours = totalNormalHours;
	}

	public Float getTotalOvertimeHours() {
		return totalOvertimeHours;
	}

	public void setTotalOvertimeHours(Float totalOvertimeHours) {
		this.totalOvertimeHours = totalOvertimeHours;
	}

	public Float getTotalLeaveHours() {
		return totalLeaveHours;
	}

	public void setTotalLeaveHours(Float totalLeaveHours) {
		this.totalLeaveHours = totalLeaveHours;
	}

	public Map<String, String> getProjectMap() {
		return projectMap;
	}

	public void setProjectMap(Map<String, String> projectMap) {
		this.projectMap = projectMap;
	}

	public String getProjectString() {
		return projectString;
	}

	public void setProjectString(String projectString) {
		this.projectString = projectString;
	}

	public String getNormalPercent() {
		return normalPercent;
	}

	public void setNormalPercent(String normalPercent) {
		this.normalPercent = normalPercent;
	}

	public String getProjectIds() {
		return projectIds;
	}

	public void setProjectIds(String projectIds) {
		this.projectIds = projectIds;
	}
	
	
}
