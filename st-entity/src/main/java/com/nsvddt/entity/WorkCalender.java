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
 * WorkCalender generated by hbm2java
 */
@Entity
@Table(name = "work_calender", catalog = "nsvims")
public class WorkCalender implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer workCalenderSn;
    private int version;
    private String workYearMonth;
    private Date workDate;
    private char dateType;
    private Float workHour;
    private String dateMemo;
    private Integer workWeek;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "work_calender_sn", unique = true, nullable = false)
    public Integer getWorkCalenderSn() {
        return this.workCalenderSn;
    }

    public void setWorkCalenderSn(Integer workCalenderSn) {
        this.workCalenderSn = workCalenderSn;
    }

    @Version
    @Column(name = "version", nullable = false)
    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name="work_year_month", nullable=false, length=9)
    @NotNull
    @Length(max=9)
    public String getWorkYearMonth() {
        return this.workYearMonth;
    }
    
    public void setWorkYearMonth(String workYearMonth) {
        this.workYearMonth = workYearMonth;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="work_date", nullable=false, length=19)
    @NotNull
    public Date getWorkDate() {
        return this.workDate;
    }
    
    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    @Column(name = "date_type", nullable = false, length = 1)
    public char getDateType() {
        return this.dateType;
    }

    public void setDateType(char dateType) {
        this.dateType = dateType;
    }

    @Column(name = "work_hour", precision = 12, scale = 0)
    public Float getWorkHour() {
        return this.workHour;
    }

    public void setWorkHour(Float workHour) {
        this.workHour = workHour;
    }

    @Column(name = "date_memo", length = 500)
    @Length(max = 500)
    public String getDateMemo() {
        return this.dateMemo;
    }

    public void setDateMemo(String dateMemo) {
        this.dateMemo = dateMemo;
    }
    
    @Column(name = "work_week", nullable = false)
    @NotNull
	public Integer getWorkWeek() {
		return workWeek;
	}

	public void setWorkWeek(Integer workWeek) {
		this.workWeek = workWeek;
	}
    
    

}
