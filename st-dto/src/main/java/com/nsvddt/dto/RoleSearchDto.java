package cn.com.nsv.ejb.dto;

public class RoleSearchDto extends SearchCommonDto{
	
	private static final long serialVersionUID = 1L;
	private String roleName;
	private String roleStatus;
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleStatus() {
		return roleStatus;
	}
	public void setRoleStatus(String roleStatus) {
		this.roleStatus = roleStatus;
	}


}
