package cn.com.nsv.ejb.interfaces;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.Local;

import cn.com.nsv.ejb.dto.ProjectDto;
import cn.com.nsv.ejb.dto.ProjectSearchDto;
import cn.com.nsv.ejb.dto.SearchResultDto;

@Local
public interface ProjectService {
		
	public List<String> addProject(ProjectDto projectDto);
	
	public List<String> editProject(ProjectDto projectDto);
	
	public SearchResultDto getProjectList(ProjectSearchDto searchDto);
	
	public ProjectDto assembleDetailById(String processId);
	
	public Map<String, String> getProjectSelectItem();
	
	public List<String> getProjectListByManagerId(String userId);
	
	public Set<String> getManagerSetByProjectSet(Set<String> projectIdList);
	
	public List<ProjectSearchDto> getByTime(ProjectSearchDto dtoparam);
	
	public List<ProjectSearchDto> getByUser(ProjectSearchDto dtoparam);
	
	public List<ProjectSearchDto> getByUserAndWords(ProjectSearchDto dtoparam);
	
	public Integer updatepro(List<ProjectSearchDto> dto);
	
	public String getProTime(String projectId);
	
}
