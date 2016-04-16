package cn.com.nsv.ejb.interfaces;

import java.util.List;

import javax.ejb.Local;

import cn.com.nsv.ejb.dto.AutoCountSearchDto;
import cn.com.nsv.ejb.dto.ProjectCountDto;
import cn.com.nsv.ejb.dto.SearchResultDto;
import cn.com.nsv.ejb.dto.WorklogCountDto;
import cn.com.nsv.ejb.entity.MealSupplementReport;

@Local
public interface AutoCountService {
	
	public SearchResultDto getAutoCountList(AutoCountSearchDto searchDto);
	
	public SearchResultDto getAutoCountResultList(AutoCountSearchDto searchDto);
	
	public void generalAutoCountInDatabase(String yearMonth);
	
	public void generalExcelReport(List<MealSupplementReport> list);
	
	public void countWorklog(String year, String countType, String weekOrMonth, 
			List<WorklogCountDto> wcdlist, List<ProjectCountDto> pcdlist);
}
