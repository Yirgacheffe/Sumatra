/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nsv.timentry.old;

import com.nsv.timentry.entity.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author woodpecker
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id"),
    @NamedQuery(name = "Employee.findByName", query = "SELECT e FROM Employee e WHERE e.name = :name"),
    @NamedQuery(name = "Employee.findByGender", query = "SELECT e FROM Employee e WHERE e.gender = :gender"),
    @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email"),
    @NamedQuery(name = "Employee.findByOnBoardDate", query = "SELECT e FROM Employee e WHERE e.onBoardDate = :onBoardDate"),
    @NamedQuery(name = "Employee.findByDeptId", query = "SELECT e FROM Employee e WHERE e.deptId = :deptId"),
    @NamedQuery(name = "Employee.findByProbationEnd", query = "SELECT e FROM Employee e WHERE e.probationEnd = :probationEnd"),
    @NamedQuery(name = "Employee.findByDiplomaId", query = "SELECT e FROM Employee e WHERE e.diplomaId = :diplomaId"),
    @NamedQuery(name = "Employee.findByGraduationYr", query = "SELECT e FROM Employee e WHERE e.graduationYr = :graduationYr"),
    @NamedQuery(name = "Employee.findByCollege", query = "SELECT e FROM Employee e WHERE e.college = :college"),
    @NamedQuery(name = "Employee.findByMajor", query = "SELECT e FROM Employee e WHERE e.major = :major"),
    @NamedQuery(name = "Employee.findByPosition", query = "SELECT e FROM Employee e WHERE e.position = :position"),
    @NamedQuery(name = "Employee.findByNation", query = "SELECT e FROM Employee e WHERE e.nation = :nation"),
    @NamedQuery(name = "Employee.findByIsMarried", query = "SELECT e FROM Employee e WHERE e.isMarried = :isMarried"),
    @NamedQuery(name = "Employee.findByPoliticalType", query = "SELECT e FROM Employee e WHERE e.politicalType = :politicalType"),
    @NamedQuery(name = "Employee.findByResidence", query = "SELECT e FROM Employee e WHERE e.residence = :residence"),
    @NamedQuery(name = "Employee.findByResidenceType", query = "SELECT e FROM Employee e WHERE e.residenceType = :residenceType"),
    @NamedQuery(name = "Employee.findByIdcardNum", query = "SELECT e FROM Employee e WHERE e.idcardNum = :idcardNum"),
    @NamedQuery(name = "Employee.findByLastWorkingDay", query = "SELECT e FROM Employee e WHERE e.lastWorkingDay = :lastWorkingDay"),
    @NamedQuery(name = "Employee.findByArchiveFile", query = "SELECT e FROM Employee e WHERE e.archiveFile = :archiveFile"),
    @NamedQuery(name = "Employee.findByMemo", query = "SELECT e FROM Employee e WHERE e.memo = :memo"),
    @NamedQuery(name = "Employee.findByVersion", query = "SELECT e FROM Employee e WHERE e.version = :version")})
public class EmployeeBak implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "GENDER")
    private String gender;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ON_BOARD_DATE")
    @Temporal(TemporalType.DATE)
    private Date onBoardDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEPT_ID")
    private short deptId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROBATION_END")
    @Temporal(TemporalType.DATE)
    private Date probationEnd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DIPLOMA_ID")
    private short diplomaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "GRADUATION_YR")
    private String graduationYr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "COLLEGE")
    private String college;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "MAJOR")
    private String major;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "POSITION")
    private String position;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NATION")
    private String nation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_MARRIED")
    private boolean isMarried;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "POLITICAL_TYPE")
    private String politicalType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "RESIDENCE")
    private String residence;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "RESIDENCE_TYPE")
    private String residenceType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "IDCARD_NUM")
    private String idcardNum;
    @Column(name = "LAST_WORKING_DAY")
    @Temporal(TemporalType.DATE)
    private Date lastWorkingDay;
    @Size(max = 150)
    @Column(name = "ARCHIVE_FILE")
    private String archiveFile;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "MEMO")
    private String memo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VERSION")
    private short version;

    public EmployeeBak() {
    }

    public EmployeeBak(Short id) {
        this.id = id;
    }

    public EmployeeBak(Short id, String name, String gender, String email, Date onBoardDate, short deptId, Date probationEnd, short diplomaId, String graduationYr, String college, String major, String position, String nation, boolean isMarried, String politicalType, String residence, String residenceType, String idcardNum, String memo, short version) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.onBoardDate = onBoardDate;
        this.deptId = deptId;
        this.probationEnd = probationEnd;
        this.diplomaId = diplomaId;
        this.graduationYr = graduationYr;
        this.college = college;
        this.major = major;
        this.position = position;
        this.nation = nation;
        this.isMarried = isMarried;
        this.politicalType = politicalType;
        this.residence = residence;
        this.residenceType = residenceType;
        this.idcardNum = idcardNum;
        this.memo = memo;
        this.version = version;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getOnBoardDate() {
        return onBoardDate;
    }

    public void setOnBoardDate(Date onBoardDate) {
        this.onBoardDate = onBoardDate;
    }

    public short getDeptId() {
        return deptId;
    }

    public void setDeptId(short deptId) {
        this.deptId = deptId;
    }

    public Date getProbationEnd() {
        return probationEnd;
    }

    public void setProbationEnd(Date probationEnd) {
        this.probationEnd = probationEnd;
    }

    public short getDiplomaId() {
        return diplomaId;
    }

    public void setDiplomaId(short diplomaId) {
        this.diplomaId = diplomaId;
    }

    public String getGraduationYr() {
        return graduationYr;
    }

    public void setGraduationYr(String graduationYr) {
        this.graduationYr = graduationYr;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public boolean getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(boolean isMarried) {
        this.isMarried = isMarried;
    }

    public String getPoliticalType() {
        return politicalType;
    }

    public void setPoliticalType(String politicalType) {
        this.politicalType = politicalType;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getResidenceType() {
        return residenceType;
    }

    public void setResidenceType(String residenceType) {
        this.residenceType = residenceType;
    }

    public String getIdcardNum() {
        return idcardNum;
    }

    public void setIdcardNum(String idcardNum) {
        this.idcardNum = idcardNum;
    }

    public Date getLastWorkingDay() {
        return lastWorkingDay;
    }

    public void setLastWorkingDay(Date lastWorkingDay) {
        this.lastWorkingDay = lastWorkingDay;
    }

    public String getArchiveFile() {
        return archiveFile;
    }

    public void setArchiveFile(String archiveFile) {
        this.archiveFile = archiveFile;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public short getVersion() {
        return version;
    }

    public void setVersion(short version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeBak)) {
            return false;
        }
        EmployeeBak other = (EmployeeBak) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.Employee[ id=" + id + " ]";
    }
    
}
