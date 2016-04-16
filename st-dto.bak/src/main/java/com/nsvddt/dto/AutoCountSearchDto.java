package cn.com.nsv.ejb.dto;

public class AutoCountSearchDto extends SearchCommonDto{

	private static final long serialVersionUID = 1L;
	
	private String employeeId;
	
	private String yearMonth;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getYearMonth() {
		return yearMonth;
	}

	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}

}
