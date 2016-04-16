package cn.com.nsv.ejb.dto;

public class WorklogRecordDto {
	
	private Integer workLogRecordSn;
    private Integer workLogSn;
    private String workLogRecordStatus;
    private String workLogRecordMemo;
    private String employeeId;
    private String employeeName;
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Integer getWorkLogRecordSn() {
		return workLogRecordSn;
	}
	public void setWorkLogRecordSn(Integer workLogRecordSn) {
		this.workLogRecordSn = workLogRecordSn;
	}
	public Integer getWorkLogSn() {
		return workLogSn;
	}
	public void setWorkLogSn(Integer workLogSn) {
		this.workLogSn = workLogSn;
	}
	public String getWorkLogRecordStatus() {
		return workLogRecordStatus;
	}
	public void setWorkLogRecordStatus(String workLogRecordStatus) {
		this.workLogRecordStatus = workLogRecordStatus;
	}
	public String getWorkLogRecordMemo() {
		return workLogRecordMemo;
	}
	public void setWorkLogRecordMemo(String workLogRecordMemo) {
		this.workLogRecordMemo = workLogRecordMemo;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
    
    
    
}
