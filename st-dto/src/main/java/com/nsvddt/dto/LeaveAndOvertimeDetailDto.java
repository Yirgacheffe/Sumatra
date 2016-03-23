package cn.com.nsv.ejb.dto;


public class LeaveAndOvertimeDetailDto {
	
	private String laodDiscription;
	
	private Character laodFlag;
	
	private String laodFlagShow;
	
	private Float laodHours;
	
	private String laodStartTime;
	
	private String laodEndTime;
	
	private String workPart;
	
	private String workPartShow;
	
	private String projectId;
	
	private String workPlace;
	
	private String workPlaceShow;
	
	public String getWorkPartShow() {
		return workPartShow;
	}

	public void setWorkPartShow(String workPartShow) {
		this.workPartShow = workPartShow;
	}

	public String getLaodDiscription() {
		return laodDiscription;
	}

	public void setLaodDiscription(String laodDiscription) {
		this.laodDiscription = laodDiscription;
	}
	
	public Character getLaodFlag() {
		return laodFlag;
	}

	public void setLaodFlag(Character laodFlag) {
		this.laodFlag = laodFlag;
	}

	public Float getLaodHours() {
		return laodHours;
	}

	public void setLaodHours(Float laodHours) {
		this.laodHours = laodHours;
	}

	public String getLaodStartTime() {
		return laodStartTime;
	}

	public void setLaodStartTime(String laodStartTime) {
		this.laodStartTime = laodStartTime;
	}

	public String getLaodEndTime() {
		return laodEndTime;
	}

	public void setLaodEndTime(String laodEndTime) {
		this.laodEndTime = laodEndTime;
	}

	public String getWorkPart() {
		return workPart;
	}

	public void setWorkPart(String workPart) {
		this.workPart = workPart;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getWorkPlace() {
		return workPlace;
	}

	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}

	public String getWorkPlaceShow() {
		return workPlaceShow;
	}

	public void setWorkPlaceShow(String workPlaceShow) {
		this.workPlaceShow = workPlaceShow;
	}

	public String getLaodFlagShow() {
		return laodFlagShow;
	}

	public void setLaodFlagShow(String laodFlagShow) {
		this.laodFlagShow = laodFlagShow;
	}

	
	
	
}
