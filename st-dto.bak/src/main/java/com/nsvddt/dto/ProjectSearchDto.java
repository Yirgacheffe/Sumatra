package cn.com.nsv.ejb.dto;

import java.util.Date;

public class ProjectSearchDto extends SearchCommonDto{
	
	private static final long serialVersionUID = 1L;
	private String projectId;
	private String projectName;
	private String projectLeaderName;
	private Date projectStartTime;
	private Date projectEndTime;
	private String projectStatus;
	private double totalTime;
	private double addWork;
	private double qiangjia;
	private String EmployeeId;
	
	private String EmployeeName;
	private String EmpTime;
	
	private double EAddWork;
	private double EQingjia;
	private double ETotalTime;
	private Date workDate;
	private String workContent;
	private Integer wlwdSn;
	private String bili;
	private double xiujia;
	public double getXiujia() {
		return xiujia;
	}
	public void setXiujia(double xiujia) {
		this.xiujia = xiujia;
	}
	public String getBili() {
		return bili;
	}
	public void setBili(String bili) {
		this.bili = bili;
	}
	public Integer getWlwdSn() {
		return wlwdSn;
	}
	public void setWlwdSn(Integer wlwdSn) {
		this.wlwdSn = wlwdSn;
	}
	public Date getWorkDate() {
		return workDate;
	}
	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}
	public String getWorkContent() {
		return workContent;
	}
	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}
	public double getEQingjia() {
		return EQingjia;
	}
	public void setEQingjia(double eQingjia) {
		EQingjia = eQingjia;
	}
	public double getETotalTime() {
		return ETotalTime;
	}
	public void setETotalTime(double eTotalTime) {
		ETotalTime = eTotalTime;
	}
	public double getEAddWork() {
		return EAddWork;
	}
	public void setEAddWork(double eAddWork) {
		EAddWork = eAddWork;
	}
	private String startTime;
	private String endTime;
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	public double getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(double totalTime) {
		this.totalTime = totalTime;
	}
	public double getAddWork() {
		return addWork;
	}
	public void setAddWork(double addWork) {
		this.addWork = addWork;
	}
	public double getQiangjia() {
		return qiangjia;
	}
	public void setQiangjia(double qiangjia) {
		this.qiangjia = qiangjia;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public String getEmpTime() {
		return EmpTime;
	}
	public void setEmpTime(String empTime) {
		EmpTime = empTime;
	}
	public String getProjectId(){
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
	public String getProjectLeaderName() {
		return projectLeaderName;
	}
	public void setProjectLeaderName(String projectLeaderName) {
		this.projectLeaderName = projectLeaderName;
	}
	public Date getProjectStartTime() {
		return projectStartTime;
	}
	public void setProjectStartTime(Date projectStartTime) {
		this.projectStartTime = projectStartTime;
	}
	public Date getProjectEndTime() {
		return projectEndTime;
	}
	public void setProjectEndTime(Date projectEndTime) {
		this.projectEndTime = projectEndTime;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	
	
	
}
