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
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

/**
 * OperationLog generated by hbm2java
 */
@Entity
@Table(name = "operation_log", catalog = "nsvims")
public class OperationLog implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer operationLogSn;
    private int projectSn;
    private char operationAction;
    private Date operationTime;
    private String employeeId;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "operation_log_sn", unique = true, nullable = false)
    public Integer getOperationLogSn() {
        return this.operationLogSn;
    }

    public void setOperationLogSn(Integer operationLogSn) {
        this.operationLogSn = operationLogSn;
    }

    @Column(name = "project_sn", nullable = false)
    public int getProjectSn() {
        return this.projectSn;
    }

    public void setProjectSn(int projectSn) {
        this.projectSn = projectSn;
    }

    @Column(name = "operation_action", nullable = false, length = 1)
    public char getOperationAction() {
        return this.operationAction;
    }

    public void setOperationAction(char operationAction) {
        this.operationAction = operationAction;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "operation_time", nullable = false, length = 19)
    @NotNull
    public Date getOperationTime() {
        return this.operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    @Column(name = "employee_id", nullable = false, length = 20)
    @NotNull
    @Length(max = 20)
    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

}
