package cn.com.nsv.ejb.entity;

// Generated 2014-3-19 10:42:29 by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * SysUser generated by hbm2java
 */
@Entity
@Table(name = "sys_user", catalog = "nsvims")
public class SysUser implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer sysUserSn;
    private int version;
    private int employeeInfoSn;
    private String sysUserId;
    private String managerId;
    private String sysUserEmail;
    private String password;
    private String employeeName;
    private float workTimeStatistics;
    private char sysUserStatus;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "sys_user_sn", unique = true, nullable = false)
    public Integer getSysUserSn() {
        return this.sysUserSn;
    }

    public void setSysUserSn(Integer sysUserSn) {
        this.sysUserSn = sysUserSn;
    }

    @Version
    @Column(name = "version", nullable = false)
    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "employee_info_sn", nullable = false)
    public int getEmployeeInfoSn() {
        return this.employeeInfoSn;
    }

    public void setEmployeeInfoSn(int employeeInfoSn) {
        this.employeeInfoSn = employeeInfoSn;
    }

    @Column(name = "sys_user_id", nullable = false, length = 20)
    @NotNull
    @Length(max = 20)
    public String getSysUserId() {
        return this.sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }
    
    @Column(name = "manager_id", length = 20)
    @Length(max = 20)
    public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	@Column(name = "sys_user_email", nullable = false, length = 50)
    @NotNull
    @Length(max = 50)
    public String getSysUserEmail() {
        return this.sysUserEmail;
    }

    public void setSysUserEmail(String sysUserEmail) {
        this.sysUserEmail = sysUserEmail;
    }

    @Column(name = "password", nullable = false, length = 50)
    @NotNull
    @Length(max = 50)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(name = "employee_name", nullable = false, length = 50)
    @NotNull
    @Length(max = 50)
    public String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Column(name = "work_time_statistics", nullable = false, precision = 12, scale = 0)
    public float getWorkTimeStatistics() {
        return this.workTimeStatistics;
    }

    public void setWorkTimeStatistics(float workTimeStatistics) {
        this.workTimeStatistics = workTimeStatistics;
    }

    @Column(name = "sys_user_status", nullable = false, length = 1)
    public char getSysUserStatus() {
        return this.sysUserStatus;
    }

    public void setSysUserStatus(char sysUserStatus) {
        this.sysUserStatus = sysUserStatus;
    }

}
