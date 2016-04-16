package cn.com.nsv.ejb.dto;

import java.util.ArrayList;
import java.util.List;

public class FunctionDto {
	
	private Integer funSN;
	
	private String funId;
	
	private String funName;
	
	private String parentId;
	
	private String funUrl;
	
	private String promission;
	
	private List<FunctionDto> subFunctionList = new ArrayList<FunctionDto>();

	public String getFunId() {
		return funId;
	}

	public void setFunId(String funId) {
		this.funId = funId;
	}

	public String getFunName() {
		return funName;
	}

	public void setFunName(String funName) {
		this.funName = funName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getFunUrl() {
		return funUrl;
	}

	public void setFunUrl(String funUrl) {
		this.funUrl = funUrl;
	}

	public String getPromission() {
		return promission;
	}

	public void setPromission(String promission) {
		this.promission = promission;
	}

	public Integer getFunSN() {
		return funSN;
	}

	public void setFunSN(Integer funSN) {
		this.funSN = funSN;
	}

	public List<FunctionDto> getSubFunctionList() {
		return subFunctionList;
	}

	public void setSubFunctionList(List<FunctionDto> subFunctionList) {
		this.subFunctionList = subFunctionList;
	}
	
	

}
