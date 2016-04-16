package cn.com.nsv.ejb.interfaces;

import java.util.Map;

import javax.ejb.Local;

import cn.com.nsv.ejb.dto.SearchResultDto;
import cn.com.nsv.ejb.dto.YearWorkDateDto;
import cn.com.nsv.ejb.dto.YearWorkDateSearchDto;

@Local
public interface YearWorkDateService {
	
	public SearchResultDto getYearWorkDateList(YearWorkDateSearchDto dto);
	
	public void deleteSpecialDate(Integer spacialSN);
	
	public void addSpecialDate(YearWorkDateDto dto);
	
	public void editSpecialDate(YearWorkDateDto dto);
	
	public Map<String,YearWorkDateDto> getSpacialDate(String year, Integer week);

}
