package cn.com.nsv.ejb.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cn.com.nsv.ejb.conn.Config;
import cn.com.nsv.ejb.conn.TaMark;
import cn.com.nsv.ejb.dto.AuthorityDto;
import cn.com.nsv.ejb.dto.AuthoritySearchDto;
import cn.com.nsv.ejb.dto.CurUserDto;
import cn.com.nsv.ejb.dto.FunctionDto;
import cn.com.nsv.ejb.dto.SearchResultDto;
import cn.com.nsv.ejb.entity.Role;
import cn.com.nsv.ejb.entity.RoleFun;
import cn.com.nsv.ejb.entity.SysUser;
import cn.com.nsv.ejb.interfaces.AuthorityService;
import cn.com.nsv.ejb.util.EmTools;
import cn.com.nsv.ejb.util.Encrypt;
import cn.com.nsv.ejb.util.StringTools;

import com.opensymphony.xwork2.Action;

@Stateless
public class AuthorityServiceBean implements AuthorityService {

	@PersistenceContext(unitName = "innerInfoMgmt")
	EntityManager entityManager;
	
	EmTools emTools = EmTools.getInstance();

	@Override
	public CurUserDto login(String userEmail, String userPassword) {

		CurUserDto dto = new CurUserDto();
		if (StringTools.isNotNull(userEmail)
				&& StringTools.isNotNull(userPassword)) {
			String sql = " select su.sys_user_sn, su.sys_user_id, su.employee_name, su.sys_user_status ,su.manager_id " +
					"from sys_user su where su.sys_user_email = ? and su.password = ? ";
			Query query = entityManager.createNativeQuery(sql);
			query.setParameter(1, userEmail);
			query.setParameter(2, userPassword);
			@SuppressWarnings("unchecked")
			List<Object[]> list = (List<Object[]>) query.getResultList();
			if (list != null && list.size() > 0) {
				Object[] object = list.get(0);
				if (((Character) object[3]).equals(TaMark.DELETE_MARK_NORMAL)) {
					dto.setUserEmail(userEmail);
					dto.setUserSN((Integer) object[0]);
					dto.setUserId((String) object[1]);
					dto.setUserName((String) object[2]);
					String subSql = " select role.role_type from employee_role er left join role " +
							" on role.role_sn = er.role_sn where er.sys_user_sn = ? ";
					Query subQuery = entityManager.createNativeQuery(subSql);
					subQuery.setParameter(1, dto.getUserSN());
					try{
					Character ch = (Character)subQuery.getSingleResult();
					dto.setRoleType(ch);
					dto.setManagerId((String)object[4]);
					}catch(Exception e){
						return null;
					}					
				} else {
					return null;
				}
			} else {
				return null;
			}
		} else {
			return null;
		}
		return dto;
	}

	@Override
	public List<FunctionDto> getMenu(Integer sysUserSN) {
		
		Set<String> temp = new HashSet<String>();
		List<FunctionDto> list = new ArrayList<FunctionDto>();
		String subSql = " select tf.fun_id,tf.fun_name,tf.parent_fun_id, tf.link_page, rf.role_permission "
				+ " from employee_role er left join role_fun rf on rf.role_sn = er.role_sn left join ta_functions tf "
				+ " on tf.fun_serial_num = rf.fun_serial_num where er.sys_user_sn = ? and tf.display_flag = 'Y' ";
		Query subquery = entityManager.createNativeQuery(subSql);
		subquery.setParameter(1, sysUserSN);	
		@SuppressWarnings("unchecked")
		List<Object[]> funlist = (List<Object[]>) subquery.getResultList();
		if (funlist != null && funlist.size() > 0) {
			for (int i = 0; i < funlist.size(); i++) {
				Object[] result = funlist.get(i);
				FunctionDto fundto = new FunctionDto();
				fundto.setFunId((String) result[0]);
				fundto.setFunName((String) result[1]);
				fundto.setParentId((String) result[2]);
				fundto.setFunUrl((String) result[3]);
				fundto.setPromission((String) result[4]);
				temp.add(fundto.getParentId());
				list.add(fundto);
			}
			String params = "";
			
			Object[] tempArray = (Object[]) temp.toArray();
			for(int i = 0; i < tempArray.length; i++){
				params += "'"+tempArray[i] + "',";
			}
			if(params.length() != 0){
				params = params.substring(0,params.length() - 1);
			}
			String onSql =  " select tf.fun_id,tf.fun_name from ta_functions tf where tf.fun_id in (" + params + ")";
			Query onquery = entityManager.createNativeQuery(onSql);
			@SuppressWarnings("unchecked")
			List<Object[]> onlist = (List<Object[]>) onquery.getResultList();
			for (int i = 0; i < onlist.size(); i++) {
				Object[] result = onlist.get(i);
				FunctionDto fundto = new FunctionDto();
				fundto.setFunId((String) result[0]);
				fundto.setFunName((String) result[1]);
				list.add(fundto);
			}
		}
		return list;
	}

	@Override
	public String resetPassword(String userEmail, String oldPw, String newPw) {
		String sql = " select su.sys_user_sn from sys_user su where su.sys_user_email = ? and su.password = ? ";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, userEmail);
		query.setParameter(2, oldPw);
		Integer userSN = null;
		try{
			userSN = (Integer) query.getSingleResult();
		}catch(Exception e){}
		if(userSN != null){
			
			SysUser user = entityManager.find(SysUser.class,userSN);
			user.setPassword(newPw);
			entityManager.merge(user);
			return Action.SUCCESS;
		}else{
			return Action.NONE;
		}
		
	}

	@Override
	public SearchResultDto getAuthoritiyMgmtList(AuthoritySearchDto searchDto) {
		SearchResultDto resultDto = new SearchResultDto();
		List<AuthorityDto> list = new ArrayList<AuthorityDto>();
		List<Object> params = new ArrayList<Object>();
		String headSql = "select role.role_sn, role.role_name, myrf.funnames,role.role_type ";
		String mainSql = " from role left join (select rf.role_sn,group_concat(tf.fun_name) funnames from role_fun rf " +
				" left join ta_functions tf on tf.fun_serial_num = rf.fun_serial_num group by rf.role_sn) myrf " +
				" on myrf.role_sn = role.role_sn where role.role_status <> 'D' and role_type <> 'A'";
		mainSql = settAuthoritiyMgmtSqlByCondition(params, mainSql, searchDto);
		Query countQuery = entityManager.createNativeQuery("select count(*)" + mainSql);
		countQuery = emTools.querySQLByCriteria(countQuery, params);
		resultDto.setTotalCount(Integer.parseInt(countQuery.getSingleResult().toString()));
		mainSql += " order by  role.role_sn desc ";
		Query resultlist = entityManager.createNativeQuery(headSql + mainSql);
		 resultlist = emTools.querySQLByCriteria(resultlist, params, searchDto.getPageSize(),
				 searchDto.getStart());
		 @SuppressWarnings("unchecked")
		List<Object[]> queryList = resultlist.getResultList();
		 if (queryList.size() != 0) {
			 for (int i = 0; i < queryList.size(); i++) {
				 Object[] result = queryList.get(i);
				 AuthorityDto dto = new AuthorityDto();
				 dto.setRoleSN((Integer)result[0]);
				 dto.setRoleName((String)result[1]);
				 dto.setFunctionNameStrings((String)result[2]);
				 dto.setRoleType(String.valueOf((Character)result[3]));
				 list.add(dto);
			 }
			 resultDto.setResultList(list);
		 }
		 
		return resultDto;
	}
	
	private String settAuthoritiyMgmtSqlByCondition(List<Object> params, String sql,
			AuthoritySearchDto searchDto){
		if(searchDto != null){
			if(StringTools.isNotNull(searchDto.getRoleName())){
				sql += " and role.role_name like ? ";
				params.add("%" + searchDto.getRoleName() + "%");
			}
		}
		return sql;
	}

	@Override
	public AuthorityDto getAuthorityDetail(Integer roleSN) {
		AuthorityDto authorityDto = new AuthorityDto();
		Role role = entityManager.find(Role.class, roleSN);
		authorityDto.setRoleSN(role.getRoleSn());
		authorityDto.setRoleName(role.getRoleName());
		String sql = " select rf.fun_serial_num, tf.fun_id, tf.fun_name from role_fun rf left join ta_functions tf " +
				" on rf.fun_serial_num = tf.fun_serial_num where tf.display_flag = 'Y' and rf.role_sn = ? group by tf.fun_serial_num ";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, roleSN);
		@SuppressWarnings("unchecked")
		List<Object[]> queryList = query.getResultList();
		 if (queryList.size() != 0) {
			 for(int i = 0; i < queryList.size(); i++)
			 {
				 Object[] result =  queryList.get(i);
				 FunctionDto functionDto = new FunctionDto();
				 functionDto.setFunSN((Integer)result[0]);
				 functionDto.setFunId((String)result[1]);
				 functionDto.setFunName((String)result[2]);
				 authorityDto.getFunctionDtoList().add(functionDto);
			 }
		 }
		return authorityDto;
	}

	@Override
	public void editAuthority(AuthorityDto authorityDto) {
		String sql = " delete from role_fun where role_sn = ? ";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, authorityDto.getRoleSN());
		query.executeUpdate();
		Map<String,Integer> tempMap = getFunIdMap();
		for(int i = 0; i < authorityDto.getFunctionDtoList().size(); i++){ 
			RoleFun roleFun = new RoleFun();
			Integer funSN = tempMap.get(authorityDto.getFunctionDtoList().get(i).getFunId());
			roleFun.setFunSerialNum(funSN);
			roleFun.setRoleSn(authorityDto.getRoleSN());
			roleFun.setRolePermission("RW");
			entityManager.persist(roleFun);
		}
	}
	
	private Map<String,Integer> getFunIdMap(){
		Map<String,Integer> theMap = new HashMap<String,Integer>();
		String sql = " select fun_id, fun_serial_num from ta_functions ";
		Query query = entityManager.createNativeQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object[]> queryList = query.getResultList();
		if (queryList.size() != 0) {
			 for(int i = 0; i < queryList.size(); i++)
			 {
				 Object[] result =  queryList.get(i);
				 theMap.put((String)result[0], (Integer)result[1]);
			 }
		 }
		return theMap;
	}

	@Override
	public List<FunctionDto> getAllMenu() {
		List<FunctionDto> list = new ArrayList<FunctionDto>();
		String subSql = " select tf.fun_id,tf.fun_name,tf.parent_fun_id, tf.link_page, "
				+ "tf.fun_serial_num from ta_functions tf where tf.display_flag = 'Y' ";
		Query subquery = entityManager.createNativeQuery(subSql);
		@SuppressWarnings("unchecked")
		List<Object[]> funlist = (List<Object[]>) subquery.getResultList();
		if (funlist != null && funlist.size() > 0) {
			for (int i = 0; i < funlist.size(); i++) {
				Object[] result = funlist.get(i);
				if(result[2] == null && !((String) result[0]).equals("systemMgmt"))
				{
				FunctionDto fundto = new FunctionDto();
				fundto.setFunId((String) result[0]);
				fundto.setFunName((String) result[1]);
				fundto.setParentId((String) result[2]);
				fundto.setFunUrl((String) result[3]);
				fundto.setFunSN((Integer)result[4]);
				list.add(fundto);
				}
			}
			for(int j = 0; j < list.size(); j++){
				for(int k = 0; k < funlist.size(); k++){
					Object[] result = funlist.get(k);
					if(result[2] != null && list.get(j).getFunId().equals((String)result[2])){
						FunctionDto fundto = new FunctionDto();
						fundto.setFunId((String) result[0]);
						fundto.setFunName((String) result[1]);
						fundto.setParentId((String) result[2]);
						fundto.setFunUrl((String) result[3]);
						fundto.setFunSN((Integer)result[4]);
						list.get(j).getSubFunctionList().add(fundto);
						continue;
					}
				}
			}
		}
		return list;
	}

	@Override
	public String getMd5Password(String email) {
		String result = null;
		String sql = " select password from sys_user where sys_user_email = ? and sys_user_status = 'N'";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter(1, email);
		try{
			result = (String)query.getSingleResult();
			if(result != null){
				result = Encrypt.encodeByMD5(result);
			}
		}catch(Exception e){
			
		}
		return result;
	}

	@Override
	public String resetDefultPassword(String email,String checkwords) {
		String genword = getMd5Password(email);
		if(checkwords.equalsIgnoreCase(genword)){
			String newPwd = Encrypt.encodeByMD5(Config.pass_word);
			String sql = " update sys_user set password = ? where sys_user_email = ? ";
			Query query = entityManager.createNativeQuery(sql);
			query.setParameter(1, newPwd);
			query.setParameter(2, email);
			query.executeUpdate();
			return Action.SUCCESS;
		}else{
			return Action.NONE;
		}
		
	}

}
