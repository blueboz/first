package cn.boz.springboot.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "BDF2_EXCEL_MODEL_DETAIL", schema = "ZHSPDEV", catalog = "")
public class Bdf2ExcelModelDetail {
    private String id;
    private Integer excelColumn;
    private String excelModelId;
    private String interceptor;
    private String name;
    private String tableColumn;

    @Id
    @Column(name = "ID_")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "EXCEL_COLUMN_")
    public Integer getExcelColumn() {
        return excelColumn;
    }

    public void setExcelColumn(Integer excelColumn) {
        this.excelColumn = excelColumn;
    }

    @Basic
    @Column(name = "EXCEL_MODEL_ID_")
    public String getExcelModelId() {
        return excelModelId;
    }

    public void setExcelModelId(String excelModelId) {
        this.excelModelId = excelModelId;
    }

    @Basic
    @Column(name = "INTERCEPTOR_")
    public String getInterceptor() {
        return interceptor;
    }

    public void setInterceptor(String interceptor) {
        this.interceptor = interceptor;
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
    @Column(name = "TABLE_COLUMN_")
    public String getTableColumn() {
        return tableColumn;
    }

    public void setTableColumn(String tableColumn) {
        this.tableColumn = tableColumn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bdf2ExcelModelDetail that = (Bdf2ExcelModelDetail) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (excelColumn != null ? !excelColumn.equals(that.excelColumn) : that.excelColumn != null) return false;
        if (excelModelId != null ? !excelModelId.equals(that.excelModelId) : that.excelModelId != null) return false;
        if (interceptor != null ? !interceptor.equals(that.interceptor) : that.interceptor != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (tableColumn != null ? !tableColumn.equals(that.tableColumn) : that.tableColumn != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (excelColumn != null ? excelColumn.hashCode() : 0);
        result = 31 * result + (excelModelId != null ? excelModelId.hashCode() : 0);
        result = 31 * result + (interceptor != null ? interceptor.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (tableColumn != null ? tableColumn.hashCode() : 0);
        return result;
    }
}
