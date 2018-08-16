package cn.boz.springboot.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "BDF2_JOB_CALENDAR_RELATION", schema = "ZHSPDEV", catalog = "")
public class Bdf2JobCalendarRelation {
    private String id;
    private String calendarId;
    private String jobId;

    @Id
    @Column(name = "ID_")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CALENDAR_ID_")
    public String getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(String calendarId) {
        this.calendarId = calendarId;
    }

    @Basic
    @Column(name = "JOB_ID_")
    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bdf2JobCalendarRelation that = (Bdf2JobCalendarRelation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (calendarId != null ? !calendarId.equals(that.calendarId) : that.calendarId != null) return false;
        if (jobId != null ? !jobId.equals(that.jobId) : that.jobId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (calendarId != null ? calendarId.hashCode() : 0);
        result = 31 * result + (jobId != null ? jobId.hashCode() : 0);
        return result;
    }
}
