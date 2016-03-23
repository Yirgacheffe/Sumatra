package cn.com.nsv.ejb.dto;


public class CertificateDto {

    private Integer employeeCertificateSn;
    private String certificateName;
    private String issuingAuthority;
    private Integer employeeSN;
    private String gentTime;

public Integer getEmployeeCertificateSn() {
	return employeeCertificateSn;
}
public void setEmployeeCertificateSn(Integer employeeCertificateSn) {
	this.employeeCertificateSn = employeeCertificateSn;
}
public String getCertificateName() {
	return certificateName;
}
public void setCertificateName(String certificateName) {
	this.certificateName = certificateName;
}
public String getIssuingAuthority() {
	return issuingAuthority;
}
public void setIssuingAuthority(String issuingAuthority) {
	this.issuingAuthority = issuingAuthority;
}
public String getGentTime() {
	return gentTime;
}
public void setGentTime(String gentTime) {
	this.gentTime = gentTime;
}
public Integer getEmployeeSN() {
	return employeeSN;
}
public void setEmployeeSN(Integer employeeSN) {
	this.employeeSN = employeeSN;
}


}