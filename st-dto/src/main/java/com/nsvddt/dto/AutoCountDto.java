package cn.com.nsv.ejb.dto;

public class AutoCountDto {
	
	private String employeeId;
	
	private String employeeName;
	
	private String yearMonth;
	
	private Integer monthNormalWorkDay;
	
	private Integer monthEmTotalWorkDay;
	
	private Float normalWorkDayMealSupplement;
	
	private Integer overWorkDay;
	
	private Integer overWeekDay;
	
	private Float overWorkDayMealSupplement;
	
	private Float overWeekDayMealSupplement;

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

	public String getYearMonth() {
		return yearMonth;
	}

	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}

	public Integer getMonthNormalWorkDay() {
		return monthNormalWorkDay;
	}

	public void setMonthNormalWorkDay(Integer monthNormalWorkDay) {
		this.monthNormalWorkDay = monthNormalWorkDay;
	}

	public Integer getMonthEmTotalWorkDay() {
		return monthEmTotalWorkDay;
	}

	public void setMonthEmTotalWorkDay(Integer monthEmTotalWorkDay) {
		this.monthEmTotalWorkDay = monthEmTotalWorkDay;
	}

	public Float getNormalWorkDayMealSupplement() {
		return normalWorkDayMealSupplement;
	}

	public void setNormalWorkDayMealSupplement(Float normalWorkDayMealSupplement) {
		this.normalWorkDayMealSupplement = normalWorkDayMealSupplement;
	}

	public Integer getOverWorkDay() {
		return overWorkDay;
	}

	public void setOverWorkDay(Integer overWorkDay) {
		this.overWorkDay = overWorkDay;
	}

	public Integer getOverWeekDay() {
		return overWeekDay;
	}

	public void setOverWeekDay(Integer overWeekDay) {
		this.overWeekDay = overWeekDay;
	}

	public Float getOverWorkDayMealSupplement() {
		return overWorkDayMealSupplement;
	}

	public void setOverWorkDayMealSupplement(Float overWorkDayMealSupplement) {
		this.overWorkDayMealSupplement = overWorkDayMealSupplement;
	}

	public Float getOverWeekDayMealSupplement() {
		return overWeekDayMealSupplement;
	}

	public void setOverWeekDayMealSupplement(Float overWeekDayMealSupplement) {
		this.overWeekDayMealSupplement = overWeekDayMealSupplement;
	}
}
