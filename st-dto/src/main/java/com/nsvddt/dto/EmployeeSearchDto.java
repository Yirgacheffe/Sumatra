package cn.com.nsv.ejb.dto;



public class EmployeeSearchDto extends SearchCommonDto{
	
	private static final long serialVersionUID = 1L;
	private String sysUserEmail;
	private String sysUserId;
	private String employeeName;
	private String employeeGender;
	private String sysUserStatus;
	private String roleName;
	private String roleSn;
	public String getSysUserEmail() {
		return sysUserEmail;
	}
	public void setSysUserEmail(String sysUserEmail) {
		this.sysUserEmail = sysUserEmail;
	}
	public String getSysUserId() {
		return sysUserId;
	}
	public void setSysUserId(String sysUserId) {
		this.sysUserId = sysUserId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeGender() {
		return employeeGender;
	}
	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}
	public String getSysUserStatus() {
		return sysUserStatus;
	}
	public void setSysUserStatus(String sysUserStatus) {
		this.sysUserStatus = sysUserStatus;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleSn() {
		return roleSn;
	}
	public void setRoleSn(String roleSn) {
		this.roleSn = roleSn;
	}
		
}

