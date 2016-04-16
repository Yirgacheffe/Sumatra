package cn.com.nsv.ejb.dto;

public class RoleDto {
	private Integer roleSn;
    private String roleName;
    private String roleType;
    private String roleTypeShow;
    private String recordMemo;
    private String roleStatus;
	public Integer getRoleSn() {
		return roleSn;
	}
	public void setRoleSn(Integer roleSn) {
		this.roleSn = roleSn;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public String getRecordMemo() {
		return recordMemo;
	}
	public void setRecordMemo(String recordMemo) {
		this.recordMemo = recordMemo;
	}
	public String getRoleStatus() {
		return roleStatus;
	}
	public void setRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}
	public String getRoleTypeShow() {
		return roleTypeShow;
	}
	public void setRoleTypeShow(String roleTypeShow) {
		this.roleTypeShow = roleTypeShow;
	}
	
}
