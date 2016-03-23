package cn.com.nsv.ejb.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDto {

	private Integer employeeInfoSn;
	private String sysUserEmail;
	private Integer sysUserSn;
	private String sysUserId;
	private String employeeName;
	private String employeeGender;
	private String sysUserStatus;
	private String positionalTitle;
	private String recordMemo;
    private Date entryTime;
    private Date conversionTime;
    private String highestEducation;
    private String yearOfGraduation;
    private String graduateInstitutions;
    private String major;
    private String nation;
    private String maritalStatus;
    private String politicalStatus;
    private String registeredPermanentResidenceDistrict;
    private String registeredPermanentResidenceProperty;
    private String identificationCard;
    private Date lastWorkTime;
    private String personnelFileStatus;
	private String roleName;
	private Integer roleSn;
	private Integer employeeRoleSn;
	private String managerId;
	private String managerName;
	private String roleType;
	private List<CertificateDto> certificateDtoList = new ArrayList<CertificateDto>();

	public Integer getEmployeeInfoSn() {
		return employeeInfoSn;
	}
	public void setEmployeeInfoSn(Integer employeeInfoSn) {
		this.employeeInfoSn = employeeInfoSn;
	}
	public String getSysUserEmail() {
		return sysUserEmail;
	}
	public void setSysUserEmail(String sysUserEmail) {
		this.sysUserEmail = sysUserEmail;
	}
	public Integer getSysUserSn() {
		return sysUserSn;
	}
	public void setSysUserSn(Integer sysUserSn) {
		this.sysUserSn = sysUserSn;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeGender() {
		return employeeGender;
	}
	public void setEmployeeGender(String employeeGender) {
		this.employeeGender = employeeGender;
	}
	public String getSysUserStatus() {
		return sysUserStatus;
	}
	public void setSysUserStatus(String sysUserStatus) {
		this.sysUserStatus = sysUserStatus;
	}
	public String getPositionalTitle() {
		return positionalTitle;
	}
	public void setPositionalTitle(String positionalTitle) {
		this.positionalTitle = positionalTitle;
	}
	public String getRecordMemo() {
		return recordMemo;
	}
	public void setRecordMemo(String recordMemo) {
		this.recordMemo = recordMemo;
	}
	public String getSysUserId() {
		return sysUserId;
	}
	public void setSysUserId(String sysUserId) {
		this.sysUserId = sysUserId;
	}
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	public Date getConversionTime() {
		return conversionTime;
	}
	public void setConversionTime(Date conversionTime) {
		this.conversionTime = conversionTime;
	}
	public String getHighestEducation() {
		return highestEducation;
	}
	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}
	public String getYearOfGraduation() {
		return yearOfGraduation;
	}
	public void setYearOfGraduation(String yearOfGraduation) {
		this.yearOfGraduation = yearOfGraduation;
	}
	public String getGraduateInstitutions() {
		return graduateInstitutions;
	}
	public void setGraduateInstitutions(String graduateInstitutions) {
		this.graduateInstitutions = graduateInstitutions;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getPoliticalStatus() {
		return politicalStatus;
	}
	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}
	public String getRegisteredPermanentResidenceDistrict() {
		return registeredPermanentResidenceDistrict;
	}
	public void setRegisteredPermanentResidenceDistrict(
			String registeredPermanentResidenceDistrict) {
		this.registeredPermanentResidenceDistrict = registeredPermanentResidenceDistrict;
	}
	public String getRegisteredPermanentResidenceProperty() {
		return registeredPermanentResidenceProperty;
	}
	public void setRegisteredPermanentResidenceProperty(
			String registeredPermanentResidenceProperty) {
		this.registeredPermanentResidenceProperty = registeredPermanentResidenceProperty;
	}
	public String getIdentificationCard() {
		return identificationCard;
	}
	public void setIdentificationCard(String identificationCard) {
		this.identificationCard = identificationCard;
	}
	public Date getLastWorkTime() {
		return lastWorkTime;
	}
	public void setLastWorkTime(Date lastWorkTime) {
		this.lastWorkTime = lastWorkTime;
	}
	public String getPersonnelFileStatus() {
		return personnelFileStatus;
	}
	public void setPersonnelFileStatus(String personnelFileStatus) {
		this.personnelFileStatus = personnelFileStatus;
	}
	public List<CertificateDto> getCertificateDtoList() {
		return certificateDtoList;
	}
	public void setCertificateDtoList(List<CertificateDto> certificateDtoList) {
		this.certificateDtoList = certificateDtoList;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public Integer getRoleSn() {
		return roleSn;
	}
	public void setRoleSn(Integer roleSn) {
		this.roleSn = roleSn;
	}
	public Integer getEmployeeRoleSn() {
		return employeeRoleSn;
	}
	public void setEmployeeRoleSn(Integer employeeRoleSn) {
		this.employeeRoleSn = employeeRoleSn;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	
	
}
