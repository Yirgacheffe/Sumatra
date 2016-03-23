package cn.com.nsv.ejb.dto;

import java.util.ArrayList;
import java.util.List;

public class AuthorityDto {
	
	private Integer roleSN;
	
	private String roleName;
	
	private String roleType;
	
	private String functionNameStrings;
	
	private List<FunctionDto> functionDtoList = new ArrayList<FunctionDto>();

	public Integer getRoleSN() {
		return roleSN;
	}

	public void setRoleSN(Integer roleSN) {
		this.roleSN = roleSN;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getFunctionNameStrings() {
		return functionNameStrings;
	}

	public void setFunctionNameStrings(String functionNameStrings) {
		this.functionNameStrings = functionNameStrings;
	}

	public List<FunctionDto> getFunctionDtoList() {
		return functionDtoList;
	}

	public void setFunctionDtoList(List<FunctionDto> functionDtoList) {
		this.functionDtoList = functionDtoList;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
	
}
