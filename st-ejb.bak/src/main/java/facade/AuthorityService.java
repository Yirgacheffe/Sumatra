package cn.com.nsv.ejb.interfaces;

import java.util.List;

import javax.ejb.Local;

import cn.com.nsv.ejb.dto.AuthorityDto;
import cn.com.nsv.ejb.dto.AuthoritySearchDto;
import cn.com.nsv.ejb.dto.CurUserDto;
import cn.com.nsv.ejb.dto.FunctionDto;
import cn.com.nsv.ejb.dto.SearchResultDto;

@Local
public interface AuthorityService {
	
	public CurUserDto login(String userEmail, String userPassword);
	
	public List<FunctionDto> getMenu(Integer sysUserSN); 
	
	public List<FunctionDto> getAllMenu();
	
	public String resetPassword(String userEmail,String oldPw,String newPw);
	
	public SearchResultDto getAuthoritiyMgmtList(AuthoritySearchDto searchDto);
	
	public AuthorityDto getAuthorityDetail(Integer roleSN);
	
	public void editAuthority(AuthorityDto authorityDto);
	
	public String getMd5Password(String email);
	
	public String resetDefultPassword(String email, String checkWords); 

}
