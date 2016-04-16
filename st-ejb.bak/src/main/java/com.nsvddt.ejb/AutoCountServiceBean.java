package cn.com.nsv.ejb.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cn.com.nsv.ejb.conn.Config;
import cn.com.nsv.ejb.conn.DateType;
import cn.com.nsv.ejb.dto.AutoCountDto;
import cn.com.nsv.ejb.dto.AutoCountSearchDto;
import cn.com.nsv.ejb.dto.ProjectCountDto;
import cn.com.nsv.ejb.dto.SearchResultDto;
import cn.com.nsv.ejb.dto.WorklogCountDto;
import cn.com.nsv.ejb.dto.YearWorkDateDto;
import cn.com.nsv.ejb.dto.YearWorkDateSearchDto;
import cn.com.nsv.ejb.entity.MealSupplementReport;
import cn.com.nsv.ejb.interfaces.AutoCountService;
import cn.com.nsv.ejb.interfaces.YearWorkDateService;
import cn.com.nsv.ejb.util.DateUtils;
import cn.com.nsv.ejb.util.EmTools;
import cn.com.nsv.ejb.util.StringTools;

@Stateless
public class AutoCountServiceBean implements AutoCountService{
	
	@PersistenceContext(unitName = "innerInfoMgmt")
    EntityManager entityManager;
	
	 @EJB(beanName = "YearWorkDateServiceBean")
	 YearWorkDateService yearWorkDateService;
	
	EmTools emTools = EmTools.getInstance();
	
	@Override
	public SearchResultDto getAutoCountList(AutoCountSearchDto searchDto) {
		
		SearchResultDto resultDto = new SearchResultDto();

		List<AutoCountDto> autoCountDtoList = new ArrayList<AutoCountDto>();
		StringBuilder headsb = new StringBuilder();
		Integer totalDate = getTotalNormalWorkDay(searchDto.getYearMonth());
		if(totalDate != null)
		{
		headsb.append(" select wl.employee_id,sum(if(myLaod.wlwd_type = 'W' and wld.daily_hours = 0,1,0)) overTimeWeekDay,");
		headsb.append(" sum(if(myLaod.wlwd_type = 'W' and myLaod.sumLaodHours >= ? and wld.daily_hours = 0,1,0)) overTimeFoodWeekDay, ");
		headsb.append(" sum(if(myLaod.wlwd_type = 'W' and myLaod.sumLaodHours >= ? and wld.daily_hours > 0,1,0)) overtimeFoodWorkDay, "); 
		headsb.append(" sum(if(myLaod.wlwd_type = 'W' and wld.daily_hours > 0,1,0)) overtimeWorkDay, "); 
		headsb.append(" sum(if(myLaod.wlwd_type = 'N' and myLaod.sumLaodHours >= ?,1,0)) normalFoodWorkDay,");
		headsb.append(" sum(if(myLaod.wlwd_type = 'N' and myLaod.sumLaodHours > 0,1,0)) normalWorkDay,su.employee_name "); 
		StringBuilder mainsb = new StringBuilder();
		mainsb.append(" from work_log wl left join  work_log_detail wld on wl.work_log_sn = wld.work_log_sn ");
		mainsb.append(" left join (select wlwd.work_log_detail_serial_num, wlwd.wlwd_type,sum(wlwd.part_hour) sumLaodHours ");
		mainsb.append(" from work_log_works_detail wlwd group by wlwd.work_log_detail_serial_num, wlwd.wlwd_type) myLaod on myLaod.work_log_detail_serial_num = wld.work_log_detail_serial_num ");
		mainsb.append(" left join sys_user su on su.sys_user_id = wl.employee_id ");
		mainsb.append(" where wld.work_date >= ? and wld.work_date < ? and wl.work_log_status = 'P' ");
	    List<Object> resultParam = new ArrayList<Object>();
		List<Object> countParam = new ArrayList<Object>();		
		resultParam.add(Config.INNERINFO_WEEKDAYOVERFOODHOUR);
		resultParam.add(Config.INNERINFO_WORKDAYOVERFOODHOUR);
		resultParam.add(Config.INNERINFO_WORKDAYNOMALFOODHOUR);
		Date date = DateUtils.parseDate(searchDto.getYearMonth(), "yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		countParam.add(calendar.getTime());
		calendar.add(Calendar.MONTH, 1);
		countParam.add(calendar.getTime());
		if(StringTools.isNotNull(searchDto.getEmployeeId())){
			mainsb.append(" and wl.employee_id = ? ");
			countParam.add(searchDto.getEmployeeId());
		}
		mainsb.append(" group by wl.employee_id ");
		resultParam.addAll(countParam);
		Query countQuery = entityManager.createNativeQuery("select count(work_tmp.id_count) from  (select count(wl.employee_id) id_count" + mainsb.toString()+") work_tmp ");
		countQuery = emTools.querySQLByCriteria(countQuery, countParam);
		try{
			resultDto.setTotalCount(Integer.parseInt(countQuery.getSingleResult().toString()));
		}catch(Exception e){
			resultDto.setTotalCount(0);
		}
		Query resultlist = entityManager.createNativeQuery(headsb.toString() + mainsb.toString());
		resultlist = emTools.querySQLByCriteria(resultlist, resultParam, searchDto.getPageSize(),
				 searchDto.getStart());
		@SuppressWarnings("unchecked")
		List<Object[]> queryList = resultlist.getResultList();
		if (queryList.size() != 0) {
			 for (int i = 0; i < queryList.size(); i++) {
				 Object[] result = queryList.get(i);
				 AutoCountDto autoCountDto = new AutoCountDto();
				 autoCountDto.setEmployeeId((String)result[0]);
				 autoCountDto.setOverWeekDay(((BigDecimal)result[1]).intValue());
				 autoCountDto.setOverWeekDayMealSupplement(Config.INNERINFO_OVERWEEKDAY_MEALSUPPLEMENT * ((BigDecimal)result[2]).intValue());
				 autoCountDto.setOverWorkDay(((BigDecimal)result[4]).intValue());
				 autoCountDto.setOverWorkDayMealSupplement(Config.INNERINFO_OVERWORKDAY_MEALSUPPLEMENT * ((BigDecimal)result[3]).intValue());
				 autoCountDto.setMonthNormalWorkDay(totalDate);
				 autoCountDto.setYearMonth(searchDto.getYearMonth());
				 autoCountDto.setMonthEmTotalWorkDay(((BigDecimal)result[6]).intValue());
				 autoCountDto.setNormalWorkDayMealSupplement(((BigDecimal)result[5]).intValue() * Config.INNERINFO_NOMALWORKDAY_MEALSUPPLEMENT);
				 autoCountDto.setEmployeeName((String)result[7]);
				 autoCountDtoList.add(autoCountDto);
			 }
		 }
		resultDto.setResultList(autoCountDtoList);
		}
		return resultDto;
	}
	
	private Integer getTotalNormalWorkDay(String yearMonth){	
		Integer totalDate = 0;
		YearWorkDateSearchDto searchDto = new YearWorkDateSearchDto();
		searchDto.setYearMonth(yearMonth);
		@SuppressWarnings("unchecked")
		List<YearWorkDateDto> spacialDateList = (List<YearWorkDateDto>)yearWorkDateService.getYearWorkDateList(searchDto).getResultList();
		Map<Date,YearWorkDateDto> spacialDateMap = new HashMap<Date,YearWorkDateDto>();
		for(int i = 0; i < spacialDateList.size(); i++){
			spacialDateMap.put(spacialDateList.get(i).getDate(), spacialDateList.get(i));
		}
		Date date = DateUtils.parseDate(searchDto.getYearMonth(), "yyyy-M");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		Date firstDate = calendar.getTime();
		calendar.add(Calendar.MONTH, 1);
		Date endDate = calendar.getTime();
		while(!firstDate.equals(endDate)){
			calendar.setTime(firstDate);
			YearWorkDateDto specailDto = spacialDateMap.get(firstDate);
			if(specailDto != null){
				if(specailDto.getDateType().equals(DateType.WORKDAY)){
					totalDate++;
				}
			}else{
				Integer weekDay = calendar.get(Calendar.DAY_OF_WEEK);
				if(weekDay != 7 && weekDay != 1){
					totalDate++;
				}
			}
			calendar.add(Calendar.DATE, 1);
			firstDate = calendar.getTime();
			if(totalDate >= 31){
				return null;
			}
		}
		return totalDate;
	}

	@Override
	public SearchResultDto getAutoCountResultList(AutoCountSearchDto searchDto) {
		SearchResultDto resultDto = new SearchResultDto();
		List<AutoCountDto> autoCountDtoList = new ArrayList<AutoCountDto>();
		List<Object> param = new ArrayList<Object>();
		
		String headSql = " select msr.employee_id, su.employee_name, msr.year_and_month, msr.normal_workday_count, msr.employee_month_workday_count," +
				" msr.normal_workday_meal_supplement, msr.overtime_workday_count, msr.overtime_workday_meal_supplement, msr.overtime_weekday_count, msr.overtime_weekday_meal_supplement ";
		String mainSql = " from meal_supplement_report msr left join sys_user su on su.sys_user_id = msr.employee_id where msr.year_and_month = ? ";
		param.add(searchDto.getYearMonth());
		if(StringTools.isNotNull(searchDto.getEmployeeId())){
			mainSql += " and msr.employee_id = ? ";
			param.add(searchDto.getEmployeeId());
		}
		Query countQuery = entityManager.createNativeQuery(" select count(*) " + mainSql);
		countQuery = emTools.querySQLByCriteria(countQuery, param);
		try{
			resultDto.setTotalCount(Integer.parseInt(countQuery.getSingleResult().toString()));
		}catch(Exception e){
			resultDto.setTotalCount(0);
		}
		Query resultQuery = entityManager.createNativeQuery(headSql + mainSql);
		resultQuery = emTools.querySQLByCriteria(resultQuery, param, searchDto.getPageSize(),searchDto.getStart());
		@SuppressWarnings("unchecked")
		List<Object[]> resultList = resultQuery.getResultList();
		if (resultList.size() != 0) {
			for(int i = 0; i < resultList.size(); i++)
			{
				Object[] result = resultList.get(i);
				AutoCountDto autoCountDto = new AutoCountDto();
				autoCountDto.setEmployeeId((String)result[0]);
				autoCountDto.setEmployeeName((String)result[1]);
				autoCountDto.setYearMonth((String)result[2]);r
				autoCountDto.setMonthNormalWorkDay((Integer)result[3]);
				autoCountDto.setMonthEmTotalWorkDay((Integer)result[4]);
				autoCountDto.setNormalWorkDayMealSupplement((Float)result[5]);
				autoCountDto.setOverWorkDay((Integer)result[6]);
				autoCountDto.setOverWorkDayMealSupplement((Float)result[7]);
				autoCountDto.setOverWeekDay((Integer)result[8]);
				autoCountDto.setOverWeekDayMealSupplement((Float)result[9]);
				autoCountDtoList.add(autoCountDto);
			}
		}
		resultDto.setResultList(autoCountDtoList);
		return resultDto;
	}

	@Override
	public void generalAutoCountInDatabase(String yearMonth) {
		String deleteSql = " delete from meal_supplement_report where year_and_month = ? ";
		Query delQuery = entityManager.createNativeQuery(deleteSql);
		delQuery.setParameter(1, yearMonth);
		delQuery.executeUpdate();
		StringBuilder sb = new StringBuilder();
		Integer totalDate = getTotalNormalWorkDay(yearMonth);
		sb.append(" select wl.employee_id, sum(if(myLaod.llaod_flag = 'W' and wld.daily_hours = 0,1,0)) overTimeWeekDay, ");
		sb.append(" sum(if(myLaod.llaod_flag = 'W' and myLaod.sumLaodHours >= ? and wld.daily_hours = 0,1,0)) overTimeFoodWeekDay, ");
		sb.append(" sum(if(myLaod.llaod_flag = 'W' and myLaod.sumLaodHours >= ? and wld.daily_hours > 0,1,0)) overtimeFoodWorkDay, "); 
		sb.append(" sum(if(myLaod.llaod_flag = 'W' and wld.daily_hours > 0,1,0)) overtimeWorkDay, "); 
		sb.append(" sum(if(myLaod.llaod_flag = 'H',if(wld.daily_hours - myLaod.sumLaodHours >= ?,1,0), 0) + if(myLaod.llaod_flag is null,1,0)) normalFoodWorkDay,");
		sb.append(" sum(if(myLaod.llaod_flag = 'H',if(wld.daily_hours - myLaod.sumLaodHours > 0,1,0), 0) + if(myLaod.llaod_flag is null,1,0)) normalWorkDay "); 
		sb.append(" from work_log wl left join  work_log_detail wld on wl.work_log_sn = wld.work_log_sn ");
		sb.append(" left join (select laod.work_log_detail_serial_num, laod.llaod_flag, sum(laod.laod_hours) sumLaodHours from leave_and_overtime_detail laod ");
		sb.append(" group by laod.work_log_detail_serial_num, laod.llaod_flag) myLaod on myLaod.work_log_detail_serial_num = wld.work_log_detail_serial_num ");
		sb.append(" where wld.work_date >= ? and wld.work_date < ? and wl.work_log_status = 'P' ");
		sb.append(" group by wl.employee_id ");
		List<Object> resultParam = new ArrayList<Object>();
		resultParam.add(Config.INNERINFO_WEEKDAYOVERFOODHOUR);
		resultParam.add(Config.INNERINFO_WORKDAYNOMALFOODHOUR);
		resultParam.add(Config.INNERINFO_WORKDAYOVERFOODHOUR);
		Date date = DateUtils.parseDate(yearMonth, "yyyy-MM");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		resultParam.add(calendar.getTime());
		calendar.add(Calendar.MONTH, 1);
		resultParam.add(calendar.getTime());
		Query resultQuery = entityManager.createNativeQuery(sb.toString());
		resultQuery = emTools.querySQLByCriteria(resultQuery, resultParam);
		@SuppressWarnings("unchecked")
		List<Object[]> resultList = resultQuery.getResultList();
		if (resultList.size() != 0) {
			 for (int i = 0; i < resultList.size(); i++) {
				 Object[] result = resultList.get(i);
				 MealSupplementReport mealSupplementReport = new MealSupplementReport();
				 mealSupplementReport.setEmployeeId((String)result[0]);
				 mealSupplementReport.setOvertimeWeekdayCount(((BigDecimal)result[1]).intValue());
				 mealSupplementReport.setOvertimeWeekdayMealSupplement(Config.INNERINFO_OVERWEEKDAY_MEALSUPPLEMENT * ((BigDecimal)result[2]).intValue());
				 mealSupplementReport.setOvertimeWorkdayCount(((BigDecimal)result[4]).intValue());
				 mealSupplementReport.setOvertimeWorkdayMealSupplement(Config.INNERINFO_OVERWORKDAY_MEALSUPPLEMENT * ((BigDecimal)result[3]).intValue());
				 mealSupplementReport.setNormalWorkdayCount(totalDate);
				 mealSupplementReport.setYearAndMonth(yearMonth);
				 mealSupplementReport.setEmployeeMonthWorkdayCount(((BigDecimal)result[6]).intValue());
				 mealSupplementReport.setNormalWorkdayMealSupplement(((BigDecimal)result[5]).intValue() * Config.INNERINFO_NOMALWORKDAY_MEALSUPPLEMENT);
				 entityManager.persist(mealSupplementReport);
			 }
		}
		
	}

	@Override
	public void generalExcelReport(List<MealSupplementReport> list) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public void countWorklog(String year, String countType, String weekOrMonth,
			List<WorklogCountDto> wcdlist, List<ProjectCountDto> pcdlist) {
		try {
			Date startDate = null;
			Date endDate = null;
			// 按月查询时，计算月份的开始和结束日期
			if ("month".equals(countType)) {
				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.YEAR, Integer.parseInt(year));
				calendar.set(Calendar.MONTH, Integer.parseInt(weekOrMonth) - 1);
				calendar.set(Calendar.DAY_OF_MONTH, 1);
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				startDate = calendar.getTime();
				calendar.add(Calendar.MONTH, 1);
				calendar.add(Calendar.DAY_OF_MONTH, -1);
				calendar.set(Calendar.HOUR_OF_DAY, 23);
				calendar.set(Calendar.MINUTE, 59);
				calendar.set(Calendar.SECOND, 59);
				endDate = calendar.getTime();
			}
			// 按月查询时，计算月份的开始和结束日期
			if ("year".equals(countType)) {
				Calendar calendar = Calendar.getInstance();
				calendar.set(Calendar.YEAR, Integer.parseInt(year));
				calendar.set(Calendar.MONTH, 0);
				calendar.set(Calendar.DAY_OF_MONTH, 1);
				calendar.set(Calendar.HOUR_OF_DAY, 0);
				calendar.set(Calendar.MINUTE, 0);
				calendar.set(Calendar.SECOND, 0);
				startDate = calendar.getTime();
				calendar.set(Calendar.MONTH, 11);
				calendar.set(Calendar.DAY_OF_MONTH, 31);
				calendar.set(Calendar.HOUR_OF_DAY, 23);
				calendar.set(Calendar.MINUTE, 59);
				calendar.set(Calendar.SECOND, 59);
				endDate = calendar.getTime();
			}
						
			//整理查询总工时的sql
			List<Object> worklogCountQueryParam = new ArrayList<Object>();
			StringBuffer worklogCountSql= new StringBuffer();
			worklogCountSql.append("	SELECT eu.employee_info_sn, eu.employee_name, eu.sys_user_id, wll.employee_id,");
			worklogCountSql.append("	       SUM(sum_daily_hours), SUM(actualWorktime)");
			worklogCountSql.append("	  FROM (");
			worklogCountSql.append("		SELECT e.employee_info_sn,su.employee_name,su.sys_user_id");
			worklogCountSql.append("		  FROM employee_info e, sys_user su");
			worklogCountSql.append("		 WHERE e.sys_user_sn=su.sys_user_sn");
	        if("month".equals(countType) || "year".equals(countType)){
		          worklogCountSql.append("		 AND e.entry_time<?");	
		          worklogCountQueryParam.add(endDate);
			}
			worklogCountSql.append("		   ) eu");
			worklogCountSql.append("	LEFT JOIN (");
			worklogCountSql.append("		SELECT wll2.employee_id, wll2.sum_daily_hours,");
			worklogCountSql.append("			SUM(IF(wlwd.wlwd_type = 'N' || wlwd.wlwd_type = 'W', wlwd.part_hour,0)) actualWorktime,");
			worklogCountSql.append("			 SUM(IF(wlwd.wlwd_type = 'N', wlwd.part_hour,0)) normalTotalHour,");
			worklogCountSql.append("			 SUM(IF(wlwd.wlwd_type = 'H', wlwd.part_hour,0)) leavetotalhour,");
			worklogCountSql.append("			 SUM(IF(wlwd.wlwd_type = 'W', wlwd.part_hour,0)) overtimetotalhour");
			worklogCountSql.append("		    FROM (");
			worklogCountSql.append("			SELECT wl2.*, SUM(wld2.daily_hours) sum_daily_hours");
			worklogCountSql.append("			  FROM work_log wl2");
			worklogCountSql.append("			 LEFT JOIN work_log_detail wld2 ON wld2.work_log_sn=wl2.work_log_sn");
			if ("week".equals(countType)) {
				worklogCountSql.append("		 WHERE wl2.work_log_year=? AND wl2.work_log_week=? AND wl2.work_log_status='P'");
				worklogCountQueryParam.add(year);
				worklogCountQueryParam.add(weekOrMonth);
			} else if ("month".equals(countType) || "year".equals(countType)) {
				worklogCountSql.append("		 WHERE wld2.work_date>=? AND wld2.work_date<=? AND wl2.work_log_status='P'");
				worklogCountQueryParam.add(startDate);
				worklogCountQueryParam.add(endDate);
			}
			worklogCountSql.append("			GROUP BY wl2.work_log_sn");
			worklogCountSql.append("			) wll2");
			worklogCountSql.append("		 LEFT JOIN work_log_detail wld ON wld.work_log_sn=wll2.work_log_sn");
			worklogCountSql.append("		 LEFT JOIN work_log_works_detail wlwd ON wlwd.work_log_detail_serial_num=wld.work_log_detail_serial_num");
			if ("week".equals(countType)) {
				worklogCountSql.append("		 WHERE wll2.work_log_year=? AND wll2.work_log_week=? AND wll2.work_log_status='P'");
				worklogCountQueryParam.add(year);
				worklogCountQueryParam.add(weekOrMonth);
			} else if ("month".equals(countType) || "year".equals(countType)) {
				worklogCountSql.append("		 WHERE wld.work_date>=? AND wld.work_date<=? AND wll2.work_log_status='P'");
				worklogCountQueryParam.add(startDate);
				worklogCountQueryParam.add(endDate);
			}
			worklogCountSql.append("		  GROUP BY wll2.employee_id, wll2.work_log_sn");
			worklogCountSql.append("		) wll");
			worklogCountSql.append("	    ON wll.employee_id=eu.sys_user_id");
			worklogCountSql.append("	GROUP BY eu.employee_info_sn");
			worklogCountSql.append("	ORDER BY eu.employee_info_sn ASC");

			// 开始查询出来，并将结果转换为DTO
			Query worklogCountQuery = entityManager.createNativeQuery(worklogCountSql.toString());
			worklogCountQuery= emTools.querySQLByCriteria(worklogCountQuery, worklogCountQueryParam);
			
			List<Object[]> worklogCountResult = worklogCountQuery.getResultList();
			if (worklogCountResult != null) {
				WorklogCountDto worklogCountDto = null;
				for (Iterator<Object[]> iter = worklogCountResult.iterator(); iter
						.hasNext();) {
					Object[] objects = iter.next();
					if (objects[3] != null) {
						worklogCountDto = new WorklogCountDto();
						worklogCountDto.setEmployeeId(objects[3].toString());
						worklogCountDto.setEmployeeName(objects[1].toString());
						worklogCountDto.setNormalWorktime(objects[4] == null ? 0 : Float.valueOf(objects[4].toString()));
						worklogCountDto.setActualWorktime(objects[5] == null ? 0 : Float.valueOf(objects[5].toString()));
						wcdlist.add(worklogCountDto);
					}
				}
			}
					
			//整理查询项目工时的sql
			List<Object> projectCountQueryParam = new ArrayList<Object>();
			StringBuffer projectCountSql = new StringBuffer();
			projectCountSql.append("  SELECT wll2.employee_id, wlwd.project_id, p.project_name, ");
			projectCountSql.append("	 SUM(IF(wlwd.wlwd_type = 'N', wlwd.part_hour,0)) normalTotalHour,");
			projectCountSql.append("	 SUM(IF(wlwd.wlwd_type = 'W', wlwd.part_hour,0)) overtimetotalhour,");
			projectCountSql.append("	 SUM(IF(wlwd.wlwd_type = 'N' || wlwd.wlwd_type = 'W', wlwd.part_hour,0)) totalActualWorktime");
			projectCountSql.append("    FROM (");
			projectCountSql.append("	SELECT wl2.*");
			projectCountSql.append("	  FROM work_log wl2");
			projectCountSql.append("	 LEFT JOIN work_log_detail wld2 ON wld2.work_log_sn=wl2.work_log_sn");
			if ("week".equals(countType)) {
				projectCountSql.append("	 WHERE wl2.work_log_year=? AND wl2.work_log_week=? AND wl2.work_log_status='P'");
				projectCountQueryParam.add(year);
				projectCountQueryParam.add(weekOrMonth);
			} else if ("month".equals(countType) || "year".equals(countType)) {
				projectCountSql.append("	 WHERE wld2.work_date>=? AND wld2.work_date<=? AND wl2.work_log_status='P'");
				projectCountQueryParam.add(startDate);
				projectCountQueryParam.add(endDate);
			}
			projectCountSql.append("	GROUP BY wld2.work_log_sn");
			projectCountSql.append("	) wll2");
			projectCountSql.append(" LEFT JOIN work_log_detail wld ON wld.work_log_sn=wll2.work_log_sn");
			projectCountSql.append(" LEFT JOIN work_log_works_detail wlwd ON wlwd.work_log_detail_serial_num=wld.work_log_detail_serial_num");
			projectCountSql.append(" LEFT JOIN project p ON p.project_id=wlwd.project_id");
			projectCountSql.append("     WHERE (wlwd.wlwd_type = BINARY 'W' OR wlwd.wlwd_type= BINARY 'N')");
			if ("week".equals(countType)) {
				projectCountSql.append("	 AND wll2.work_log_year=? AND wll2.work_log_week=? AND wll2.work_log_status='P'");
				projectCountQueryParam.add(year);
				projectCountQueryParam.add(weekOrMonth);
			} else if ("month".equals(countType) || "year".equals(countType)) {
				projectCountSql.append("	 AND wld.work_date>=? AND wld.work_date<=? AND wll2.work_log_status='P'");
				projectCountQueryParam.add(startDate);
				projectCountQueryParam.add(endDate);
			}
			projectCountSql.append("  GROUP BY wll2.employee_id,wlwd.project_id");

			// 开始查询出来，并将结果转换为DTO
			Query projectCountQuery = entityManager.createNativeQuery(projectCountSql.toString());
			System.out.println(projectCountSql.toString());
			projectCountQuery= emTools.querySQLByCriteria(projectCountQuery, projectCountQueryParam);
			
			List<Object[]> projectCountResult = projectCountQuery.getResultList();
			if (projectCountResult != null) {
				ProjectCountDto projectCountDto = null;
				for (Iterator<Object[]> iter = projectCountResult.iterator(); iter
						.hasNext();) {
					Object[] objects = iter.next();
					if (objects[1] != null && !"".equals(objects[1].toString())) {
						projectCountDto = getProjectCountDto(objects[1].toString(), pcdlist);
						if (projectCountDto == null) {
							projectCountDto = new ProjectCountDto();
							pcdlist.add(projectCountDto);
						}
						projectCountDto.setProjectId(objects[1].toString());
						projectCountDto.setProjectName(objects[2].toString());
						
						WorklogCountDto worklogCountDto = new WorklogCountDto();
						worklogCountDto.setEmployeeId(objects[0].toString());
						worklogCountDto.setActualWorktime(objects[5] == null ? 0 : Float.valueOf(objects[5].toString()));
						projectCountDto.setWorklogCountDto(objects[0].toString(), worklogCountDto);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private ProjectCountDto getProjectCountDto(String projectId, List<ProjectCountDto> pcdlist) {
		for (Iterator<ProjectCountDto> iter = pcdlist.iterator(); iter.hasNext();) {
			ProjectCountDto projectCountDto = iter.next();
			if (projectId.equals(projectCountDto.getProjectId())) {
				return projectCountDto;
			}
		}
		return null;
	}

}
