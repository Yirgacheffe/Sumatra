package cn.com.nsv.ejb.dto;


public class CurUserDto {
	
	private Integer userSN;
	
	private String userId;

	private String userEmail;
	
	private String userName;
	
	private String userPassword;
	
	private Character roleType;
	
	private String managerId;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getUserSN() {
		return userSN;
	}

	public void setUserSN(Integer userSN) {
		this.userSN = userSN;
	}

	public Character getRoleType() {
		return roleType;
	}

	public void setRoleType(Character roleType) {
		this.roleType = roleType;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	
	
	
	

}
