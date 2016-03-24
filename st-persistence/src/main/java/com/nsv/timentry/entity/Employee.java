//: com.nsv.timentry.entity: Employee.java
package com.nsv.timentry.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.Version;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.FetchType.LAZY;


/**
 * Entity class mapping to table 'EMPLOYEE'
 * 
 * @version 1.0.0 $ 2016-03-24 11:58 $
 */
@Entity
@Table( name = "EMPLOYEE" )
public class Employee implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    private Short   id;
    private String  name;
    private Gender  gender;
    private String  email;
    private Date    onBoardDate;
    private Date    probationEndDate;
    private short   deptId;
    private short   diplomaId;
    private Date    lastWorkingDay;
    
    private String  graduationYear;
    private String  college;
    private String  major;
    private String  position;
    private String  nation;
    
    private boolean isMarried;
    
    private String  politicalType;
    private String  residence;
    private String  residenceType;
    private String  idCardNum;
    private String  archiveFile;
    private String  memo;
    private short   version;

    
    // ------------------------------------------------------------------------
    @Id
    @GeneratedValue( strategy = IDENTITY )
    @Column( name = "ID" )
    public Short getId() {
        return this.id;
    }
    
    public void setId( Short id ) {
        this.id = id;
    }
    
    @Column( name = "NAME", nullable = false, length = 50 )
    @NotNull
    @Size( min = 1, max = 50 )
    public String getName() {
        return this.name;
    }
    
    public void setName( String name ) {
        this.name = name;
    }
    
    @Column( name = "GENDER", nullable = false, length = 1 )
    public Gender getGender() {
        return this.gender;
    }
    
    public void setGender( Gender gender ) {
        this.gender = gender;
    }
    
    @Column( name = "EMAIL", nullable = false, length = 50 )
    @NotNull
    @Size( min = 1, max = 50 )
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail( String email ) {
        this.email = email;
    }
    
    @Column( name = "ON_BOARD_DATE", nullable = false )
    @NotNull
    @Temporal( TemporalType.DATE )
    public Date getOnBoardDate() {
        return this.onBoardDate;
    }
    
    public void setOnBoardDate( Date onBoardDate ) {
        this.onBoardDate = onBoardDate;
    }
    
    @Column( name = "DEPT_ID", nullable = false )
    @NotNull
    public short getDeptId() {
        return this.deptId;
    }
    
    public void setDeptId( short deptId ) {
        this.deptId = deptId;
    }
    
    @Column( name = "PROBATION_END", nullable = false )
    @NotNull
    @Temporal( TemporalType.DATE )
    public Date getProbationEndDate() {
        return this.probationEndDate;
    }
    
    public void setProbationEndDate( Date probationEndDate ) {
        this.probationEndDate = probationEndDate;
    }
    
    @Column( name = "DIPLOMA_ID", nullable = false )
    @NotNull
    public short getDiplomaId() {
        return this.diplomaId;
    }
    
    public void setDiplomaId( short diplomaId ) {
        this.diplomaId = diplomaId;
    }
    
    @Column( name = "GRADUATION_YR", nullable = false, length = 4 )
    @NotNull
    @Size( min = 1, max = 4 )
    public String getGraduationYear() {
        return this.graduationYear;
    }
    
    public void setGraduationYear( String graduationYear ) {
        this.graduationYear = graduationYear;
    }

    @Column( name = "COLLEGE", nullable = false, length = 100 )
    @NotNull
    @Size( min = 1, max = 100 )
    public String getCollege() {
        return this.college;
    }
    
    public void setCollege( String college ) {
        this.college = college;
    }

    @Column( name = "MAJOR", nullable = false, length = 150 )
    @NotNull
    @Size( min = 1, max = 150 )
    public String getMajor() {
        return this.major;
    }
    
    public void setMajor( String major ) {
        this.major = major;
    }
    
    @Column( name = "POSITION", nullable = false, length = 100 )
    @NotNull
    @Size( min = 1, max = 100 )
    public String getPosition() {
        return this.position;
    }
    
    public void setPosition( String position ) {
        this.position = position;
    }
    
    @Column( name = "NATION", nullable = false, length = 10 )
    @NotNull
    @Size( min = 1, max = 10 )
    public String getNation() {
        return this.nation;
    }
    
    public void setNation( String nation ) {
        this.nation = nation;
    }
    
    @Column( name = "IS_MARRIED", nullable = false )
    @NotNull
    public boolean isMarried() {
        return this.isMarried;
    }
    
    public void setMarried( boolean isMarried ) {
        this.isMarried = isMarried;
    }
    
    @Column( name = "POLITICAL_TYPE", nullable = false, length = 2 )
    @NotNull
    @Size( min = 1, max = 2 )
    public String getPoliticalType() {
        return this.politicalType;
    }
    
    public void setPoliticalType( String politicalType ) {
        this.politicalType = politicalType;
    }

    @Column( name = "RESIDENCE", nullable = false, length = 200 )
    @NotNull
    @Size( min = 1, max = 200 )
    public String getResidence() {
        return this.residence;
    }
    
    public void setResidence( String residence ) {
        this.residence = residence;
    }

    @Column( name = "RESIDENCE_TYPE", nullable = false, length = 2 )
    @NotNull
    @Size( min = 1, max = 2 )
    public String getResidenceType() {
        return this.residenceType;
    }
    
    public void setResidenceType( String residenceType ) {
        this.residenceType = residenceType;
    }

    @Column( name = "IDCARD_NUM", nullable = false, length = 18 )
    @NotNull
    @Size( min = 1, max = 18 )
    public String getIdCardNum() {
        return this.idCardNum;
    }
    
    public void setIdCardNum( String idCardNum ) {
        this.idCardNum = idCardNum;
    }
    
    @Column( name = "LAST_WORKING_DAY", nullable = true )
    @Temporal( TemporalType.DATE )
    public Date getLastWorkingDay() {
        return this.lastWorkingDay;
    }
    
    public void setLastWorkingDay( Date lastWorkingDay ) {
        this.lastWorkingDay = lastWorkingDay;
    }
    
    @Column( name = "ARCHIVE_FILE", nullable = true, length = 150 )
    @Size( max = 150 )
    public String getArchiveFile() {
        return this.archiveFile;
    }
    
    public void setArchiveFile( String archiveFile ) {
        this.archiveFile = archiveFile;
    }
    
    @Column( name = "MEMO", nullable = true, length = 150 )
    @Size( max = 150 )
    @Basic( fetch = LAZY )
    public String getMemo() {
        return this.memo;
    }
    
    public void setMemo( String memo ) {
        this.memo = memo;
    }
    
    @Column( name = "VERSION", nullable = false )
    @NotNull
    @Version
    public short getVersion() {
        return this.version;
    }
    
    public void setVersion( short version ) {
        this.version = version;
    }
    
    
    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.Employee[ id=" + id + " ]";
    }
    
    
} //:~
