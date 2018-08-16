package cn.boz.springboot.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "BDF2_UREPORT_PARAMETER", schema = "ZHSPDEV", catalog = "")
public class Bdf2UreportParameter {
    private String id;
    private String name;
    private String reportDefinitionId;
    private String value;

    @Id
    @Column(name = "ID_")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    @Column(name = "REPORT_DEFINITION_ID_")
    public String getReportDefinitionId() {
        return reportDefinitionId;
    }

    public void setReportDefinitionId(String reportDefinitionId) {
        this.reportDefinitionId = reportDefinitionId;
    }

    @Basic
    @Column(name = "VALUE_")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bdf2UreportParameter that = (Bdf2UreportParameter) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (reportDefinitionId != null ? !reportDefinitionId.equals(that.reportDefinitionId) : that.reportDefinitionId != null)
            return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (reportDefinitionId != null ? reportDefinitionId.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
