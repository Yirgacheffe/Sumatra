package cn.com.nsv.ejb.interfaces;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import cn.com.nsv.ejb.dto.RoleDto;
import cn.com.nsv.ejb.dto.RoleSearchDto;
import cn.com.nsv.ejb.dto.SearchResultDto;

@Local
public interface RoleService {

	public SearchResultDto getRoleList(RoleSearchDto searchDto); 

	public RoleDto assembleDetailById(String processId); 

	public List<String> addRole(RoleDto roleDto); 

	public List<String> editRole(RoleDto roleDto);
	
	public Map<String, String> getRoleSelectItem(String roleType);

}
