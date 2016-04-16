package cn.com.nsv.ejb.interfaces;

import java.util.List;

import javax.ejb.Local;

import cn.com.nsv.ejb.dto.SearchResultDto;
import cn.com.nsv.ejb.dto.WorklogDto;
import cn.com.nsv.ejb.dto.WorklogRecordDto;
import cn.com.nsv.ejb.dto.WorklogSearchDto;
import cn.com.nsv.ejb.dto.WorklogWorksDetailDto;

@Local
public interface WorklogService {

	//public void addWorklog(WorklogDto worklogDto);
	
	public void updateWorklog(WorklogDto worklogDto);
	
	public void updateWorklogDetail(WorklogWorksDetailDto worklogWorksDetailDto);
	
	public void deleteWorklogDetail(WorklogWorksDetailDto worklogWorksDetailDto);
	
	public SearchResultDto getWorklogList(WorklogSearchDto searchDto);
	
	public WorklogDto getWorklogDetail(String year, Integer week, String employeeId);
	
	public WorklogDto getWorklogDetail(Integer worklogSN);
	
	public List<Integer> getWorklogSNListByProjectIds(List<String> projectIds);
	
	public void approvalWorklog(WorklogRecordDto worklogRecordDto);
	
	public List<String> getNoSubmitWorklogEmailList(Integer year, Integer week);
	
	public String getShowWeekNo(String userId);
}
