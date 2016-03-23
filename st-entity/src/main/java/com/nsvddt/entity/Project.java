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
 * Project generated by hbm2java
 */
@Entity
@Table(name = "project", catalog = "nsvims")
public class Project implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer projectSn;
	private int version;
	private String projectId;
	private String projectName;
	private char projectType;
	private String projectLeaderId;
	private Float expenseBudget;
	private Date projectStartTime;
	private char projectStatus;
	private String memo;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "project_sn", unique = true, nullable = false)
	public Integer getProjectSn() {
		return this.projectSn;
	}

	public void setProjectSn(Integer projectSn) {
		this.projectSn = projectSn;
	}

	@Version
	@Column(name = "version", nullable = false)
	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Column(name = "project_id", nullable = false, length = 50)
	@NotNull
	@Length(max = 50)
	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	@Column(name = "project_name", nullable = false, length = 50)
	@NotNull
	@Length(max = 50)
	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "project_type", nullable = false, length = 1)
	public char getProjectType() {
		return this.projectType;
	}

	public void setProjectType(char projectType) {
		this.projectType = projectType;
	}

	@Column(name = "project_leader_id", length = 20)
	@Length(max = 20)
	public String getProjectLeaderId() {
		return this.projectLeaderId;
	}

	public void setProjectLeaderId(String projectLeaderId) {
		this.projectLeaderId = projectLeaderId;
	}

	@Column(name = "expense_budget", precision = 12, scale = 0)
	public Float getExpenseBudget() {
		return this.expenseBudget;
	}

	public void setExpenseBudget(Float expenseBudget) {
		this.expenseBudget = expenseBudget;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "project_start_time", nullable = false, length = 19)
	@NotNull
	public Date getProjectStartTime() {
		return this.projectStartTime;
	}

	public void setProjectStartTime(Date projectStartTime) {
		this.projectStartTime = projectStartTime;
	}

	@Column(name = "project_status", nullable = false, length = 1)
	public char getProjectStatus() {
		return this.projectStatus;
	}

	public void setProjectStatus(char projectStatus) {
		this.projectStatus = projectStatus;
	}

	@Column(name = "memo", length = 500)
	@Length(max = 500)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
