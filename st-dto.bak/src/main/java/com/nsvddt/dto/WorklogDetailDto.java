package cn.com.nsv.ejb.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorklogDetailDto { 
	
	private Integer workLogDetailSerialNum;
	
	private Date workDate;
	
	private Float dailyHours;
	
	private Float dailiyMealSupplement;
	
	private String realWorkPercent;
	
	private String workWeekDay;
	
	private Integer dateVersion;
	
	
	private List<WorklogWorksDetailDto> worklogWorksDetailDtoList = new ArrayList<WorklogWorksDetailDto>();
	

	public String getWorkWeekDay() {
		return workWeekDay;
	}

	public void setWorkWeekDay(String workWeekDay) {
		this.workWeekDay = workWeekDay;
	}

	public Date getWorkDate() {
		return workDate;
	}

	public void setWorkDate(Date workDate) {
		this.workDate = workDate;
	}

	public Float getDailyHours() {
		return dailyHours;
	}

	public void setDailyHours(Float dailyHours) {
		this.dailyHours = dailyHours;
	}

	public Float getDailiyMealSupplement() {
		return dailiyMealSupplement;
	}

	public void setDailiyMealSupplement(Float dailiyMealSupplement) {
		this.dailiyMealSupplement = dailiyMealSupplement;
	}

	public List<WorklogWorksDetailDto> getWorklogWorksDetailDtoList() {
		return worklogWorksDetailDtoList;
	}

	public void setWorklogWorksDetailDtoList(
			List<WorklogWorksDetailDto> worklogWorksDetailDtoList) {
		this.worklogWorksDetailDtoList = worklogWorksDetailDtoList;
	}

	public Integer getWorkLogDetailSerialNum() {
		return workLogDetailSerialNum;
	}

	public void setWorkLogDetailSerialNum(Integer workLogDetailSerialNum) {
		this.workLogDetailSerialNum = workLogDetailSerialNum;
	}

	public String getRealWorkPercent() {
		return realWorkPercent;
	}

	public void setRealWorkPercent(String realWorkPercent) {
		this.realWorkPercent = realWorkPercent;
	}

	public Integer getDateVersion() {
		return dateVersion;
	}

	public void setDateVersion(Integer dateVersion) {
		this.dateVersion = dateVersion;
	}

	
	
	
	
}
