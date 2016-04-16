package cn.com.nsv.ejb.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cn.com.nsv.ejb.conn.RoleType;
import cn.com.nsv.ejb.dto.RoleDto;
import cn.com.nsv.ejb.dto.RoleSearchDto;
import cn.com.nsv.ejb.dto.SearchResultDto;
import cn.com.nsv.ejb.entity.Role;
import cn.com.nsv.ejb.interfaces.RoleService;
import cn.com.nsv.ejb.util.EmTools;
import cn.com.nsv.ejb.util.ShowRevert;
import cn.com.nsv.ejb.util.StringTools;

@Stateless
public class RoleServiceBean implements RoleService {
	
	@PersistenceContext(unitName = "innerInfoMgmt")
    EntityManager entityManager;
	
	EmTools emTools = EmTools.getInstance();

	@Override
	public SearchResultDto getRoleList(RoleSearchDto searchDto) {
		
		SearchResultDto resultDto = new SearchResultDto();
		List<Object> params = new ArrayList<Object>();
		List<RoleDto> list = new ArrayList<RoleDto>();
		String headSql = " select r.role_sn , r.role_name , r.role_status, r.record_memo, r.role_type ";
		String mainSql = " from role r  where role_type <> 'A' ";
		mainSql = setRoleSqlByCondition(params, mainSql, searchDto);
		Query countQuery = entityManager.createNativeQuery("select count(*)" + mainSql);
		countQuery = emTools.querySQLByCriteria(countQuery, params);
		resultDto.setTotalCount(Integer.parseInt(countQuery.getSingleResult().toString()));
		if (StringTools.isNotNull(sortReflect(searchDto.getSortId()))) {
			mainSql +=" order by " + sortReflect(searchDto.getSortId());
            if (StringTools.isNotNull(searchDto.getSortOrder()))
            	mainSql += searchDto.getSortOrder() + ",";
        } else{
        	mainSql += " order by r.role_sn desc";
        }
		Query resultlist = entityManager.createNativeQuery(headSql + mainSql);
		 resultlist = emTools.querySQLByCriteria(resultlist, params, searchDto.getPageSize(),
				 searchDto.getStart());
		 @SuppressWarnings("unchecked")
		List<Object[]> queryList = resultlist.getResultList();
		if (queryList.size() != 0) {
			 for (int i = 0; i < queryList.size(); i++) {
				 Object[] result = queryList.get(i);
				 RoleDto dto = new RoleDto();
				 dto.setRoleSn((Integer)result[0]);
				 dto.setRoleName((String)result[1]);
				 dto.setRoleStatus((Character)result[2]+ "");
				 dto.setRecordMemo((String)result[3]);
				 dto.setRoleType(String.valueOf((Character)result[4]));
				 dto.setRoleTypeShow(ShowRevert.roleType(dto.getRoleType()));
				 list.add(dto);
			 }
		 }
		 resultDto.setResultList(list);
		return resultDto;
	}
	
	private String sortReflect(String id) {
		String s = null;
		if("roleName".equals(id)){
			s = "r.role_name ";}
		return s;
	}

	private String setRoleSqlByCondition(List<Object> params, String sql,
			RoleSearchDto roleSearchDto){
		if(roleSearchDto != null){
			if(StringTools.isNotNull(roleSearchDto.getRoleName())){
				sql += " and r.role_name like ? ";
				params.add(emTools.setlikeValueAll(roleSearchDto.getRoleName()));
			}
			if(StringTools.isNotNull(roleSearchDto.getRoleStatus())){
				sql += " and r.role_status like ? ";
				params.add(emTools.setlikeValueAll(roleSearchDto.getRoleStatus()));
			}
			
		}
		return sql;
		
	}

	@Override
	public RoleDto assembleDetailById(String processId) {
		Integer myId = Integer.valueOf(processId);
		RoleDto dto = new RoleDto();
		Role role = entityManager.find(Role.class, myId);
		if(role != null)
		{
			dto.setRoleSn(role.getRoleSn());
			dto.setRoleName(role.getRoleName());
			dto.setRoleType(role.getRoleType() + "");
			dto.setRoleStatus(role.getRoleStatus() + "");
			dto.setRecordMemo(role.getRecordMemo());
		}
		return dto;
	}

	@Override
	public List<String> addRole(RoleDto roleDto) {
		
		List<String> messagesList = new ArrayList<String>();try{
		Role role = new Role();
		String sql ="select role_name from role where role_name=?" ;
		List<Object> params = new ArrayList<Object>();
		params.add(roleDto.getRoleName());
		Query query = entityManager.createNativeQuery(sql);
		query = emTools.querySQLByCriteria(query, params);
		  
		@SuppressWarnings("unchecked")
		List<Object[]> queryList = query.getResultList();
		if (queryList.size() <= 0) {
			role.setRoleSn(roleDto.getRoleSn());
			role.setRoleName(roleDto.getRoleName());
			role.setRoleType(roleDto.getRoleType().charAt(0));
			role.setRoleStatus(roleDto.getRoleStatus().charAt(0));
			role.setRecordMemo(roleDto.getRecordMemo());
			entityManager.persist(role);
		}else{
			messagesList.add("角色名称重复");
		}}catch(Exception e){e.printStackTrace();}
		return messagesList;
	}

	@Override
	public List<String> editRole(RoleDto roleDto) {
		List<String> messagesList = new ArrayList<String>();
		String sql ="select role_name from role where role_name=? and role_sn <> ?" ;
		List<Object> params = new ArrayList<Object>();
		params.add(roleDto.getRoleName());
		params.add(roleDto.getRoleSn());
		Query query = entityManager.createNativeQuery(sql);
		query = emTools.querySQLByCriteria(query, params);
		  
		@SuppressWarnings("unchecked")
		List<Object[]> queryList = query.getResultList();
		if (queryList.size() <= 0) {
		Role role = entityManager.find(Role.class, roleDto.getRoleSn());
		role.setRoleSn(roleDto.getRoleSn());
		role.setRoleName(roleDto.getRoleName());
		role.setRoleType(roleDto.getRoleType().charAt(0));
		role.setRoleStatus(roleDto.getRoleStatus().charAt(0));
		role.setRecordMemo(roleDto.getRecordMemo());
		entityManager.merge(role);
		}else{
			messagesList.add("角色名称重复");
		}
		return messagesList;
	}

	@Override
	public Map<String, String> getRoleSelectItem(String roleType) {
		
		Map<String, String> resultMap = new HashMap<String, String>();
		String sql = " select role_sn,role_name from role where role_status = 'N' and role_type <> 'A' and role_type <> 'B' ";
		if(RoleType.ADMIN.equals(roleType)){
			sql += " and role_type <> 'C' and role_type <> 'L'";
		}else if(RoleType.BOSS.equals(roleType) || RoleType.HR.equals(roleType) || RoleType.EXECUTIVE.equals(roleType)){
			
		}else if(RoleType.LEADER.equals(roleType) || RoleType.COMUSER.equals(roleType)){
			sql += " and role_type <> 'H' and role_type <> 'E' ";
		}else{
			sql += " 1 = 2 ";
		}
		Query query = entityManager.createNativeQuery(sql);
		@SuppressWarnings("unchecked")
		List<Object[]> list = query.getResultList();
		if(list != null){
			for(int i = 0; i < list.size(); i++){
				resultMap.put(String.valueOf((Integer)list.get(i)[0]),(String)list.get(i)[1]);
			}
		}
		return resultMap;
	}

	
}
