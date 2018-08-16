package cn.boz.springboot.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "BDF2_EXCEL_MODEL", schema = "ZHSPDEV", catalog = "")
public class Bdf2ExcelModel {
    private String id;
    private String comment;
    private String companyid;
    private Timestamp createDate;
    private String datasourceName;
    private String dbType;
    private Integer endColumn;
    private Integer endRow;
    private String excelSheetName;
    private String helpDoc;
    private String name;
    private String primarykey;
    private String primarykeyType;
    private String processor;
    private String sequenceName;
    private Integer startColumn;
    private Integer startRow;
    private String tableLabel;
    private String tabelName;

    @Id
    @Column(name = "ID_")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "COMMENT_")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "COMPANYID_")
    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    @Basic
    @Column(name = "CREATE_DATE_")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "DATASOURCE_NAME_")
    public String getDatasourceName() {
        return datasourceName;
    }

    public void setDatasourceName(String datasourceName) {
        this.datasourceName = datasourceName;
    }

    @Basic
    @Column(name = "DB_TYPE_")
    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    @Basic
    @Column(name = "END_COLUMN_")
    public Integer getEndColumn() {
        return endColumn;
    }

    public void setEndColumn(Integer endColumn) {
        this.endColumn = endColumn;
    }

    @Basic
    @Column(name = "END_ROW_")
    public Integer getEndRow() {
        return endRow;
    }

    public void setEndRow(Integer endRow) {
        this.endRow = endRow;
    }

    @Basic
    @Column(name = "EXCEL_SHEET_NAME_")
    public String getExcelSheetName() {
        return excelSheetName;
    }

    public void setExcelSheetName(String excelSheetName) {
        this.excelSheetName = excelSheetName;
    }

    @Basic
    @Column(name = "HELP_DOC_")
    public String getHelpDoc() {
        return helpDoc;
    }

    public void setHelpDoc(String helpDoc) {
        this.helpDoc = helpDoc;
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
    @Column(name = "PRIMARYKEY_")
    public String getPrimarykey() {
        return primarykey;
    }

    public void setPrimarykey(String primarykey) {
        this.primarykey = primarykey;
    }

    @Basic
    @Column(name = "PRIMARYKEY_TYPE_")
    public String getPrimarykeyType() {
        return primarykeyType;
    }

    public void setPrimarykeyType(String primarykeyType) {
        this.primarykeyType = primarykeyType;
    }

    @Basic
    @Column(name = "PROCESSOR_")
    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    @Basic
    @Column(name = "SEQUENCE_NAME_")
    public String getSequenceName() {
        return sequenceName;
    }

    public void setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName;
    }

    @Basic
    @Column(name = "START_COLUMN_")
    public Integer getStartColumn() {
        return startColumn;
    }

    public void setStartColumn(Integer startColumn) {
        this.startColumn = startColumn;
    }

    @Basic
    @Column(name = "START_ROW_")
    public Integer getStartRow() {
        return startRow;
    }

    public void setStartRow(Integer startRow) {
        this.startRow = startRow;
    }

    @Basic
    @Column(name = "TABLE_LABEL_")
    public String getTableLabel() {
        return tableLabel;
    }

    public void setTableLabel(String tableLabel) {
        this.tableLabel = tableLabel;
    }

    @Basic
    @Column(name = "TABEL_NAME_")
    public String getTabelName() {
        return tabelName;
    }

    public void setTabelName(String tabelName) {
        this.tabelName = tabelName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bdf2ExcelModel that = (Bdf2ExcelModel) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (companyid != null ? !companyid.equals(that.companyid) : that.companyid != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (datasourceName != null ? !datasourceName.equals(that.datasourceName) : that.datasourceName != null)
            return false;
        if (dbType != null ? !dbType.equals(that.dbType) : that.dbType != null) return false;
        if (endColumn != null ? !endColumn.equals(that.endColumn) : that.endColumn != null) return false;
        if (endRow != null ? !endRow.equals(that.endRow) : that.endRow != null) return false;
        if (excelSheetName != null ? !excelSheetName.equals(that.excelSheetName) : that.excelSheetName != null)
            return false;
        if (helpDoc != null ? !helpDoc.equals(that.helpDoc) : that.helpDoc != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (primarykey != null ? !primarykey.equals(that.primarykey) : that.primarykey != null) return false;
        if (primarykeyType != null ? !primarykeyType.equals(that.primarykeyType) : that.primarykeyType != null)
            return false;
        if (processor != null ? !processor.equals(that.processor) : that.processor != null) return false;
        if (sequenceName != null ? !sequenceName.equals(that.sequenceName) : that.sequenceName != null) return false;
        if (startColumn != null ? !startColumn.equals(that.startColumn) : that.startColumn != null) return false;
        if (startRow != null ? !startRow.equals(that.startRow) : that.startRow != null) return false;
        if (tableLabel != null ? !tableLabel.equals(that.tableLabel) : that.tableLabel != null) return false;
        if (tabelName != null ? !tabelName.equals(that.tabelName) : that.tabelName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (companyid != null ? companyid.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (datasourceName != null ? datasourceName.hashCode() : 0);
        result = 31 * result + (dbType != null ? dbType.hashCode() : 0);
        result = 31 * result + (endColumn != null ? endColumn.hashCode() : 0);
        result = 31 * result + (endRow != null ? endRow.hashCode() : 0);
        result = 31 * result + (excelSheetName != null ? excelSheetName.hashCode() : 0);
        result = 31 * result + (helpDoc != null ? helpDoc.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (primarykey != null ? primarykey.hashCode() : 0);
        result = 31 * result + (primarykeyType != null ? primarykeyType.hashCode() : 0);
        result = 31 * result + (processor != null ? processor.hashCode() : 0);
        result = 31 * result + (sequenceName != null ? sequenceName.hashCode() : 0);
        result = 31 * result + (startColumn != null ? startColumn.hashCode() : 0);
        result = 31 * result + (startRow != null ? startRow.hashCode() : 0);
        result = 31 * result + (tableLabel != null ? tableLabel.hashCode() : 0);
        result = 31 * result + (tabelName != null ? tabelName.hashCode() : 0);
        return result;
    }
}
