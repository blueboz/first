package cn.boz.springboot.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "BDF2_JOB", schema = "ZHSPDEV", catalog = "")
public class Bdf2Job {
    private String id;
    private String beanId;
    private String companyId;
    private String cronExpression;
    private String desc;
    private Timestamp endDate;
    private String name;
    private Timestamp startDate;
    private String state;

    @Id
    @Column(name = "ID_")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "BEAN_ID_")
    public String getBeanId() {
        return beanId;
    }

    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }

    @Basic
    @Column(name = "COMPANY_ID_")
    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "CRON_EXPRESSION_")
    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    @Basic
    @Column(name = "DESC_")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @Column(name = "END_DATE")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "NAME_")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "START_DATE")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "STATE_")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bdf2Job bdf2Job = (Bdf2Job) o;

        if (id != null ? !id.equals(bdf2Job.id) : bdf2Job.id != null) return false;
        if (beanId != null ? !beanId.equals(bdf2Job.beanId) : bdf2Job.beanId != null) return false;
        if (companyId != null ? !companyId.equals(bdf2Job.companyId) : bdf2Job.companyId != null) return false;
        if (cronExpression != null ? !cronExpression.equals(bdf2Job.cronExpression) : bdf2Job.cronExpression != null)
            return false;
        if (desc != null ? !desc.equals(bdf2Job.desc) : bdf2Job.desc != null) return false;
        if (endDate != null ? !endDate.equals(bdf2Job.endDate) : bdf2Job.endDate != null) return false;
        if (name != null ? !name.equals(bdf2Job.name) : bdf2Job.name != null) return false;
        if (startDate != null ? !startDate.equals(bdf2Job.startDate) : bdf2Job.startDate != null) return false;
        if (state != null ? !state.equals(bdf2Job.state) : bdf2Job.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (beanId != null ? beanId.hashCode() : 0);
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (cronExpression != null ? cronExpression.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
