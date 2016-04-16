package cn.com.nsv.ejb.bean;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cn.com.nsv.ejb.conn.Config;
import cn.com.nsv.ejb.conn.LevelOrOvertime;
import cn.com.nsv.ejb.conn.WorkLogRecordStatus;
import cn.com.nsv.ejb.conn.WorklogStatus;
import cn.com.nsv.ejb.dto.SearchResultDto;
import cn.com.nsv.ejb.dto.WorklogDetailDto;
import cn.com.nsv.ejb.dto.WorklogDto;
import cn.com.nsv.ejb.dto.WorklogRecordDto;
import cn.com.nsv.ejb.dto.WorklogSearchDto;
import cn.com.nsv.ejb.dto.WorklogWorksDetailDto;
import cn.com.nsv.ejb.entity.WorkLog;
import cn.com.nsv.ejb.entity.WorkLogDetail;
import cn.com.nsv.ejb.entity.WorkLogRecord;
import cn.com.nsv.ejb.entity.WorkLogWorksDetail;
import cn.com.nsv.ejb.interfaces.EmployeeService;
import cn.com.nsv.ejb.interfaces.ProjectService;
import cn.com.nsv.ejb.interfaces.WorklogService;
import cn.com.nsv.ejb.util.DateUtils;
import cn.com.nsv.ejb.util.EmTools;
import cn.com.nsv.ejb.util.EmailUtils;
import cn.com.nsv.ejb.util.ShowRevert;
import cn.com.nsv.ejb.util.StringTools;

@Stateless
public class WorklogServiceBean implements WorklogService {

	@PersistenceContext(unitName = "innerInfoMgmt")
	EntityManager entityManager;

	EmTools emTools = EmTools.getInstance();

	@EJB(beanName = "ProjectServiceBean")
	ProjectService projectService;
	
	@EJB(beanName = "EmployeeServiceBean")
	EmployeeService employeeService;


	@Override
	public void updateWorklog(WorklogDto worklogDto) {
		try {
			
			boolean isEdit = false;
			Set<String> projectSet = new HashSet<String>();
			String sql = " select wld.work_log_detail_serial_num from work_log_detail wld where wld.work_log_sn = ? ";
			Query deleteQuery = entityManager.createNativeQuery(sql);
			deleteQuery.setParameter(1, worklogDto.getWorkLogSN());
			@SuppressWarnings("unchecked")
			List<Integer> deleteQueryList = deleteQuery.getResultList();
			if (deleteQueryList.size() > 0) {
				String deletesql1 = " delete from work_log_works_detail where work_log_detail_serial_num in ("
						+ StringTools.listToString(deleteQueryList) + ")";
				Query delete1Query = entityManager
						.createNativeQuery(deletesql1);
				delete1Query.executeUpdate();
				// String deletesql2 =
				// " delete from leave_and_overtime_detail where work_log_detail_serial_num in ("
				// + StringTools.listToString(deleteQueryList) + ")";
				// Query delete2Query = entityManager
				// .createNativeQuery(deletesql2);
				// delete2Query.executeUpdate();
				String deletesql3 = " delete from work_log_detail where work_log_detail_serial_num in ("
						+ StringTools.listToString(deleteQueryList) + ")";
				Query delete3Query = entityManager
						.createNativeQuery(deletesql3);
				delete3Query.executeUpdate();
			}
			WorkLog workLog = null;
			if (worklogDto.getWorkLogSN() != null) {
				workLog = entityManager.find(WorkLog.class,
						worklogDto.getWorkLogSN());
				isEdit = true;
			} else {
				workLog = new WorkLog();
			}
			workLog.setEmployeeId(worklogDto.getEmployeeId());
			workLog.setWorkLogStatus(worklogDto.getWorkLogStatus().charAt(0));
			workLog.setWorkLogWeek(worklogDto.getWorkLogWeek());
			workLog.setWorkLogYear(worklogDto.getWorkLogYear());
			if (isEdit) {
				entityManager.merge(workLog);
			} else {
				entityManager.persist(workLog);
			}

			for (int i = 0; i < worklogDto.getWorklogDetailDtoList().size(); i++) {
				WorklogDetailDto worklogDetailDto = worklogDto
						.getWorklogDetailDtoList().get(i);
				WorkLogDetail detailDto = new WorkLogDetail();
				detailDto.setDailiyMealSupplement(worklogDetailDto
						.getDailiyMealSupplement());
				detailDto.setDailyHours(worklogDetailDto.getDailyHours());
				detailDto.setWorkDate(worklogDetailDto.getWorkDate());
				detailDto.setDateVersion(worklogDetailDto.getDateVersion());
				detailDto.setWorkWeekday(worklogDetailDto.getWorkWeekDay());
				detailDto.setWorkLogSn(workLog.getWorkLogSn());
				entityManager.persist(detailDto);
				for (int j = 0; j < worklogDetailDto
						.getWorklogWorksDetailDtoList().size(); j++) {
					WorklogWorksDetailDto worklogWorksDetailDto = worklogDetailDto
							.getWorklogWorksDetailDtoList().get(j);
					WorkLogWorksDetail workLogWorksDetail = new WorkLogWorksDetail();
					workLogWorksDetail.setPartHour(worklogWorksDetailDto
							.getPartHour());
					workLogWorksDetail.setProjectId(worklogWorksDetailDto
							.getProjectId() == null ? ""
							: worklogWorksDetailDto.getProjectId());
					if (StringTools.isNotNull(worklogWorksDetailDto
							.getWlwdType()) && worklogWorksDetailDto
							.getWlwdType() != "null"){
					workLogWorksDetail.setWlwdType(worklogWorksDetailDto
							.getWlwdType().charAt(0));
					}
					if (StringTools.isNotNull(worklogWorksDetailDto
							.getProjectId())) {
						projectSet.add(worklogWorksDetailDto.getProjectId());
					}
					workLogWorksDetail.setWorkContent(worklogWorksDetailDto
							.getWorkContent() == null ? ""
							: worklogWorksDetailDto.getWorkContent());
					workLogWorksDetail.setWorkLogDetailSerialNum(detailDto
							.getWorkLogDetailSerialNum());
					if (StringTools.isNotNull(worklogWorksDetailDto
							.getWorkPart())) {
						workLogWorksDetail.setWorkPart(worklogWorksDetailDto
								.getWorkPart().charAt(0));
					}
					if(StringTools.isNotNull(worklogWorksDetailDto.getWlwdStartTime()) && 
							StringTools.isNotNull(worklogWorksDetailDto.getWlwdEndTime()))
					{
					workLogWorksDetail.setWlwdStartTime(DateUtils.parseDate(
							worklogWorksDetailDto.getWlwdStartTime(),
							"HH:mm"));
					workLogWorksDetail
							.setWlwdEndTime(DateUtils.parseDate(
									worklogWorksDetailDto.getWlwdEndTime(),
									"HH:mm"));
					}
					if (StringTools.isNotNull(worklogWorksDetailDto
							.getWorkPlace())) {
						workLogWorksDetail.setWorkPlace(worklogWorksDetailDto
								.getWorkPlace().charAt(0));
					}
					entityManager.persist(workLogWorksDetail);
				}
			}
			if (WorklogStatus.SUBMIT.equals(String.valueOf(workLog
					.getWorkLogStatus()))) {
				String deleteWorkRecordSql = " delete from work_log_record where work_log_sn = ? ";
				Query deleteWorkRecordQuery = entityManager
						.createNativeQuery(deleteWorkRecordSql);
				deleteWorkRecordQuery.setParameter(1, workLog.getWorkLogSn());
				deleteWorkRecordQuery.executeUpdate();
				Set<String> employeeIdSet = projectService
						.getManagerSetByProjectSet(projectSet);
				boolean haveNOProject = haveNOProject(projectSet);

				List<String> managerList = new ArrayList<String>();
				for (String employeeId : employeeIdSet) {
					if (worklogDto.getEmployeeId().equals(employeeId)) {
						haveNOProject = true;
					} else {
						WorkLogRecord workLogRecord = new WorkLogRecord();
						workLogRecord.setEmployeeId(employeeId);
						workLogRecord
								.setWorkLogRecordStatus(WorkLogRecordStatus.NOT_REVIEW
										.charAt(0));
						workLogRecord.setWorkLogSn(workLog.getWorkLogSn());
						entityManager.persist(workLogRecord);
						managerList.add(employeeId);
					}
				}
				if (haveNOProject) {
					String managerId = getUserManagerId(workLog.getEmployeeId());
					if (StringTools.isNotNull(managerId)) {
						WorkLogRecord workLogRecord = new WorkLogRecord();
						workLogRecord.setEmployeeId(managerId);
						workLogRecord
								.setWorkLogRecordStatus(WorkLogRecordStatus.NOT_REVIEW
										.charAt(0));
						workLogRecord.setWorkLogSn(workLog.getWorkLogSn());
						entityManager.persist(workLogRecord);
						managerList.add(managerId);
					}
				}
				String subject = "工作日志审批提醒";
				StringBuffer content = new StringBuffer();
				content.append("您有一个待审批的工作日志需要处理：<br/>");
				content.append("员工姓名：" + worklogDto.getEmployeeName() + "<br/>");
				content.append("工作周：" + worklogDto.getWorkLogYear() + "年，第" + worklogDto.getWorkLogWeek() + "周");
				List<String> recipients = getUserEmail(managerList);
				EmailUtils.send(subject, content.toString(), recipients);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public SearchResultDto getWorklogList(WorklogSearchDto searchDto) {
		SearchResultDto resultDto = new SearchResultDto();
		List<WorklogDto> worklogDtoList = new ArrayList<WorklogDto>();
		Map<String, String> existProjectMap =  projectService.getProjectSelectItem();
		try {
//			String headSql = " select wl.work_log_sn ,wl.work_log_year, wl.work_log_week, wl.work_log_status, su.employee_name , " +
//					" mywlwd.normalTotalHour,mywlwd.overTimeTotalHour, mywlwd.leaveTotalHour, mywlwd.projectIds ," +
//					" truncate((mywlwd.normalTotalHour/(mywlwd.normalTotalHour + mywlwd.leaveTotalHour))*100,1) normalPersent ";
//			String mainSql = " from work_log wl left join sys_user su on wl.employee_id = su.sys_user_id "
//					+ " left join work_log_record wlr on wlr.work_log_sn = wl.work_log_sn left join (" +
//					" select wld.work_log_sn,sum(if(wlwd.wlwd_type = 'N', wlwd.part_hour,0)) normalTotalHour, " +
//					" sum(if(wlwd.wlwd_type = 'W', wlwd.part_hour,0)) overTimeTotalHour, sum(if(wlwd.wlwd_type = 'H', wlwd.part_hour,0)) leaveTotalHour," +
//					" group_concat(distinct(wlwd.project_id)) projectIds from work_log_detail wld left join work_log_works_detail wlwd " +
//					" on wlwd.work_log_detail_serial_num = wld.work_log_detail_serial_num group by wld.work_log_sn ) mywlwd on wl.work_log_sn = mywlwd.work_log_sn where wl.work_log_status <> 'A' and wl.work_log_status <> 'B' ";
			
			String headSql = " select wl.work_log_sn ,wl.work_log_year, wl.work_log_week, wl.work_log_status, su.employee_name,wld.work_date ";
			String mainSql = " from work_log wl left join sys_user su on wl.employee_id = su.sys_user_id "
					+ " left join work_log_record wlr on wlr.work_log_sn = wl.work_log_sn  "
					+ " left join work_log_detail wld on wld.work_log_sn = wl.work_log_sn  "
					+ " where wl.work_log_status <> 'A' and wl.work_log_status <> 'B' ";
			List<Object> params = new ArrayList<Object>();
			mainSql = setWorklogSqlByCondition(params, mainSql, searchDto);
			mainSql += " group by wl.work_log_sn ";
			Query countQuery = entityManager
					.createNativeQuery("select count(*) from ( select wl.work_log_sn  "
							+ mainSql + ") main ");
			countQuery = emTools.querySQLByCriteria(countQuery, params);
			try {
				resultDto.setTotalCount(Integer.parseInt(countQuery
						.getSingleResult().toString()));
			} catch (Exception e) {
			}
			if (StringTools.isNotNull(sortReflect(searchDto.getSortId()))) {
				mainSql += " order by " + sortReflect(searchDto.getSortId());
				if (StringTools.isNotNull(searchDto.getSortOrder()))
					mainSql += searchDto.getSortOrder() + ",";
			} else {
				mainSql += " order by wl.work_log_year desc, wl.work_log_week desc, su.employee_name asc, wl.work_log_status desc ";
			}
			Query resultlist = entityManager.createNativeQuery(headSql
					+ mainSql);
			resultlist = emTools.querySQLByCriteria(resultlist, params,
					searchDto.getPageSize(), searchDto.getStart());
			@SuppressWarnings("unchecked")
			List<Object[]> queryList = resultlist.getResultList();
			if (queryList.size() != 0) {
				for (int i = 0; i < queryList.size(); i++) {
					Object[] result = queryList.get(i);
					WorklogDto dto = new WorklogDto();
					dto.setWorkLogSN((Integer) result[0]);
					dto.setWorkLogYear((String) result[1]);
					dto.setWorkLogWeek((Integer) result[2]);
					dto.setWorkLogStatus((Character) result[3] + "");
					dto.setEmployeeName((String) result[4]);
					Date date = DateUtils.parseDate(result[5]+"");
					Integer mon = date.getMonth();
					dto.setWorkDate((mon+1)+"");
					dto.setWorkLogStatusShow(ShowRevert.logStatus(dto
							.getWorkLogStatus()));
////					dto.setTotalNormalHours(((Double)result[5]).floatValue());
////					dto.setTotalOvertimeHours(((Double)result[6]).floatValue());
////					dto.setTotalLeaveHours(((Double)result[7]).floatValue());
					getWorklogTime(dto);
					String projectIds = dto.getProjectIds();
					String[] projectIdArray = null;
					String projectNames = "";
					if(projectIds != null && projectIds.length() > 0){
						projectIdArray = projectIds.split(",");
						for(int j = 0; j < projectIdArray.length; j++){
							if(StringTools.isNotNull(projectIdArray[j]) && existProjectMap.get(projectIdArray[j]) != null){
								//dto.getProjectMap().put(projectIdArray[j], existProjectMap.get(projectIdArray[j]));
								projectNames += existProjectMap.get(projectIdArray[j]) + "<br/>";
							}
						}
						projectNames = projectNames.substring(0, projectNames.length() - 5);
					}
					dto.setProjectString(projectNames);
////					dto.setNormalPercent(((Double)result[9]).toString() + "%");
					worklogDtoList.add(dto);
					
				}
			}
			resultDto.setResultList(worklogDtoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultDto;
	}

	private String setWorklogSqlByCondition(List<Object> params, String sql,
			WorklogSearchDto searchDto) {
		if (searchDto != null) {
			if (StringTools.isNotNull(searchDto.getYear())) {
				sql += " and wl.work_log_year = ? ";
				params.add(searchDto.getYear());
			}
			if (StringTools.isNotNull(searchDto.getWeek())) {
				if ("0".equals(searchDto.getMonth())){
					sql += " and wl.work_log_week = ? ";
					params.add(searchDto.getWeek());
				}
				
			}
			if (StringTools.isNotNull(searchDto.getMonth())&&!searchDto.getMonth().equals("0")){
				String day = "31";
				if(searchDto.getMonth().equals("2")||searchDto.getMonth().equals("4")||searchDto.getMonth().equals("6")||searchDto.getMonth().equals("9")||searchDto.getMonth().equals("11")){
					day = "30";
				}
				sql += " and (wld.work_date BETWEEN '"+searchDto.getYear()+"-"+searchDto.getMonth()+"-01' AND '"+searchDto.getYear()+"-"+searchDto.getMonth()+"-"+day+"') ";
				
			}
			if (StringTools.isNotNull(searchDto.getEmployeeId())) {
				sql += " and wl.employee_id = ? ";
				params.add(searchDto.getEmployeeId());
			}
			if (StringTools.isNotNull(searchDto.getApprovallerId())) {
				sql += " and wlr.employee_id = ? ";
				params.add(searchDto.getApprovallerId());
			}
			if (searchDto.getEmployeeIdList().size() > 0) {
				sql += " and wl.employee_id in ("
						+ StringTools.listToString(searchDto
								.getEmployeeIdList()) + ")";
			}
			if (StringTools.isNotNull(searchDto.getApprovalStatus())) {
				sql += " and wlr.work_log_record_status = ? ";
				params.add(searchDto.getApprovalStatus());
			}
			if (StringTools.isNotNull(searchDto.getWorklogStatus())) {
				sql += " and wl.work_log_status = ? ";
				params.add(searchDto.getWorklogStatus());
			}

		}
		return sql;
	}

	private String sortReflect(String id) {
		String s = null;
		if ("workLogYear".equals(id)) {
			s = "wl.work_log_year ";
		} else if ("workLogWeek".equals(id)) {
			s = "wl.work_log_week ";
		} else if ("employeeName".equals(id)) {
			s = "su.employee_name ";
		}
		return s;
	}

	@Override
	public WorklogDto getWorklogDetail(String year, Integer week,
			String employeeId) {

		try {
			String sql = " select work_log_sn from work_log where work_log_year = ? and work_log_week = ? and employee_id = ? ";
			Query query = entityManager.createNativeQuery(sql);
			query.setParameter(1, year);
			query.setParameter(2, week);
			query.setParameter(3, employeeId);
			Integer worklogSN = null;
			try {
				worklogSN = (Integer) query.getResultList().get(0);
			} catch (Exception e) {
			}
			if (worklogSN == null) {
				return new WorklogDto();
			} else {
				return getWorklogDetail(worklogSN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	@SuppressWarnings("unchecked")
	public WorklogDto getWorklogDetail(Integer worklogSN) {
		
		NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(1);
		WorkLog worklog = entityManager.find(WorkLog.class, worklogSN);
		WorklogDto worklogDto = new WorklogDto();
		try {
			worklogDto.setWorkLogSN(worklog.getWorkLogSn());
			worklogDto.setEmployeeId(worklog.getEmployeeId());
			String emSql = " select employee_name from sys_user where sys_user_id = ? ";
			Query emQuery = entityManager.createNativeQuery(emSql);
			emQuery.setParameter(1, worklogDto.getEmployeeId());
			worklogDto.setEmployeeName((String)emQuery.getSingleResult());
			worklogDto.setWorkLogStatus(worklog.getWorkLogStatus() + "");
			worklogDto.setWorkLogStatusShow(ShowRevert.logStatus(worklogDto
					.getWorkLogStatus()));
			worklogDto.setWorkLogYear(worklog.getWorkLogYear());
			worklogDto.setWorkLogWeek(worklog.getWorkLogWeek());
			String sql = " from WorkLogDetail where workLogSn = ? ";
			Query query = entityManager.createQuery(sql);
			query.setParameter(1, worklogDto.getWorkLogSN());
			List<WorkLogDetail> workLogDetailList = (List<WorkLogDetail>) query
					.getResultList();
			String sql1 = " from WorkLogWorksDetail where workLogDetailSerialNum = ? ";
			String projectSql = " select project_name from project where project_id = ? ";
			Query projectQuery = entityManager.createNativeQuery(projectSql);
			Query query1 = entityManager.createQuery(sql1);
			for (int i = 0; i < workLogDetailList.size(); i++) {
				WorkLogDetail workLogDetail = workLogDetailList.get(i);
				WorklogDetailDto worklogDetailDto = new WorklogDetailDto();
				worklogDetailDto.setDailiyMealSupplement(workLogDetail
						.getDailiyMealSupplement());
				worklogDetailDto.setWorkLogDetailSerialNum(workLogDetail
						.getWorkLogDetailSerialNum());
				worklogDetailDto.setDailyHours(workLogDetail.getDailyHours());
				worklogDetailDto.setWorkDate(workLogDetail.getWorkDate());
				worklogDetailDto.setWorkWeekDay(workLogDetail.getWorkWeekday());
				worklogDetailDto.setDateVersion(workLogDetail.getDateVersion());

				query1.setParameter(1,
						workLogDetail.getWorkLogDetailSerialNum());
				List<WorkLogWorksDetail> workLogWorksDetailList = (List<WorkLogWorksDetail>) query1
						.getResultList();
				float checkHour = 0;
				float totalWorkHour = 0;
				for (int j = 0; j < workLogWorksDetailList.size(); j++) {
					WorkLogWorksDetail workLogWorksDetail = workLogWorksDetailList
							.get(j);
					WorklogWorksDetailDto worklogWorksDetailDto = new WorklogWorksDetailDto();
					worklogWorksDetailDto.setWlwdSn(workLogWorksDetail
							.getWlwdSn());
					worklogWorksDetailDto
							.setWorkLogDetailSerialNum(workLogWorksDetail
									.getWorkLogDetailSerialNum());
					worklogWorksDetailDto.setPartHour(workLogWorksDetail
							.getPartHour());
					worklogWorksDetailDto.setProjectId(workLogWorksDetail
							.getProjectId());
					if (StringTools.isNotNull(worklogWorksDetailDto
							.getProjectId())) {
						projectQuery.setParameter(1,
								worklogWorksDetailDto.getProjectId());
						String projectName = (String) projectQuery
								.getSingleResult();
						worklogWorksDetailDto.setProjectName(projectName);
					}
					worklogWorksDetailDto.setWorkContent(workLogWorksDetail
							.getWorkContent());
					worklogWorksDetailDto.setWorkPart(workLogWorksDetail
							.getWorkPart() + "");
					worklogWorksDetailDto.setWorkPartShow(ShowRevert
							.workPart(worklogWorksDetailDto.getWorkPart()));
					if(workLogWorksDetail.getWlwdEndTime() != null)
					{
					worklogWorksDetailDto.setWlwdEndTime(DateUtils.formatDate(
							workLogWorksDetail.getWlwdEndTime(), "HH:mm"));
					}
					if(workLogWorksDetail.getWlwdStartTime() != null){
					worklogWorksDetailDto.setWlwdStartTime(DateUtils
							.formatDate(workLogWorksDetail.getWlwdStartTime(),
									"HH:mm"));
					}
					worklogWorksDetailDto.setWlwdType(workLogWorksDetail
							.getWlwdType() + "");
					if(workLogWorksDetail.getWorkPlace() != null){
						worklogWorksDetailDto.setWorkPlace(workLogWorksDetail.getWorkPlace() + "");
					}
					if(StringTools.isNotNull(worklogWorksDetailDto.getWlwdType()) && !worklogWorksDetailDto.getWlwdType().equals(LevelOrOvertime.Overtime) 
							&& worklogWorksDetailDto.getPartHour() != null){
						if(worklogWorksDetailDto.getWlwdType().equals(LevelOrOvertime.normal))
						{	
							totalWorkHour += worklogWorksDetailDto.getPartHour();
						}
						checkHour += worklogWorksDetailDto.getPartHour();
						
					}
					
					worklogDetailDto.getWorklogWorksDetailDtoList().add(
							worklogWorksDetailDto);
				}
				if(worklogDetailDto.getDailyHours() > 0 && worklogDetailDto.getDailyHours().equals(checkHour)){
					float percent = totalWorkHour / worklogDetailDto.getDailyHours();
					worklogDetailDto.setRealWorkPercent(nf.format(percent * 100) + "%");
				}else if(worklogDetailDto.getDailyHours() > 0){
					worklogDetailDto.setRealWorkPercent("?");
				}
				worklogDto.getWorklogDetailDtoList().add(worklogDetailDto);
			}
			String recordSql = " select work_log_record_status, work_log_record_memo, employee_id, employee_name from work_log_record "
					+ " left join sys_user on sys_user.sys_user_id = work_log_record.employee_id where work_log_sn = ? order by work_log_record_sn desc";
			Query recordQuery = entityManager.createNativeQuery(recordSql);
			recordQuery.setParameter(1, worklogDto.getWorkLogSN());
			List<Object[]> recordList = recordQuery.getResultList();
			for (int i = 0; i < recordList.size(); i++) {
				Object[] result = recordList.get(i);
				WorklogRecordDto worklogRecordDto = new WorklogRecordDto();
				worklogRecordDto.setWorkLogRecordStatus((Character) result[0]
						+ "");
				worklogRecordDto.setWorkLogRecordMemo((String) result[1]);
				worklogRecordDto.setEmployeeId((String) result[2]);
				worklogRecordDto.setEmployeeName((String) result[3]);
				worklogDto.getWorklogRecordDtoList().add(worklogRecordDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return worklogDto;
	}

	@Override
	public List<Integer> getWorklogSNListByProjectIds(List<String> projectIds) {
		List<Integer> resultList = new ArrayList<Integer>();
		String sql1 = "select distinct(wld.work_log_sn) from work_log_works_detail wlwd left join work_log_detail wld "
				+ " on wld.work_log_detail_serial_num = wlwd.work_log_detail_serial_num where wlwd.project_id in ("
				+ StringTools.listToString(projectIds) + ")";
		String sql2 = "select distinct(wld.work_log_sn) from leave_and_overtime_detail laod left join work_log_detail wld "
				+ " on wld.work_log_detail_serial_num = laod.work_log_detail_serial_num where laod.project_id in ("
				+ StringTools.listToString(projectIds) + ")";
		Query query1 = entityManager.createNativeQuery(sql1);
		@SuppressWarnings("unchecked")
		List<Integer> query1List = query1.getResultList();
		Query query2 = entityManager.createNativeQuery(sql2);
		@SuppressWarnings("unchecked")
		List<Integer> query2List = query2.getResultList();
		if (query1List != null) {
			resultList.addAll(query1List);
		}
		if (query2List != null) {
			resultList.addAll(query2List);
		}
		return resultList;
	}

	@Override
	public void approvalWorklog(WorklogRecordDto worklogRecordDto) {
		if (worklogRecordDto.getWorkLogRecordStatus().equals(
				WorkLogRecordStatus.PASS)) {
			String sql = " select work_log_record_sn,employee_id,work_log_record_status from work_log_record where work_log_sn = ? ";
			Query query = entityManager.createNativeQuery(sql);
			query.setParameter(1, worklogRecordDto.getWorkLogSn());
			@SuppressWarnings("unchecked")
			List<Object[]> queryList = query.getResultList();
			if (queryList.size() > 0) {
				boolean allPass = true;
				for (int i = 0; i < queryList.size(); i++) {
					Object[] result = queryList.get(i);
					if (worklogRecordDto.getEmployeeId().equals(
							(String) result[1])) {
						WorkLogRecord workLogRecord = new WorkLogRecord();
						workLogRecord.setWorkLogRecordSn((Integer) result[0]);
						workLogRecord.setWorkLogSn(worklogRecordDto
								.getWorkLogSn());
						workLogRecord.setEmployeeId(worklogRecordDto
								.getEmployeeId());
						workLogRecord.setWorkLogRecordStatus(worklogRecordDto
								.getWorkLogRecordStatus().charAt(0));
						workLogRecord.setWorkLogRecordMemo(worklogRecordDto
								.getWorkLogRecordStatus());
						entityManager.merge(workLogRecord);
					} else {
						if (!String.valueOf((Character) result[2]).equals(
								WorkLogRecordStatus.PASS)) {
							allPass = false;
						}
					}
				}
				if (allPass) {
					WorkLog workLog = entityManager.find(WorkLog.class,
							worklogRecordDto.getWorkLogSn());
					workLog.setWorkLogStatus(worklogRecordDto
							.getWorkLogRecordStatus().charAt(0));
					entityManager.merge(workLog);
				}
			}
		} else {
			String sql = " select work_log_record_sn from work_log_record where work_log_sn = ? and employee_id = ? ";
			Query query = entityManager.createNativeQuery(sql);
			query.setParameter(1, worklogRecordDto.getWorkLogSn());
			query.setParameter(2, worklogRecordDto.getEmployeeId());
			@SuppressWarnings("unchecked")
			List<Integer> queryList = query.getResultList();
			if (queryList.size() > 0) {
				WorkLogRecord workLogRecord = new WorkLogRecord();
				workLogRecord.setWorkLogRecordSn(queryList.get(0));
				workLogRecord.setWorkLogSn(worklogRecordDto.getWorkLogSn());
				workLogRecord.setEmployeeId(worklogRecordDto.getEmployeeId());
				workLogRecord.setWorkLogRecordMemo(worklogRecordDto
						.getWorkLogRecordMemo());
				workLogRecord.setWorkLogRecordStatus(worklogRecordDto
						.getWorkLogRecordStatus().charAt(0));
				entityManager.merge(workLogRecord);

				WorkLog workLog = entityManager.find(WorkLog.class,
						worklogRecordDto.getWorkLogSn());
				workLog.setWorkLogStatus(worklogRecordDto
						.getWorkLogRecordStatus().charAt(0));
				entityManager.merge(workLog);
			}
		}

	}

	@Override
	public List<String> getNoSubmitWorklogEmailList(Integer year, Integer week) {
		List<String> emailList = new ArrayList<String>();
		String sql = " select su.sys_user_email, mywl.work_log_status from sys_user su left join "
				+ " (select wl.employee_id, wl.work_log_status from work_log wl "
				+ " where  wl.work_log_year = ? and wl.work_log_week = ?) mywl "
				+ " on mywl.employee_id = su.sys_user_id left join employee_role er on su.sys_user_sn = er.sys_user_sn "
				+ " left join role on role.role_sn = er.role_sn  where su.sys_user_status = 'N' and role.role_type <> 'A' and role.role_type <> 'B' ";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, year);
		query.setParameter(2, week);
		@SuppressWarnings("unchecked")
		List<Object[]> resultList = query.getResultList();
		for (int i = 0; i < resultList.size(); i++) {
			Object[] result = resultList.get(i);
			if (result[1] == null
					|| WorklogStatus.BACK.equals((Character) result[1] + "")
					|| WorklogStatus.ADD.equals((Character) result[1] + "")) {
				emailList.add((String) result[0]);
			}
		}
		return emailList;
	}

	private boolean haveNOProject(Set<String> projectSet) {
		if (projectSet == null || projectSet.size() == 0) {
			return true;
		} else {
			String sql = " select project_leader_id "
					+ " from project where project_type = 'Y' and project_id in ( "
					+ StringTools.setToString(projectSet) + ")";
			Query query = entityManager.createNativeQuery(sql);
			@SuppressWarnings("unchecked")
			List<Object[]> list = query.getResultList();
			if (list != null && list.size() > 0) {
				return true;
			} else {
				return false;
			}
		}
	}

	private String getUserManagerId(String userId) {
		String sql = " select manager_id from sys_user where sys_user_id = ? ";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, userId);
		String result = (String) query.getSingleResult();
		return result;
	}

	@Override
	public void updateWorklogDetail(WorklogWorksDetailDto worklogWorksDetailDto) {
		
		boolean isEdit = false;
		WorkLogWorksDetail workLogWorksDetail = null;
		if (worklogWorksDetailDto.getWlwdSn() != null) {
			workLogWorksDetail = entityManager.find(WorkLogWorksDetail.class,
					worklogWorksDetailDto.getWlwdSn());
			isEdit = true;
		} else {
			workLogWorksDetail = new WorkLogWorksDetail();
		}
		workLogWorksDetail
				.setPartHour(worklogWorksDetailDto.getPartHour());
		workLogWorksDetail
				.setProjectId(worklogWorksDetailDto.getProjectId() == null ? ""
						: worklogWorksDetailDto.getProjectId());
		if (StringTools.isNotNull(worklogWorksDetailDto.getWlwdType()) && worklogWorksDetailDto
				.getWlwdType() != "null") {
		workLogWorksDetail.setWlwdType(worklogWorksDetailDto.getWlwdType()
				.charAt(0));
		}
		workLogWorksDetail.setWorkContent(worklogWorksDetailDto
				.getWorkContent() == null ? "" : worklogWorksDetailDto
				.getWorkContent());
		workLogWorksDetail.setWorkLogDetailSerialNum(worklogWorksDetailDto
				.getWorkLogDetailSerialNum());
		if (StringTools.isNotNull(worklogWorksDetailDto.getWorkPart())) {
			workLogWorksDetail.setWorkPart(worklogWorksDetailDto.getWorkPart()
					.charAt(0));
		}
		if(StringTools.isNotNull(worklogWorksDetailDto.getWlwdStartTime())
				&& StringTools.isNotNull(worklogWorksDetailDto.getWlwdEndTime()))
		{
		workLogWorksDetail.setWlwdStartTime(DateUtils.parseDate(
				worklogWorksDetailDto.getWlwdStartTime(), "HH:mm"));
		workLogWorksDetail.setWlwdEndTime(DateUtils.parseDate(
				worklogWorksDetailDto.getWlwdEndTime(), "HH:mm"));
		}
		if (StringTools.isNotNull(worklogWorksDetailDto.getWorkPlace())) {
			workLogWorksDetail.setWorkPlace(worklogWorksDetailDto
					.getWorkPlace().charAt(0));
		}
		if (isEdit) {
			entityManager.merge(workLogWorksDetail);
		} else {
			entityManager.persist(workLogWorksDetail);
		}

	}

	@Override
	public void deleteWorklogDetail(WorklogWorksDetailDto worklogWorksDetailDto) {
		WorkLogWorksDetail worklogWorksDetail = entityManager.find(
				WorkLogWorksDetail.class, worklogWorksDetailDto.getWlwdSn());
		entityManager.remove(worklogWorksDetail);

	}

	@SuppressWarnings({"unchecked" })
	private void getWorklogTime(WorklogDto worklogDto) {
		// 取得工作时间、加班时间、请假时间和项目id
		StringBuffer sql = new StringBuffer();
		sql.append("select wll.normalTotalHour, wll.overTimeTotalHour, wll.leaveTotalHour, wll.projectIds, ");
		sql.append("       TRUNCATE((wll.normalTotalHour/(wll.normalTotalHour + wll.leaveTotalHour))*100, 1) normalPersent,wll.xiutotalhour ");
		sql.append("  from (");
		sql.append("select sum(if(wlwd.wlwd_type = 'N', wlwd.part_hour,0)) normalTotalHour, ");
		sql.append("       sum(if(wlwd.wlwd_type = 'W', wlwd.part_hour,0)) overtimetotalhour, ");
		sql.append("       sum(if(wlwd.wlwd_type = 'H', wlwd.part_hour,0)) leavetotalhour, ");
		sql.append("       sum(if(wlwd.wlwd_type = 'D', wlwd.part_hour,0)) xiutotalhour, ");
		sql.append("       group_concat(distinct(wlwd.project_id)) projectids ");
		sql.append("  from work_log_detail wld ");
		sql.append("  left join work_log_works_detail wlwd ");
		sql.append("         on wlwd.work_log_detail_serial_num = wld.work_log_detail_serial_num ");
		sql.append(" where wld.work_log_sn = ? ");
		sql.append(" group by wld.work_log_sn ");
		sql.append(") wll");
		
		Query query = entityManager.createNativeQuery(sql.toString());
		query.setParameter(1, worklogDto.getWorkLogSN());
		List<Object[]> listResult = query.getResultList();
		if (listResult != null && listResult.size() > 0) {
			Object[] objRow = (Object[])listResult.get(0);
			worklogDto.setTotalNormalHours(((Double)objRow[0]).floatValue());
			worklogDto.setTotalOvertimeHours(((Double)objRow[1]).floatValue());
			worklogDto.setTotalLeaveHours(((Double)objRow[2]).floatValue());
			worklogDto.setTotalxiuHours(((Double)objRow[5]).floatValue());
			if (objRow[3] != null) {
				worklogDto.setProjectIds(objRow[3].toString());
			}
			if (objRow[4] != null) {
				worklogDto.setNormalPercent(objRow[4].toString() + "%");
			} else {
				worklogDto.setNormalPercent("?");
			}
		}
	}

	private List<String> getUserEmail(List<String> userList) {
		StringBuffer sql = new StringBuffer();
		sql.append(" select sys_user_email from sys_user where sys_user_id in (");
		int size = userList.size();
		for (int i = 0; i < size; i++) {
			if (i + 1 < size) {
				sql.append("'" + userList.get(i) + "',");
			} else {
				sql.append("'" + userList.get(i) + "')");
			}
		}
		
		Query query = entityManager.createNativeQuery(sql.toString());
		@SuppressWarnings("unchecked")
		List<String> emailList = query.getResultList();
		return emailList;
	}

	@Override
	public String getShowWeekNo(String userId) {
		// 取得用户的入职日期
		Date entryDate = getEntryDate(userId);
		
		Calendar calender = Calendar.getInstance();
		// 设置周一为每周的第一天
		calender.setFirstDayOfWeek(Calendar.MONDAY); 
		int theWeek = calender.get(Calendar.WEEK_OF_YEAR);
		int theYear = calender.get(Calendar.YEAR);
		calender.add(Calendar.WEEK_OF_YEAR, 0 - Config.INNERINFO_CHECKED_WEEKNUM);
		
		for (int i = 0; i < Config.INNERINFO_CHECKED_WEEKNUM; i++) {
			calender.add(Calendar.WEEK_OF_YEAR, 1);
			int week = calender.get(Calendar.WEEK_OF_YEAR);
			int year = calender.get(Calendar.YEAR);
			int month = calender.get(Calendar.MONTH);
			// 如果是12月份，还是第一周，那么说明是跨年了
			if (month == 11 && week == 1) {
				year = year + 1;
			}
			// 检查是否有未提交日志
			if (checkWorklogNoSubmit(year, week, entryDate, userId)) {
				theWeek = week;
				theYear = year;
				break;
			}
		}
		
		return theYear + "-" + theWeek;
	}
	
	private Date getEntryDate(String userId) {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT e.entry_time ");
		sql.append("  FROM employee_info e, sys_user su ");
		sql.append(" WHERE e.employee_info_sn = su.employee_info_sn ");
		sql.append("   AND su.sys_user_id = '"+ userId + "'");
		Query query = entityManager.createNativeQuery(sql.toString());
		Date entryDate = (Date)query.getSingleResult();
		return entryDate;
	}
	
	/**
	 * 检查是否有未提交的日志
	 * @param year
	 * @param week
	 * @param dateOfEntry
	 * @return
	 */
	private boolean checkWorklogNoSubmit(int year, int week, Date dateOfEntry, String userId) {
		Calendar calender = Calendar.getInstance();
		calender.setTime(dateOfEntry);
		calender.setFirstDayOfWeek(Calendar.MONDAY);
		int myweek = calender.get(Calendar.WEEK_OF_YEAR);
		int myyear = calender.get(Calendar.YEAR);
		if (myyear > year) {
			return false;
		} else if (myyear == year) {
			if (myweek > week) {
				return false;
			}
		}
		calender.setTime(Config.SYSTEM_ENABLE_DATE);
		int systemEnableWeek = calender.get(Calendar.WEEK_OF_YEAR);
		int systemEnableYear = calender.get(Calendar.YEAR);
		if (systemEnableYear > year) {
			return false;
		} else if (systemEnableYear == year) {
			if (systemEnableWeek > week) {
				return false;
			}
		}
		
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT wl.work_log_status ");
		sql.append("  FROM work_log wl ");
		sql.append(" WHERE wl.work_log_year = '" + year + "'");
		sql.append("   AND wl.work_log_week = '" + week + "'");
		sql.append("   AND wl.employee_id = '" + userId + "'");
		
		Query query = entityManager.createNativeQuery(sql.toString());
		@SuppressWarnings("unchecked")
		List<Object> list = query.getResultList();
		if (list == null || list.size() == 0) {
			return true;
		}
		Object worklogStatus = list.get(0);
		if (worklogStatus == null || WorklogStatus.ADD.equals(worklogStatus.toString())
				|| WorklogStatus.BACK.equals(worklogStatus.toString())) {
			return true;
		}
		return false;
	}

}
