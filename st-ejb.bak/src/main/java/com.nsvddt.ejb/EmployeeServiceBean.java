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

import cn.com.nsv.ejb.dto.CertificateDto;
import cn.com.nsv.ejb.dto.EmployeeDto;
import cn.com.nsv.ejb.dto.EmployeeSearchDto;
import cn.com.nsv.ejb.dto.SearchResultDto;
import cn.com.nsv.ejb.entity.EmployeeCertificate;
import cn.com.nsv.ejb.entity.EmployeeInfo;
import cn.com.nsv.ejb.entity.EmployeeRole;
import cn.com.nsv.ejb.entity.Role;
import cn.com.nsv.ejb.entity.SysUser;
import cn.com.nsv.ejb.interfaces.EmployeeService;
import cn.com.nsv.ejb.util.DateUtils;
import cn.com.nsv.ejb.util.EmTools;
import cn.com.nsv.ejb.util.Encrypt;
import cn.com.nsv.ejb.util.StringTools;


@Stateless
public class EmployeeServiceBean implements EmployeeService{
	
	@PersistenceContext(unitName = "innerInfoMgmt")
    EntityManager entityManager;

	EmTools emTools = EmTools.getInstance();

	
	@Override
	public Map<String, String> getEmployeeSelectItem(boolean active, String employeeId) {
		Map<String,String> resultMap = new HashMap<String,String>();	
		String sql = " select sys_user_id, employee_name from sys_user where sys_user_id <> 'admin' ";
		if(active){
			sql += " and sys_user_status = 'N' ";
		}
		
		if(StringTools.isNotNull(employeeId)){
			Set<String> subSet = getSubEmployeeList(employeeId); 
			sql += " and sys_user_id in (" + StringTools.setToString(subSet) + ")";
		}
		Query query = entityManager.createNativeQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object[]> queryList = query.getResultList();
		if (queryList.size() > 0) {
			for(int i = 0; i < queryList.size(); i++)
			{
				resultMap.put((String)queryList.get(i)[0], (String)queryList.get(i)[1]);
			}
			
		}
		return resultMap;
	}

	@Override
	public List<String> addEmployee(EmployeeDto employeeDto) {
		List<String> messagesList = new ArrayList<String>();
		try{
		EmployeeInfo employeeinfo = new EmployeeInfo();
		SysUser sysuser = new SysUser();
		EmployeeRole employeerole = new EmployeeRole();
		String sqlId ="select sys_user_id,employee_name from sys_user where sys_user_id=?" ;
		Query queryId = entityManager.createNativeQuery(sqlId);
		queryId.setParameter(1, employeeDto.getSysUserId());
		String sqlEmail ="select sys_user_email,employee_name from sys_user where sys_user_email=?" ;
		Query queryEmail = entityManager.createNativeQuery(sqlEmail);
		queryEmail.setParameter(1, employeeDto.getSysUserEmail());
		
		@SuppressWarnings("unchecked")
		List<Object[]> queryIdList = queryId.getResultList();
		@SuppressWarnings("unchecked")
		List<Object[]> queryEmailList = queryEmail.getResultList();
		if (queryIdList.size() <= 0 && queryEmailList.size() <= 0) {
			
			sysuser.setSysUserId(employeeDto.getSysUserId());
			sysuser.setSysUserEmail(employeeDto.getSysUserEmail());
			sysuser.setEmployeeName(employeeDto.getEmployeeName());
			sysuser.setPassword(Encrypt.encodeByMD5(employeeDto.getIdentificationCard()));
			sysuser.setManagerId(employeeDto.getManagerId());
			sysuser.setSysUserStatus(employeeDto.getSysUserStatus().charAt(0));
			entityManager.persist(sysuser);
			
			employeeinfo.setSysUserSn(sysuser.getSysUserSn());
			employeeinfo.setEmployeeGender(employeeDto.getEmployeeGender().charAt(0));
			employeeinfo.setPositionalTitle(employeeDto.getPositionalTitle());
			employeeinfo.setEntryTime(employeeDto.getEntryTime());
			employeeinfo.setConversionTime(employeeDto.getConversionTime());
			employeeinfo.setHighestEducation(employeeDto.getHighestEducation());
			employeeinfo.setYearOfGraduation(employeeDto.getYearOfGraduation());
			employeeinfo.setGraduateInstitutions(employeeDto.getGraduateInstitutions());
			employeeinfo.setMajor(employeeDto.getMajor());
			employeeinfo.setNation(employeeDto.getNation());
			employeeinfo.setMaritalStatus(employeeDto.getMaritalStatus().charAt(0));
			employeeinfo.setPoliticalStatus(employeeDto.getPoliticalStatus());
			employeeinfo.setRegisteredPermanentResidenceDistrict(employeeDto.getRegisteredPermanentResidenceDistrict());
			employeeinfo.setRegisteredPermanentResidenceProperty(employeeDto.getRegisteredPermanentResidenceProperty().charAt(0));
			employeeinfo.setIdentificationCard(employeeDto.getIdentificationCard());
			employeeinfo.setLastWorkTime(employeeDto.getLastWorkTime());
			employeeinfo.setPersonnelFileStatus(employeeDto.getPersonnelFileStatus());
			employeeinfo.setRecordMemo(employeeDto.getRecordMemo());
			entityManager.persist(employeeinfo);
			
			String sql1 = " select max(employee_info_sn) from employee_info ";
			Query query1 = entityManager.createNativeQuery(sql1);
			int maxEmployeeSN = (Integer)query1.getSingleResult();
			
			for (int i = 0; i < employeeDto.getCertificateDtoList().size(); i++) {
				EmployeeCertificate employeeCertificate = new EmployeeCertificate();
				CertificateDto certificateDto = employeeDto.getCertificateDtoList().get(i);
				employeeCertificate.setCertificateName(certificateDto.getCertificateName());
				employeeCertificate.setIssuingAuthority(certificateDto.getIssuingAuthority());
				employeeCertificate.setGentTime(DateUtils.parseDate(certificateDto.getGentTime()));
				employeeCertificate.setEmployeeInfoSn(maxEmployeeSN);
				entityManager.persist(employeeCertificate);
			}
			
			String sql2 = " select max(employee_info_sn) from employee_info ";
			Query query2 = entityManager.createNativeQuery(sql2);
			int j = (Integer)query2.getSingleResult();
			sysuser.setEmployeeInfoSn(j);
			entityManager.persist(sysuser);
			
			employeerole.setEmployeeRoleSn(employeeDto.getEmployeeRoleSn());
			String sql3 = " select max(sys_user_sn) from employee_info ";
			Query query3 = entityManager.createNativeQuery(sql3);
			int k = (Integer)query3.getSingleResult();
			employeerole.setSysUserSn(k);
			employeerole.setRoleSn(employeeDto.getRoleSn());
			entityManager.persist(employeerole);
			
		}else if(queryIdList.size() > 0 && queryEmailList.size() <= 0){
			messagesList.add("员工编号已存在");
		}else if(queryEmailList.size() > 0 && queryIdList.size() <= 0){
			messagesList.add("员工邮箱已存在");
		}else if(queryIdList.size() > 0 && queryEmailList.size() > 0){
			messagesList.add("员工编号和邮箱已存在");
		}}catch(Exception e){e.printStackTrace();}
		return messagesList;
	}

	@Override
	public List<String> editEmployee(EmployeeDto employeeDto) {
		List<String> messagesList = new ArrayList<String>();
		String sqlId ="select sys_user_id,employee_name from sys_user where sys_user_id=? and sys_user_sn <> ? " ;
		Query queryId = entityManager.createNativeQuery(sqlId);
		queryId.setParameter(1, employeeDto.getSysUserId());
		queryId.setParameter(2, employeeDto.getSysUserSn());
		String sqlEmail ="select sys_user_email,employee_name from sys_user where sys_user_email=? and sys_user_sn <> ? " ;
		Query queryEmail = entityManager.createNativeQuery(sqlEmail);
		queryEmail.setParameter(1, employeeDto.getSysUserEmail());
		queryEmail.setParameter(2, employeeDto.getSysUserSn());
		
		@SuppressWarnings("unchecked")
		List<Object[]> queryIdList = queryId.getResultList();
		@SuppressWarnings("unchecked")
		List<Object[]> queryEmailList = queryEmail.getResultList();
		if (queryIdList.size() <= 0 && queryEmailList.size() <= 0) {
		EmployeeInfo employeeinfo = entityManager.find(EmployeeInfo.class, employeeDto.getEmployeeInfoSn());
		SysUser sysuser = entityManager.find(SysUser.class, employeeDto.getSysUserSn());
		EmployeeRole employeerole = entityManager.find(EmployeeRole.class, employeeDto.getEmployeeRoleSn());
		sysuser.setSysUserId(employeeDto.getSysUserId());
		sysuser.setSysUserEmail(employeeDto.getSysUserEmail());
		sysuser.setEmployeeName(employeeDto.getEmployeeName());
		sysuser.setManagerId(employeeDto.getManagerId());
		employeeinfo.setEmployeeGender(employeeDto.getEmployeeGender().charAt(0));
		sysuser.setSysUserStatus(employeeDto.getSysUserStatus().charAt(0));
		employeeinfo.setPositionalTitle(employeeDto.getPositionalTitle());
		employeeinfo.setEntryTime(employeeDto.getEntryTime());
		employeeinfo.setConversionTime(employeeDto.getConversionTime());
		employeeinfo.setHighestEducation(employeeDto.getHighestEducation());
		employeeinfo.setYearOfGraduation(employeeDto.getYearOfGraduation());
		employeeinfo.setGraduateInstitutions(employeeDto.getGraduateInstitutions());
		employeeinfo.setMajor(employeeDto.getMajor());
		employeeinfo.setNation(employeeDto.getNation());
		employeeinfo.setRecordMemo(employeeDto.getRecordMemo());
		employeeinfo.setMaritalStatus(employeeDto.getMaritalStatus().charAt(0));
		employeeinfo.setPoliticalStatus(employeeDto.getPoliticalStatus());
		employeeinfo.setRegisteredPermanentResidenceDistrict(employeeDto.getRegisteredPermanentResidenceDistrict());
		employeeinfo.setRegisteredPermanentResidenceProperty(employeeDto.getRegisteredPermanentResidenceProperty().charAt(0));
		employeeinfo.setIdentificationCard(employeeDto.getIdentificationCard());
		employeeinfo.setLastWorkTime(employeeDto.getLastWorkTime());
		employeeinfo.setPersonnelFileStatus(employeeDto.getPersonnelFileStatus());
		employeerole.setEmployeeRoleSn(employeeDto.getEmployeeRoleSn());
		employeerole.setSysUserSn(employeeDto.getSysUserSn());
		employeerole.setRoleSn(employeeDto.getRoleSn());
		entityManager.merge(employeerole);
		entityManager.merge(employeeinfo);
		entityManager.merge(sysuser);
		String delectSql = " delete from employee_certificate where employee_info_sn = ? ";
		Query delQuery = entityManager.createNativeQuery(delectSql);
		delQuery.setParameter(1, employeeinfo.getEmployeeInfoSn());
		delQuery.executeUpdate();
		
		for (int i = 0; i < employeeDto.getCertificateDtoList().size(); i++) {
			EmployeeCertificate employeeCertificate = new EmployeeCertificate();
			CertificateDto certificateDto = employeeDto.getCertificateDtoList().get(i);
			employeeCertificate.setCertificateName(certificateDto.getCertificateName());
			employeeCertificate.setIssuingAuthority(certificateDto.getIssuingAuthority());
			employeeCertificate.setGentTime(DateUtils.parseDate(certificateDto.getGentTime()));
			employeeCertificate.setEmployeeInfoSn(employeeinfo.getEmployeeInfoSn());
			entityManager.persist(employeeCertificate);
		}
		}else if(queryIdList.size() > 0 && queryEmailList.size() <= 0){
			messagesList.add("员工编号已存在");
		}else if(queryEmailList.size() > 0 && queryIdList.size() <= 0){
			messagesList.add("员工邮箱已存在");
		}else if(queryIdList.size() > 0 && queryEmailList.size() > 0){
			messagesList.add("员工编号和邮箱已存在");
		}
		return messagesList;
	}

	@Override
	public SearchResultDto getEmployeeList(EmployeeSearchDto searchDto) {
		
		SearchResultDto resultDto = new SearchResultDto();
		List<Object> params = new ArrayList<Object>();
		List<EmployeeDto> list = new ArrayList<EmployeeDto>();
		String headSql = " select em.employee_info_sn,sys.sys_user_email , sys.sys_user_id , sys.employee_name, em.employee_gender, role.role_name, sys.sys_user_status, em.entry_time,em.nation,em.highest_education, " +
				" em.year_of_graduation,em.positional_title,sys.manager_id,sys.sys_user_sn,role.role_type, ifnull(sys1.employee_name,''), em.record_memo ";
		String mainSql = " from employee_info em left join sys_user sys on sys.sys_user_sn = em.sys_user_sn left join employee_role er on em.sys_user_sn = er.sys_user_sn left join role on er.role_sn = role.role_sn " +
				" left join sys_user sys1 on sys1.sys_user_id = sys.manager_id where 1=1";
		mainSql = setEmployeeSqlByCondition(params, mainSql, searchDto);
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
		mainSql += " sys.sys_user_id asc ";
		 Query resultlist = entityManager.createNativeQuery(headSql + mainSql);
		 resultlist = emTools.querySQLByCriteria(resultlist, params, searchDto.getPageSize(),
				 searchDto.getStart());
		 @SuppressWarnings("unchecked")
		List<Object[]> queryList = resultlist.getResultList();
		 if (queryList.size() != 0) {
			 for (int i = 0; i < queryList.size(); i++) {
				 Object[] result = queryList.get(i);
				 EmployeeDto dto = new EmployeeDto();
				 dto.setEmployeeInfoSn((Integer)result[0]);
				 dto.setSysUserEmail((String)result[1]);
				 dto.setSysUserId((String)result[2]);
				 dto.setEmployeeName((String)result[3]);
				 dto.setEmployeeGender((Character)result[4]+ "");
				 dto.setSysUserStatus((Character)result[6] + "");
				 dto.setRoleName((String)result[5]);
				 dto.setEntryTime((Date)result[7]);
				 dto.setNation((String)result[8]);
				 dto.setHighestEducation((String)result[9]);
				 dto.setYearOfGraduation((String)result[10]);
				 dto.setPositionalTitle((String)result[11]);
				 dto.setManagerId((String)result[12]);
				 dto.setSysUserSn((Integer)result[13]);
				 dto.setRoleType(String.valueOf((Character)result[14]));
				 dto.setManagerName((String)result[15]);
				 dto.setRecordMemo((String)result[16]);
				 list.add(dto);
			 }
		 }
		 resultDto.setResultList(list);
		return resultDto;
	}

	private String setEmployeeSqlByCondition(List<Object> params, String sql,
			EmployeeSearchDto employeeSearchDto){
		if(employeeSearchDto != null){
			if(StringTools.isNotNull(employeeSearchDto.getSysUserEmail())){
				sql += " and sys.sys_user_email like ? ";
				params.add(emTools.setlikeValueAll(employeeSearchDto.getSysUserEmail()));
			}
			if(StringTools.isNotNull(employeeSearchDto.getSysUserId())){
				sql += " and sys.sys_user_id like ? ";
				params.add(emTools.setlikeValueAll(employeeSearchDto.getSysUserId()));
			}
			if(StringTools.isNotNull(employeeSearchDto.getEmployeeName())){
				sql += " and sys.employee_name like ? ";
				params.add(emTools.setlikeValueAll(employeeSearchDto.getEmployeeName()));
			}
			if(StringTools.isNotNull(employeeSearchDto.getEmployeeGender())){
				sql += " and em.employee_gender = ? ";
				params.add(employeeSearchDto.getEmployeeGender());
			}
			if(StringTools.isNotNull(employeeSearchDto.getRoleName())){
				sql += " and role.role_sn = ? ";
				params.add(employeeSearchDto.getRoleName());
			}
			if(StringTools.isNotNull(employeeSearchDto.getSysUserStatus())){
				sql += " and sys.sys_user_status = ? ";
				params.add(employeeSearchDto.getSysUserStatus());
			}
		}
		return sql;
		
	}
	
	private String sortReflect(String id){
		String s = null;
		if("sysUserId".equals(id)){
			s = "sys.sys_user_id ";
		}else if("employeeName".equals(id)){
			s = "sys.employee_name ";
		}else if("expenseBudget".equals(id)){
			s = "em.employee_gender ";
		}
		return s;
	}

	@Override
	public EmployeeDto assembleDetailById(String processId) {
		Integer myId = Integer.valueOf(processId);
		EmployeeDto dto = new EmployeeDto();try{
		SysUser sysuser = entityManager.find(SysUser.class, myId);
		EmployeeInfo employeeinfo = entityManager.find(EmployeeInfo.class, sysuser.getEmployeeInfoSn());
		
		String sql2 = " select employee_role_sn from employee_role where sys_user_sn = ? ";
		Query query2 = entityManager.createNativeQuery(sql2);
		query2.setParameter(1, sysuser.getSysUserSn());
		Integer sn = (Integer)query2.getSingleResult();
		dto.setEmployeeRoleSn(sn);
		EmployeeRole employeerole = entityManager.find(EmployeeRole.class, dto.getEmployeeRoleSn());
		if(employeeinfo != null)
		{	
			dto.setEmployeeInfoSn(employeeinfo.getEmployeeInfoSn());
			dto.setSysUserSn(employeeinfo.getSysUserSn());
			dto.setEmployeeGender(employeeinfo.getEmployeeGender() + "");
			dto.setPositionalTitle(employeeinfo.getPositionalTitle() + "");
			dto.setRecordMemo(employeeinfo.getRecordMemo());
			dto.setEntryTime(employeeinfo.getEntryTime());
			dto.setConversionTime(employeeinfo.getConversionTime());
			dto.setHighestEducation(employeeinfo.getHighestEducation());
			dto.setYearOfGraduation(employeeinfo.getYearOfGraduation());
			dto.setGraduateInstitutions(employeeinfo.getGraduateInstitutions());
			dto.setMajor(employeeinfo.getMajor());
			dto.setNation(employeeinfo.getNation());
			dto.setMaritalStatus(employeeinfo.getMaritalStatus() + "");
			dto.setPoliticalStatus(employeeinfo.getPoliticalStatus());
			dto.setRegisteredPermanentResidenceDistrict(employeeinfo.getRegisteredPermanentResidenceDistrict());
			dto.setRegisteredPermanentResidenceProperty(employeeinfo.getRegisteredPermanentResidenceProperty() + "");
			dto.setIdentificationCard(employeeinfo.getIdentificationCard());
			dto.setLastWorkTime(employeeinfo.getLastWorkTime());
			dto.setPersonnelFileStatus(employeeinfo.getPersonnelFileStatus());
			dto.setSysUserEmail(sysuser.getSysUserEmail());
			dto.setSysUserId(sysuser.getSysUserId());
			dto.setEmployeeName(sysuser.getEmployeeName());
			dto.setSysUserStatus(sysuser.getSysUserStatus() +"");
			dto.setManagerId(sysuser.getManagerId());

			
			dto.setEmployeeRoleSn(employeerole.getEmployeeRoleSn());
			dto.setSysUserSn(employeerole.getSysUserSn());
			dto.setRoleSn(employeerole.getRoleSn());
			Role role = entityManager.find(Role.class, dto.getRoleSn());
			dto.setRoleName(role.getRoleName());
			
			
			
			
			String sql = " from EmployeeCertificate where employeeInfoSn = ? ";
			Query query1 = entityManager.createQuery(sql);
			query1.setParameter(1, dto.getEmployeeInfoSn());
			@SuppressWarnings("unchecked")
			List<EmployeeCertificate> resultlist = query1.getResultList();
			for(int i = 0 ; i < resultlist.size(); i++){
				CertificateDto temp = new CertificateDto();
				temp.setEmployeeSN(resultlist.get(i).getEmployeeInfoSn());
				temp.setCertificateName(resultlist.get(i).getCertificateName());
				temp.setIssuingAuthority(resultlist.get(i).getIssuingAuthority());
				temp.setGentTime(DateUtils.formatDate(resultlist.get(i).getGentTime()));
				dto.getCertificateDtoList() .add(temp);
			}
		}}catch(Exception e){e.printStackTrace();}
		return dto;
		
	}

	@Override
	public Set<String> getSubEmployeeList(String employeeId) {
		Set<String> temp = new HashSet<String>();
		Set<String> result = new HashSet<String>();
		result.add(employeeId);
		String sql = " select sys_user_id from sys_user where manager_id = ? ";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, employeeId);
		@SuppressWarnings("unchecked")
		List<String> stringList = (List<String>)query.getResultList();
		for(int i = 0; i < stringList.size(); i++){
			if(!employeeId.equals(stringList.get(i)))
			{
				temp.add(stringList.get(i));
				result.add(stringList.get(i));
			}
		}
		if(temp.size() > 0)
		{
			result = getSubEmployeeList(temp,result);
		}
		return result;
	}
	
	private Set<String> getSubEmployeeList(Set<String> employeeIdSet, Set<String> noInSet){
		Set<String> tempSet = new HashSet<String>();
		for(String employeeId : employeeIdSet){
			String sql = " select sys_user_id from sys_user where manager_id = ? ";
			Query query = entityManager.createNativeQuery(sql);
			query.setParameter(1, employeeId);
			@SuppressWarnings("unchecked")
			List<String> stringList = (List<String>)query.getResultList();
			for(int i = 0; i < stringList.size(); i++){
				if(!employeeIdSet.contains(stringList.get(i)))
				{
					noInSet.add(stringList.get(i));
					tempSet.add(stringList.get(i));
				}
			}
			if(tempSet.size() > 0){
				getSubEmployeeList(tempSet, noInSet);
			}
		}
		return noInSet;
	}
	
	
}
