package cn.com.nsv.ejb.dto;

public class WorklogCountDto {
	
	private String employeeId;
	
	private String employeeName;
	
	private Float normalWorktime;
	
	private Float actualWorktime;

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

	public Float getNormalWorktime() {
		return normalWorktime;
	}

	public void setNormalWorktime(Float normalWorktime) {
		this.normalWorktime = normalWorktime;
	}

	public Float getActualWorktime() {
		return actualWorktime;
	}

	public void setActualWorktime(Float actualWorktime) {
		this.actualWorktime = actualWorktime;
	}
}
