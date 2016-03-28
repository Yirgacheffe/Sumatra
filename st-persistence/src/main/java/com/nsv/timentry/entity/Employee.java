//: com.nsv.timentry.entity: Employee.java
package com.nsv.timentry.entity;

import java.util.Collection;
import java.util.Date;
import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.TemporalType;
import javax.persistence.Temporal;
import javax.persistence.Version;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import com.nsv.timentry.constant.Gender;
import com.nsv.timentry.constant.PoliticalType;


/**
 * Entity class mapping to table 'EMPLOYEES'
 * 
 * @version 1.0.0 $ 2016-03-24 11:58 $
 */
@Entity
@Table( name = "EMPLOYEES" )
public class Employee implements Serializable {

    
    private static final long serialVersionUID = 1L;
    
    private Short   id;
    private String  name;
    private String  email;
    private Date    onBoardDate;
    private Date    probationEndDate;
    private Date    lastWorkingDay;
    
    private String  graduationYear;
    private String  college;
    private String  major;
    private String  position;
    private String  nation;
    
    private boolean isMarried;
    private String  residence;
    private boolean isArgicultural;
    private String  idCardNum;
    private String  archiveFile;
    private String  memo;
    private short   version;
    
    // Special enum type for column 'GENDER' and 'POLITICAL_TYPE
    private Gender                  gender;
    private PoliticalType           politicalType;
    private Department              dept;
    private Collection<Certificate> certificates;
    private HrRole                  hrRole;
    private Diploma                 diploma;
    private Collection<Project>     projects;
    private Collection<Task>        tasks;
    
    
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
    
    @Column( name = "PROBATION_END", nullable = false )
    @NotNull
    @Temporal( TemporalType.DATE )
    public Date getProbationEndDate() {
        return this.probationEndDate;
    }
    
    public void setProbationEndDate( Date probationEndDate ) {
        this.probationEndDate = probationEndDate;
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
    
    @Column( name = "POLITICAL_TYPE", nullable = false, length = 1 )
    @NotNull
    public PoliticalType getPoliticalType() {
        return this.politicalType;
    }
    
    public void setPoliticalType( PoliticalType politicalType ) {
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

    @Column( name = "RESIDENCE_TYPE", nullable = false )
    @NotNull
    public boolean isArgicultural() {
        return this.isArgicultural;
    }
    
    public void setArgicultural( boolean isArgicultural ) {
        this.isArgicultural = isArgicultural;
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
    
    // ------------------------------------------------------------------------
    @OneToMany( mappedBy = "employee", fetch = LAZY )
    public Collection<Certificate> getCertificates() {
        return this.certificates;
    }
    
    public void setCertificates( Collection<Certificate> certificates ) {
        this.certificates = certificates;
    }
    
    @ManyToOne
    @JoinColumn( name = "HR_ROLE_ID", nullable = false )
    public HrRole getHrRole() {
        return this.hrRole;
    }
    
    public void setHrRole( HrRole hrRole ) {
        this.hrRole = hrRole;
    }

    @ManyToOne
    @JoinColumn( name = "DEPT_ID", nullable = false )
    public Department getDept() {
        return this.dept;
    }
    
    public void setDept( Department dept ) {
        this.dept = dept;
    }
    
    @ManyToOne
    @JoinColumn( name = "DIPLOMA_ID", nullable = false )
    public Diploma getDiploma() {
        return this.diploma;
    }
    
    public void setDiploma( Diploma diploma ) {
        this.diploma = diploma;
    }
    
    @ManyToMany( mappedBy = "projMembers" )
    public Collection<Project> getProjects() {
        return this.projects;
    }
    
    public void setProjects( Collection<Project> projects ) {
        this.projects = projects;
    }
    
    @ManyToMany( mappedBy = "taskMembers" )
    public Collection<Task> getTasks() {
        return this.tasks;
    }
    
    public void setTasks( Collection<Task> tasks ) {
        this.tasks = tasks;
    }
    
    
    @Override
    public String toString() {
        return "com.nsv.timentry.persistence.Employee[ id=" + id + " ]";
    }
    
    
} //:~
