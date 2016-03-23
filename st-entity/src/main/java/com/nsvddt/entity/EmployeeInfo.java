package cn.com.nsv.ejb.entity;

// Generated 2014-3-19 10:42:29 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * EmployeeInfo generated by hbm2java
 */
@Entity
@Table(name = "employee_info", catalog = "nsvims")
public class EmployeeInfo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer employeeInfoSn;
	    private int version;
	    private int sysUserSn;
	    private char employeeGender;
	    private Date entryTime;
	    private Date conversionTime;
	    private String highestEducation;
	    private String yearOfGraduation;
	    private String graduateInstitutions;
	    private String major;
	    private String positionalTitle;
	    private String nation;
	    private char maritalStatus;
	    private String politicalStatus;
	    private String registeredPermanentResidenceDistrict;
	    private char registeredPermanentResidenceProperty;
	    private String identificationCard;
	    private Date lastWorkTime;
	    private String personnelFileStatus;
	    private String recordMemo;

	    @Id
	    @GeneratedValue(strategy = IDENTITY)
	    @Column(name = "employee_info_sn", unique = true, nullable = false)
	    public Integer getEmployeeInfoSn() {
	        return this.employeeInfoSn;
	    }

	    public void setEmployeeInfoSn(Integer employeeInfoSn) {
	        this.employeeInfoSn = employeeInfoSn;
	    }

	    @Version
	    @Column(name = "version", nullable = false)
	    public int getVersion() {
	        return this.version;
	    }

	    public void setVersion(int version) {
	        this.version = version;
	    }

	    @Column(name = "sys_user_sn", nullable = false)
	    public int getSysUserSn() {
	        return this.sysUserSn;
	    }

	    public void setSysUserSn(int sysUserSn) {
	        this.sysUserSn = sysUserSn;
	    }

	    @Column(name = "employee_gender", nullable = false, length = 1)
	    public char getEmployeeGender() {
	        return this.employeeGender;
	    }

	    public void setEmployeeGender(char employeeGender) {
	        this.employeeGender = employeeGender;
	    }

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "entry_time", nullable = false, length = 19)
	    @NotNull
	    public Date getEntryTime() {
	        return this.entryTime;
	    }

	    public void setEntryTime(Date entryTime) {
	        this.entryTime = entryTime;
	    }

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "conversion_time", length = 19)
	    public Date getConversionTime() {
	        return this.conversionTime;
	    }

	    public void setConversionTime(Date conversionTime) {
	        this.conversionTime = conversionTime;
	    }

	    @Column(name = "highest_education", nullable = false, length = 50)
	    @NotNull
	    @Length(max = 50)
	    public String getHighestEducation() {
	        return this.highestEducation;
	    }

	    public void setHighestEducation(String highestEducation) {
	        this.highestEducation = highestEducation;
	    }

	    @Column(name = "year_of_graduation", length = 7)
	    @Length(max = 7)
	    public String getYearOfGraduation() {
	        return this.yearOfGraduation;
	    }

	    public void setYearOfGraduation(String yearOfGraduation) {
	        this.yearOfGraduation = yearOfGraduation;
	    }

	    @Column(name = "graduate_institutions", length = 500)
	    @Length(max = 500)
	    public String getGraduateInstitutions() {
	        return this.graduateInstitutions;
	    }

	    public void setGraduateInstitutions(String graduateInstitutions) {
	        this.graduateInstitutions = graduateInstitutions;
	    }

	    @Column(name = "major", length = 500)
	    @Length(max = 500)
	    public String getMajor() {
	        return this.major;
	    }

	    public void setMajor(String major) {
	        this.major = major;
	    }

	    @Column(name = "positional_title", length = 500)
	    @Length(max = 500)
	    public String getPositionalTitle() {
	        return this.positionalTitle;
	    }

	    public void setPositionalTitle(String positionalTitle) {
	        this.positionalTitle = positionalTitle;
	    }

	    @Column(name = "nation", nullable = false, length = 10)
	    @NotNull
	    @Length(max = 10)
	    public String getNation() {
	        return this.nation;
	    }

	    public void setNation(String nation) {
	        this.nation = nation;
	    }

	    @Column(name = "marital_status", nullable = false, length = 1)
	    public char getMaritalStatus() {
	        return this.maritalStatus;
	    }

	    public void setMaritalStatus(char maritalStatus) {
	        this.maritalStatus = maritalStatus;
	    }

	    @Column(name = "political_status", nullable = false, length = 20)
	    @NotNull
	    @Length(max = 20)
	    public String getPoliticalStatus() {
	        return this.politicalStatus;
	    }

	    public void setPoliticalStatus(String politicalStatus) {
	        this.politicalStatus = politicalStatus;
	    }

	    @Column(name = "registered_permanent_residence_district", nullable = false, length = 500)
	    @NotNull
	    @Length(max = 500)
	    public String getRegisteredPermanentResidenceDistrict() {
	        return this.registeredPermanentResidenceDistrict;
	    }

	    public void setRegisteredPermanentResidenceDistrict(String registeredPermanentResidenceDistrict) {
	        this.registeredPermanentResidenceDistrict = registeredPermanentResidenceDistrict;
	    }

	    @Column(name = "registered_permanent_residence_property", nullable = false, length = 1)
	    public char getRegisteredPermanentResidenceProperty() {
	        return this.registeredPermanentResidenceProperty;
	    }

	    public void setRegisteredPermanentResidenceProperty(char registeredPermanentResidenceProperty) {
	        this.registeredPermanentResidenceProperty = registeredPermanentResidenceProperty;
	    }

	    @Column(name = "identification_card", nullable = false, length = 20)
	    @NotNull
	    @Length(max = 20)
	    public String getIdentificationCard() {
	        return this.identificationCard;
	    }

	    public void setIdentificationCard(String identificationCard) {
	        this.identificationCard = identificationCard;
	    }

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "last_work_time", length = 19)
	    public Date getLastWorkTime() {
	        return this.lastWorkTime;
	    }

	    public void setLastWorkTime(Date lastWorkTime) {
	        this.lastWorkTime = lastWorkTime;
	    }

	    @Column(name = "personnel_file_status", length = 500)
	    @Length(max = 500)
	    public String getPersonnelFileStatus() {
	        return this.personnelFileStatus;
	    }

	    public void setPersonnelFileStatus(String personnelFileStatus) {
	        this.personnelFileStatus = personnelFileStatus;
	    }

	    @Column(name = "record_memo", length = 500)
	    @Length(max = 500)
	    public String getRecordMemo() {
	        return this.recordMemo;
	    }

	    public void setRecordMemo(String recordMemo) {
	        this.recordMemo = recordMemo;
	    }

}
