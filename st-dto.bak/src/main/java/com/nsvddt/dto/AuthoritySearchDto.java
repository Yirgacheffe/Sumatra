package cn.com.nsv.ejb.dto;

public class AuthoritySearchDto extends SearchCommonDto{

	private static final long serialVersionUID = 1L;
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
