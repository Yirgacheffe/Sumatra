package cn.com.nsv.ejb.interfaces;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.Local;

import cn.com.nsv.ejb.dto.EmployeeDto;
import cn.com.nsv.ejb.dto.EmployeeSearchDto;
import cn.com.nsv.ejb.dto.SearchResultDto;

@Local
public interface EmployeeService {
	
	Map<String, String> getEmployeeSelectItem(boolean active, String employeeId); 
	
	public List<String> addEmployee(EmployeeDto employeeDto);
	
	public List<String> editEmployee(EmployeeDto employeeDto);
	
	public SearchResultDto getEmployeeList(EmployeeSearchDto searchDto);
	
	public EmployeeDto assembleDetailById(String processId);
	
	public Set<String> getSubEmployeeList(String employeeId); 
	

}
