package cn.com.nsv.ejb.dto;

import java.util.Date;


public class YearWorkDateDto {
	
	private Integer workCalenderSn;
	private String yearMonth;
    private Date date;
    private String dateType;
    private Float workHour;
    private String dateMemo;
    private String dateTypeShow;
    private Integer workWeek;
    private Integer dateVersion;
	public Integer getWorkWeek() {
		return workWeek;
	}
	public void setWorkWeek(Integer workWeek) {
		this.workWeek = workWeek;
	}
	public Integer getWorkCalenderSn() {
		return workCalenderSn;
	}
	public void setWorkCalenderSn(Integer workCalenderSn) {
		this.workCalenderSn = workCalenderSn;
	}
	public String getYearMonth() {
		return yearMonth;
	}
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDateType() {
		return dateType;
	}
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	public Float getWorkHour() {
		return workHour;
	}
	public void setWorkHour(Float workHour) {
		this.workHour = workHour;
	}
	public String getDateMemo() {
		return dateMemo;
	}
	public void setDateMemo(String dateMemo) {
		this.dateMemo = dateMemo;
	}
	public String getDateTypeShow() {
		return dateTypeShow;
	}
	public void setDateTypeShow(String dateTypeShow) {
		this.dateTypeShow = dateTypeShow;
	}
	public Integer getDateVersion() {
		return dateVersion;
	}
	public void setDateVersion(Integer dateVersion) {
		this.dateVersion = dateVersion;
	}
    
    
    
    
}
