package cn.com.nsv.ejb.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cn.com.nsv.ejb.conn.DateType;
import cn.com.nsv.ejb.dto.SearchResultDto;
import cn.com.nsv.ejb.dto.YearWorkDateDto;
import cn.com.nsv.ejb.dto.YearWorkDateSearchDto;
import cn.com.nsv.ejb.entity.WorkCalender;
import cn.com.nsv.ejb.interfaces.YearWorkDateService;
import cn.com.nsv.ejb.util.DateUtils;

@Stateless
public class YearWorkDateServiceBean implements YearWorkDateService{
	
	@PersistenceContext(unitName = "innerInfoMgmt")
    EntityManager entityManager;

	@Override
	public SearchResultDto getYearWorkDateList(YearWorkDateSearchDto yearWorkDateSearchDto) {
		
		
		SearchResultDto dto = new SearchResultDto();
		List<YearWorkDateDto> resultList = new ArrayList<YearWorkDateDto>();
		String sql = " select work_calender_sn, work_year_month, work_date , date_type , work_hour , date_memo " +
				" from work_calender where work_year_month = ? ";
		Query query = entityManager.createNativeQuery(sql);
		
		query.setParameter(1,yearWorkDateSearchDto.getYearMonth());
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>)query.getResultList();
		if(list != null && list.size() > 0){
			for(int i = 0; i < list.size(); i++)
			{
				Object[] result = list.get(i);
				YearWorkDateDto yearWorkDateDto = new YearWorkDateDto();
				yearWorkDateDto.setWorkCalenderSn((Integer)result[0]);
				yearWorkDateDto.setYearMonth((String)result[1]);
				yearWorkDateDto.setDate((Date)result[2]);
				yearWorkDateDto.setDateType((Character)result[3] + "");
				if(yearWorkDateDto.getDateType().equals(DateType.WORKDAY)){
					yearWorkDateDto.setDateTypeShow("工作日");
				}else if(yearWorkDateDto.getDateType().equals(DateType.WEEKDAY)){
					yearWorkDateDto.setDateTypeShow("工休日");
				}else if(yearWorkDateDto.getDateType().equals(DateType.HOLIDAY)){
					yearWorkDateDto.setDateTypeShow("法定假日");
				}
				yearWorkDateDto.setWorkHour((Float)result[4]);
				yearWorkDateDto.setDateMemo((String)result[5]);
				resultList.add(yearWorkDateDto);
			}
		}
		dto.setResultList(resultList);
		return dto;
	}

	@Override
	public void deleteSpecialDate(Integer spacialSN) {
		
		WorkCalender workCalender = entityManager.find(WorkCalender.class, spacialSN);
		entityManager.remove(workCalender);
	}

	@Override
	public void addSpecialDate(YearWorkDateDto dto) {
		
		WorkCalender workCalender = new WorkCalender();
		workCalender.setWorkYearMonth(dto.getYearMonth());
		workCalender.setWorkDate(dto.getDate());
		workCalender.setDateType(dto.getDateType().charAt(0));
		workCalender.setWorkHour(dto.getWorkHour());
		workCalender.setDateMemo(dto.getDateMemo());
		workCalender.setWorkWeek(dto.getWorkWeek());
		entityManager.persist(workCalender);
	}

	@Override
	public void editSpecialDate(YearWorkDateDto dto) {
		WorkCalender workCalender = entityManager.find(WorkCalender.class, dto.getWorkCalenderSn());
		workCalender.setWorkYearMonth(dto.getYearMonth());
		workCalender.setWorkDate(dto.getDate());
		workCalender.setDateType(dto.getDateType().charAt(0));
		workCalender.setWorkHour(dto.getWorkHour());
		workCalender.setDateMemo(dto.getDateMemo());
		workCalender.setWorkWeek(dto.getWorkWeek());
		entityManager.merge(workCalender);
	}

	@Override
	public Map<String,YearWorkDateDto> getSpacialDate(String year, Integer week) {
		Map<String,YearWorkDateDto> yearWorkDateDtoMap = new HashMap<String,YearWorkDateDto>();
		String sql = " select work_calender_sn, work_year_month, work_date , date_type , work_hour , date_memo, version " +
				" from work_calender where work_year_month like ? and work_week = ? ";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1,year + "%");
		query.setParameter(2, week);
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>)query.getResultList();
		if(list.size() > 0){
			for(int i = 0; i < list.size(); i++){
				Object[] result = list.get(i);
				YearWorkDateDto yearWorkDateDto = new YearWorkDateDto();
				yearWorkDateDto.setWorkCalenderSn((Integer)result[0]);
				yearWorkDateDto.setYearMonth((String)result[1]);
				yearWorkDateDto.setDate((Date)result[2]);
				yearWorkDateDto.setDateType(((Character)result[3]) + "");
				yearWorkDateDto.setWorkHour((Float)result[4]);
				yearWorkDateDto.setDateMemo((String)result[5]);
				yearWorkDateDto.setDateVersion((Integer)result[6]);
				yearWorkDateDtoMap.put(DateUtils.formatDate(yearWorkDateDto.getDate()),yearWorkDateDto);
			}
		}
		return yearWorkDateDtoMap;
	}

}
