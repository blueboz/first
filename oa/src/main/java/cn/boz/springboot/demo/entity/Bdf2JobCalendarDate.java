package cn.boz.springboot.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "BDF2_JOB_CALENDAR_DATE", schema = "ZHSPDEV", catalog = "")
public class Bdf2JobCalendarDate {
    private String id;
    private Timestamp calendarDate;
    private String calendarId;
    private Integer dayOfMonth;
    private Integer dayOfWeek;
    private Integer monthOfYear;
    private String name;

    @Id
    @Column(name = "ID_")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CALENDAR_DATE_")
    public Timestamp getCalendarDate() {
        return calendarDate;
    }

    public void setCalendarDate(Timestamp calendarDate) {
        this.calendarDate = calendarDate;
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
    @Column(name = "DAY_OF_MONTH_")
    public Integer getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    @Basic
    @Column(name = "DAY_OF_WEEK_")
    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Basic
    @Column(name = "MONTH_OF_YEAR_")
    public Integer getMonthOfYear() {
        return monthOfYear;
    }

    public void setMonthOfYear(Integer monthOfYear) {
        this.monthOfYear = monthOfYear;
    }

    @Basic
    @Column(name = "NAME_")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bdf2JobCalendarDate that = (Bdf2JobCalendarDate) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (calendarDate != null ? !calendarDate.equals(that.calendarDate) : that.calendarDate != null) return false;
        if (calendarId != null ? !calendarId.equals(that.calendarId) : that.calendarId != null) return false;
        if (dayOfMonth != null ? !dayOfMonth.equals(that.dayOfMonth) : that.dayOfMonth != null) return false;
        if (dayOfWeek != null ? !dayOfWeek.equals(that.dayOfWeek) : that.dayOfWeek != null) return false;
        if (monthOfYear != null ? !monthOfYear.equals(that.monthOfYear) : that.monthOfYear != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (calendarDate != null ? calendarDate.hashCode() : 0);
        result = 31 * result + (calendarId != null ? calendarId.hashCode() : 0);
        result = 31 * result + (dayOfMonth != null ? dayOfMonth.hashCode() : 0);
        result = 31 * result + (dayOfWeek != null ? dayOfWeek.hashCode() : 0);
        result = 31 * result + (monthOfYear != null ? monthOfYear.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
