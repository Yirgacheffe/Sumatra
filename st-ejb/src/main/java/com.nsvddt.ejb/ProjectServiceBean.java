package cn.com.nsv.ejb.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import net.sf.json.JSONArray;
import cn.com.nsv.ejb.dto.ProjectDto;
import cn.com.nsv.ejb.dto.ProjectSearchDto;
import cn.com.nsv.ejb.dto.SearchResultDto;
import cn.com.nsv.ejb.entity.Project;
import cn.com.nsv.ejb.interfaces.ProjectService;
import cn.com.nsv.ejb.util.DateUtils;
import cn.com.nsv.ejb.util.EmTools;
import cn.com.nsv.ejb.util.ShowRevert;
import cn.com.nsv.ejb.util.StringTools;

@Stateless
public class ProjectServiceBean implements ProjectService{
	
	@PersistenceContext(unitName = "innerInfoMgmt")
    EntityManager entityManager;
	
	EmTools emTools = EmTools.getInstance();

	@Override
	public List<String> addProject(ProjectDto projectDto) {
		// TODO Auto-generated method stub
		List<String> messagesList = new ArrayList<String>();
		Project project = new Project();
		String sql ="select project_id,project_name from project where project_id=?" ;
		List<Object> params = new ArrayList<Object>();
		params.add(projectDto.getProjectId());
		Query query = entityManager.createNativeQuery(sql);
		query = emTools.querySQLByCriteria(query, params);
		  
		@SuppressWarnings("unchecked")
		List<Object[]> queryList = query.getResultList();
		if (queryList.size() <= 0) {
			project.setProjectId(projectDto.getProjectId());
			project.setProjectName(projectDto.getProjectName());
			project.setProjectLeaderId(projectDto.getProjectLeaderId());
			project.setProjectType(projectDto.getProjectType().charAt(0));
			project.setExpenseBudget(projectDto.getExpenseBudget());
			project.setProjectStartTime(projectDto.getProjectStartTime());
			project.setProjectStatus(projectDto.getProjectStatus().charAt(0));
			project.setMemo(projectDto.getMemo());
			entityManager.persist(project);
		}else{
			messagesList.add("项目编号重复");
		}
		return messagesList;
	}	

	@Override
	public List<String> editProject(ProjectDto projectDto) {
		// TODO Auto-generated method stub
	
		List<String> messagesList = new ArrayList<String>();
		String sql ="select project_id,project_name from project where project_id=? and project_sn <> ? " ;
		List<Object> params = new ArrayList<Object>();
		params.add(projectDto.getProjectId());
		params.add(projectDto.getProjectSn());
		Query query = entityManager.createNativeQuery(sql);
		query = emTools.querySQLByCriteria(query, params);
		  
		@SuppressWarnings("unchecked")
		List<Object[]> queryList = query.getResultList();
		if (queryList.size() <= 0) {
		Project project = entityManager.find(Project.class, projectDto.getProjectSn());
		project.setProjectSn(projectDto.getProjectSn());
		project.setProjectId(projectDto.getProjectId());
		project.setProjectName(projectDto.getProjectName());
		project.setProjectLeaderId(projectDto.getProjectLeaderId());
		project.setProjectType(projectDto.getProjectType().charAt(0));
		project.setExpenseBudget(projectDto.getExpenseBudget());
		project.setProjectStartTime(projectDto.getProjectStartTime());
		project.setProjectStatus(projectDto.getProjectStatus().charAt(0));
		project.setMemo(projectDto.getMemo());
		entityManager.merge(project);
		}else{
			messagesList.add("项目编号重复");
		}
		return messagesList;
	}

	@Override
	public SearchResultDto getProjectList(ProjectSearchDto searchDto) {
		SearchResultDto resultDto = new SearchResultDto();
		List<Object> params = new ArrayList<Object>();
		List<ProjectDto> list = new ArrayList<ProjectDto>();
		String headSql = " select p.project_sn , p.project_id , p.project_name, p.expense_budget, p.project_start_time, p.project_status, ifnull(su1.employee_name,''), p.project_type,p.memo ";
		String mainSql = " from project p left join sys_user su1 on su1.sys_user_id = p.project_leader_id  where 1=1";
		mainSql = setProjectSqlByCondition(params, mainSql, searchDto);
		Query countQuery = entityManager.createNativeQuery("select count(*)" + mainSql);
		countQuery = emTools.querySQLByCriteria(countQuery, params);
		resultDto.setTotalCount(Integer.parseInt(countQuery.getSingleResult().toString()));
		if (StringTools.isNotNull(sortReflect(searchDto.getSortId()))) {
			mainSql +=" order by " + sortReflect(searchDto.getSortId());
            if (StringTools.isNotNull(searchDto.getSortOrder()))
            	mainSql += searchDto.getSortOrder() + ",";
        } else{
        	mainSql += " order by ";
        }
		
		mainSql += " p.project_sn desc ";
		 Query resultlist = entityManager.createNativeQuery(headSql + mainSql);
 		 resultlist = emTools.querySQLByCriteria(resultlist, params, searchDto.getPageSize(),
				 searchDto.getStart());
		 @SuppressWarnings("unchecked")
		List<Object[]> queryList = resultlist.getResultList();
		 if (queryList.size() != 0) {
			 for (int i = 0; i < queryList.size(); i++) {
				 Object[] result = queryList.get(i);
				 ProjectDto dto = new ProjectDto();
				 dto.setProjectSn((Integer)result[0]);
				 dto.setProjectId((String)result[1]);
				 dto.setProjectName((String)result[2]);
				 dto.setExpenseBudget((Float)result[3]);
				 dto.setProjectStartTime((Date)result[4]);
				 dto.setProjectStatus((Character)result[5] + "");
				 dto.setProjectLeaderName((String)result[6]);
				 dto.setProjectType(String.valueOf((Character)result[7]));
				 dto.setProjectTypeShow(ShowRevert.projectType(dto.getProjectType()));
				 dto.setMemo((String)result[8]);
				 list.add(dto);
			 }
		 }
		 resultDto.setResultList(list);
		return resultDto;
	}
	
	private String setProjectSqlByCondition(List<Object> params, String sql,
			ProjectSearchDto projectSearchDto){
		if(projectSearchDto != null){
			if(StringTools.isNotNull(projectSearchDto.getProjectId())){
				sql += " and p.project_id like ? ";
				params.add(emTools.setlikeValueAll(projectSearchDto.getProjectId()));
			}
			if(StringTools.isNotNull(projectSearchDto.getProjectName())){
				sql += " and p.project_name like ? ";
				System.out.println(projectSearchDto.getProjectName());
				
				params.add(emTools.setlikeValueAll(projectSearchDto.getProjectName()));
			}
			if(StringTools.isNotNull(projectSearchDto.getProjectLeaderName())){
				sql += " and su1.sys_user_id like ? ";
				params.add(emTools.setlikeValueAll(projectSearchDto.getProjectLeaderName()));
			}
			if(projectSearchDto.getProjectStartTime() != null){
				sql += " and p.project_start_time >= ? ";
				params.add(projectSearchDto.getProjectStartTime());
			}
			if(projectSearchDto.getProjectEndTime() != null){
				sql += " and p.project_start_time <= ? ";
				params.add(projectSearchDto.getProjectEndTime());
			}
			if(StringTools.isNotNull(projectSearchDto.getProjectStatus())){
				sql += " and p.project_status = ? ";
				params.add(projectSearchDto.getProjectStatus());
			}
		}
		return sql;
		
	}
	
	private String sortReflect(String id){
		String s = null;
		if("projectId".equals(id)){
			s = "p.project_id ";
		}else if("projectName".equals(id)){
			s = "p.project_name ";
		}else if("expenseBudget".equals(id)){
			s = "p.expense_budget ";
		}
		return s;
	}

	@Override
	public ProjectDto assembleDetailById(String processId) {
		
		Integer myId = Integer.valueOf(processId);
		ProjectDto dto = new ProjectDto();
		Project project = entityManager.find(Project.class, myId);
		if(project != null)
		{
			dto.setProjectSn(project.getProjectSn());
			dto.setProjectName(project.getProjectName());
			dto.setProjectStatus(project.getProjectStatus() + "");
			dto.setProjectStartTime(project.getProjectStartTime());
			dto.setExpenseBudget(project.getExpenseBudget());
			dto.setProjectId(project.getProjectId());
			dto.setProjectLeaderId(project.getProjectLeaderId());
			dto.setProjectType(String.valueOf(project.getProjectType()));
			dto.setProjectTypeShow(ShowRevert.projectType(dto.getProjectType()));
			dto.setMemo(project.getMemo());
			if(StringTools.isNotNull(dto.getProjectLeaderId())){
				String sql = "select employee_name from sys_user where sys_user_id = ? ";
				Query query = entityManager.createNativeQuery(sql);
				query.setParameter(1, dto.getProjectLeaderId());
				String pld = (String)query.getSingleResult();
				dto.setProjectLeaderName(pld);
			}
		}
		
		return dto;
	}

	@Override
	public Map<String, String> getProjectSelectItem() {
		
		Map<String, String> resultMap = new HashMap<String, String>();
		String sql = " select project_id, project_name from project where project_status = 'O' ";
		Query query = entityManager.createNativeQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.getResultList();
		if(list != null){
			for(int i = 0; i < list.size(); i++){
				resultMap.put((String)list.get(i)[0],(String)list.get(i)[1]);
			}
		}
		return resultMap;
	}

	@Override
	public List<String> getProjectListByManagerId(String userId) {
		List<String> resultList = new ArrayList<String>();
		String sql = " select project_id from project where project_status = 'O' and project_leader_id = ?  ";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, userId);
		query.setParameter(2, userId);
		@SuppressWarnings("unchecked")
		List<String> list = query.getResultList();
		if(list != null){
			for(int i = 0; i < list.size(); i++){
				resultList.add(list.get(i));
			}
		}
		return resultList;
	}
	
	public Set<String> getManagerSetByProjectSet(Set<String> projectIdSet){
		Set<String> resultSet = new HashSet<String>();
		if(projectIdSet.size() > 0)
		{
			String sql = " select project_leader_id " +
				" from project where project_type = 'N' and project_id in ( " + StringTools.setToString(projectIdSet) + ")";
			Query query = entityManager.createNativeQuery(sql);
			@SuppressWarnings("unchecked")
			List<String> list = query.getResultList();
			if(list != null){
				for(int i = 0; i < list.size(); i++){
					String result = list.get(i);
					if(StringTools.isNotNull(result))
					{
						resultSet.add(result);
					}
				}
			}
		}
		return resultSet;
	}
	/*
	 * 项目统计分析
	 */
	@Override
	public List<ProjectSearchDto> getByTime(ProjectSearchDto dtoparam) {
		// TODO Auto-generated method stub
		String sqlwhere = "";
		if(dtoparam.getStartTime()==null||dtoparam.getStartTime().equals("")||dtoparam.getEndTime()==null||dtoparam.getEndTime().equals("")){
			sqlwhere = "";
		}else{
			sqlwhere = " and (wld.work_date between '"+dtoparam.getStartTime()+"' and '"+dtoparam.getEndTime()+"')";
		}
		
		String hql = ("select total_p.project_id,total_p.project_name,total_p.employee_id,total_p.employee_name,total_p.total_time,"
				+ " (total_p.total_time-ifnull(overtime_p.overtime_time,0)) work_time,overtime_p.overtime_time,qingtime_p.qingtime_time,xiutime_p.xiutime_time,truncate(total_p.total_time/7.5,2) 'worker_day' from "
				+ " (select pt.project_id,pt.project_name,wl.employee_id,su.employee_name,sum(wlwd.part_hour) 'total_time' from project pt"
				+ " left join work_log_works_detail wlwd on pt.project_id = wlwd.project_id"
				+ " left join work_log_detail wld on wld.work_log_detail_serial_num = wlwd.work_log_detail_serial_num"
				+ " left join work_log wl on wl.work_log_sn = wld.work_log_sn"
				+ " left join sys_user su on su.sys_user_id = wl.employee_id"
				+ " where 1 = 1 "+sqlwhere+" and wlwd.wlwd_type = 'N'"
				+ " group by pt.project_id,wl.employee_id )total_p"
				+ " left join "
				+ " (select pt.project_id,pt.project_name,wl.employee_id,su.employee_name,sum(wlwd.part_hour) 'overtime_time' from project pt"
				+ " left join work_log_works_detail wlwd on pt.project_id = wlwd.project_id"
				+ " left join work_log_detail wld on wld.work_log_detail_serial_num = wlwd.work_log_detail_serial_num"
				+ " left join work_log wl on wl.work_log_sn = wld.work_log_sn"
				+ " left join sys_user su on su.sys_user_id = wl.employee_id"
				+ " where wlwd.wlwd_type = 'W' "+sqlwhere+""
				+ " group by pt.project_id,wl.employee_id ) overtime_p on total_p.project_id = overtime_p.project_id and total_p.employee_id = overtime_p.employee_id"
				+ " left join "
				+ " ( select wl.employee_id,su.employee_name,sum(wlwd.part_hour) 'qingtime_time'"
				+ " from sys_user su left join work_log wl on wl.employee_id = su.sys_user_id "
				+ " left join work_log_detail wld on wl.work_log_sn = wld.work_log_sn"
				+ " left join work_log_works_detail wlwd on wld.work_log_detail_serial_num = wlwd.work_log_detail_serial_num"
				+ " where wlwd.wlwd_type = 'H' "+sqlwhere+""
				+ " group by su.sys_user_id ) qingtime_p on  total_p.employee_id = qingtime_p.employee_id"
				+ " left join "
				+ " ( select pt.project_id,pt.project_name,wl.employee_id,su.employee_name,sum(wlwd.part_hour) 'xiutime_time' from project pt"
				+ " left join work_log_works_detail wlwd on pt.project_id = wlwd.project_id"
				+ " left join work_log_detail wld on wld.work_log_detail_serial_num = wlwd.work_log_detail_serial_num"
				+ " left join work_log wl on wl.work_log_sn = wld.work_log_sn"
				+ " left join sys_user su on su.sys_user_id = wl.employee_id"
				+ " where 1 = 1 "+sqlwhere+" and wlwd.wlwd_type = 'D' and pt.project_id = '"+dtoparam.getProjectId()+"' "
				+ " group by pt.project_id,wl.employee_id ) xiutime_p on  total_p.employee_id = xiutime_p.employee_id"
				+ " where  total_p.project_id ='"+dtoparam.getProjectId()+"'"
				+ " group by total_p.project_id,total_p.employee_id");
		Query query = entityManager.createNativeQuery(hql);
		List<Object[]> list = query.getResultList();
		List<ProjectSearchDto> lists = new ArrayList<ProjectSearchDto>();
		if(list!=null&&list.size()>0){
			
			for(Object[] result : list){
				ProjectSearchDto psd = new ProjectSearchDto();
				psd.setProjectId(result[0].toString());
				psd.setProjectName(result[1].toString());
				psd.setEmployeeId(result[2]!=null?result[2].toString():"");
				psd.setEmployeeName(result[3]!=null?result[3].toString():"");
				psd.setETotalTime(result[4]!=null?Double.parseDouble(result[4].toString()):0);
				psd.setEAddWork(result[6]!=null?Double.parseDouble(result[6].toString()):0);
				psd.setEQingjia(result[7]!=null?Double.parseDouble(result[7].toString()):0);
				psd.setXiujia(result[8]!=null?Double.parseDouble(result[8].toString()):0);
				lists.add(psd);
			}
		}
		return lists;
	}

	/*
	 * 人力统计分析
	 */
	@Override
	public List<ProjectSearchDto> getByUser(ProjectSearchDto dtoparam) {
		// TODO Auto-generated method stub
		String hql = ("select total_time.employee_id,total_time.employee_name,total_time.project_id,total_time.project_name,total_time.work_time,"
				+ " add_time.add_time,qing_time.qing_time,xiu_time.xiu_time"
				+ " from ("
				+ " SELECT wl.employee_id,su.employee_name,wlwd.project_id,pro.project_name,SUM(wlwd.part_hour) as 'work_time'"
				+ " from work_log_works_detail wlwd"
				+ " LEFT JOIN work_log_detail wld ON wlwd.work_log_detail_serial_num = wld.work_log_detail_serial_num"
				+ " LEFT JOIN work_log wl ON wl.work_log_sn = wld.work_log_sn"
				+ " LEFT JOIN sys_user su ON su.sys_user_id = wl.employee_id"
				+ " LEFT JOIN project pro ON pro.project_id = wlwd.project_id"
				+ " where (wld.work_date BETWEEN '"+dtoparam.getStartTime()+"' and '"+dtoparam.getEndTime()+"') and wl.employee_id = '"+dtoparam.getEmployeeId()+"' AND wlwd.wlwd_type = 'N'"
				+ " GROUP BY pro.project_id "
				+ " ) total_time"
				+ " LEFT JOIN("
				+ " SELECT wl.employee_id,su.employee_name,wlwd.project_id,pro.project_name,SUM(wlwd.part_hour) as 'add_time' "
				+ " from work_log_works_detail wlwd"
				+ " LEFT JOIN work_log_detail wld ON wlwd.work_log_detail_serial_num = wld.work_log_detail_serial_num"
				+ " LEFT JOIN work_log wl ON wl.work_log_sn = wld.work_log_sn"
				+ " LEFT JOIN sys_user su ON su.sys_user_id = wl.employee_id"
				+ " LEFT JOIN project pro ON pro.project_id = wlwd.project_id "
				+ " where (wld.work_date BETWEEN '"+dtoparam.getStartTime()+"' and '"+dtoparam.getEndTime()+"') and wl.employee_id = '"+dtoparam.getEmployeeId()+"' AND wlwd.wlwd_type = 'W'"
				+ " GROUP BY pro.project_id"
				+ " ) add_time ON total_time.project_id = add_time.project_id"
				+ " LEFT JOIN("
				+ " SELECT wl.employee_id,su.employee_name,wlwd.project_id,pro.project_name,SUM(wlwd.part_hour) as 'qing_time'"
				+ " from work_log_works_detail wlwd"
				+ " LEFT JOIN work_log_detail wld ON wlwd.work_log_detail_serial_num = wld.work_log_detail_serial_num"
				+ " LEFT JOIN work_log wl ON wl.work_log_sn = wld.work_log_sn"
				+ " LEFT JOIN sys_user su ON su.sys_user_id = wl.employee_id"
				+ " LEFT JOIN project pro ON pro.project_id = wlwd.project_id"
				+ " where (wld.work_date BETWEEN '"+dtoparam.getStartTime()+"' and '"+dtoparam.getEndTime()+"') and wl.employee_id = '"+dtoparam.getEmployeeId()+"' AND wlwd.wlwd_type = 'H'"
				+ " GROUP BY pro.project_id"
				+ " ) qing_time ON qing_time.project_id = total_time.project_id"
				+ " LEFT JOIN("
				+ " SELECT wl.employee_id,su.employee_name,wlwd.project_id,pro.project_name,SUM(wlwd.part_hour) as 'xiu_time'"
				+ " from work_log_works_detail wlwd"
				+ " LEFT JOIN work_log_detail wld ON wlwd.work_log_detail_serial_num = wld.work_log_detail_serial_num"
				+ " LEFT JOIN work_log wl ON wl.work_log_sn = wld.work_log_sn"
				+ " LEFT JOIN sys_user su ON su.sys_user_id = wl.employee_id"
				+ " LEFT JOIN project pro ON pro.project_id = wlwd.project_id"
				+ " where (wld.work_date BETWEEN '"+dtoparam.getStartTime()+"' and '"+dtoparam.getEndTime()+"') and wl.employee_id = '"+dtoparam.getEmployeeId()+"' AND wlwd.wlwd_type = 'D'"
				+ " GROUP BY pro.project_id"
				+ " ) xiu_time ON xiu_time.project_id = total_time.project_id "
				+ " HAVING total_time.project_name is not null ");
		Query query = entityManager.createNativeQuery(hql);
		List<Object[]> list = query.getResultList();
		List<ProjectSearchDto> lists = new ArrayList<ProjectSearchDto>();
		if(list!=null&&list.size()>0){
			for(Object[] result : list){
				ProjectSearchDto psd = new ProjectSearchDto();
				psd.setEmployeeId(result[0].toString());
				psd.setEmployeeName(result[1].toString());
				psd.setProjectId(result[2]!=null?result[2].toString():"");
				psd.setProjectName(result[3]!=null?result[3].toString():"");
				psd.setETotalTime(result[4]!=null?Double.parseDouble(result[4].toString()):0);
				psd.setEAddWork(result[5]!=null?Double.parseDouble(result[5].toString()):0);
				psd.setEQingjia(result[6]!=null?Double.parseDouble(result[6].toString()):0);
				psd.setXiujia(result[7]!=null?Double.parseDouble(result[7].toString()):0);
				lists.add(psd);
			}
		}
		return lists;
	}
	
	/*
	 * 项目历史人力变更
	 */
	@Override
	public List<ProjectSearchDto> getByUserAndWords(ProjectSearchDto dtoparam) {
		// TODO Auto-generated method stub
		String name = " and total_p.employee_id='"+dtoparam.getEmployeeId()+"'";
		String pro = " and total_p.project_id ='"+dtoparam.getProjectId()+"'";
		String content = " and total_p.work_content like '%"+dtoparam.getWorkContent()+"%'";
		if(dtoparam.getWorkContent()==null||dtoparam.getWorkContent().equals("")){
			content = "";
		}
		if(dtoparam.getEmployeeId()==null||dtoparam.getEmployeeId().equals("")){
			name = "";
		}
		if(dtoparam.getProjectId()==null||dtoparam.getProjectId().equals("")){
			pro = "";
		}
		String hql = ("select *  from (select pt.project_id,pt.project_name,wl.employee_id,su.employee_name,wlwd.work_content,wld.work_date,wlwd.wlwd_sn from project pt"
				+ " left join work_log_works_detail wlwd on pt.project_id = wlwd.project_id"
				+ " left join work_log_detail wld on wld.work_log_detail_serial_num = wlwd.work_log_detail_serial_num"
				+ " left join work_log wl on wl.work_log_sn = wld.work_log_sn"
				+ " left join sys_user su on su.sys_user_id = wl.employee_id"
				+ " ) total_p where (total_p.work_date between '"+dtoparam.getStartTime()+"' and '"+dtoparam.getEndTime()+"')"+name+""+content+""+pro+"");
		
		//	String hql ="select pt.project_id,pt.project_name,wl.employee_id,su.employee_name,wlwd.work_content,wld.work_date from project pt left join work_log_works_detail wlwd on pt.project_id = wlwd.project_id left join work_log_detail wld on wld.work_log_detail_serial_num = wlwd.work_log_detail_serial_num left join work_log wl on wl.work_log_sn = wld.work_log_sn left join sys_user su on su.sys_user_id = wl.employee_id" ;
		Query query = entityManager.createNativeQuery(hql);
		List<Object[]> list = query.getResultList();
		
		List<ProjectSearchDto> lists = new ArrayList<ProjectSearchDto>();
		if(list!=null&&list.size()>0){
			for(Object[] result : list){
				ProjectSearchDto psd = new ProjectSearchDto();
				psd.setProjectId(result[0].toString());
				psd.setProjectName(result[1].toString());
				psd.setEmployeeId(result[2].toString());
				psd.setEmployeeName(result[3].toString());
				psd.setWorkContent(result[4].toString());
				psd.setWorkDate(DateUtils.parseDate(result[5].toString()));
				psd.setWlwdSn(Integer.parseInt(result[6].toString()));
				lists.add(psd);
			}
		}
		return lists;
	}

	@Override
	public Integer updatepro(List<ProjectSearchDto> dto) {
		// TODO Auto-generated method stub
		Integer stotal = 0;
		
		for(ProjectSearchDto dt : dto){
			String sql = "update work_log_works_detail SET project_id = '"+dt.getProjectId()+"' where wlwd_sn = "+dt.getWlwdSn()+"";
			Query query = entityManager.createNativeQuery(sql);
			try {
				query.executeUpdate();
				stotal++;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

		return stotal;
		
	}
	
	public String getProTime(String projectId){
		String sql = "select project_start_time from project where project_id ='"+projectId+"'";
		Query query = entityManager.createNativeQuery(sql);
		String start = query.getSingleResult().toString();
		return start;
	}
	


}