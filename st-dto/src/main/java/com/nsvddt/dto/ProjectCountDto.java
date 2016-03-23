package cn.com.nsv.ejb.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ProjectCountDto {

    private String projectId;
	
	private String projectName;

	private Map<String, WorklogCountDto> worklogCountMap = new HashMap<String, WorklogCountDto>();
	
	private Float totalActualWorktime = 0f;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<String> getEmployeeIds() {
		List<String> list = new ArrayList<String>();
		Iterator<Map.Entry<String, WorklogCountDto>> iter = worklogCountMap.entrySet().iterator(); 
		while (iter.hasNext()) {
			Map.Entry<String, WorklogCountDto> entry = iter.next(); 
			list.add(entry.getKey());
		}
		return list;
	}

	public WorklogCountDto getWorklogCountDto(String employeeId) {
		return worklogCountMap.get(employeeId);
	}
	
	public void setWorklogCountDto(String employeeId, WorklogCountDto dto) {
		worklogCountMap.put(employeeId, dto);
		totalActualWorktime += dto.getActualWorktime();
	}

	public Float getTotalActualWorktime() {
		return totalActualWorktime;
	}

	public void setTotalActualWorktime(Float totalActualWorktime) {
		this.totalActualWorktime = totalActualWorktime;
	}
	
	public void addTotalActualWorktime(Float actualWorktime) {
		
	}

}
