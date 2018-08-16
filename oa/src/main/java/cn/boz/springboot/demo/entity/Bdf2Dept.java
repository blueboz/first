package cn.boz.springboot.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "BDF2_DEPT", schema = "ZHSPDEV", catalog = "")
public class Bdf2Dept {
    private String id;
    private String companyId;
    private Timestamp createDate;
    private String desc;
    private String name;
    private String parentId;
    private Timestamp sxsj1;
    private Timestamp sxsj2;
    private Boolean valid;
    private Integer type;
    private String ywdm;
    private String dtype;

    @Id
    @Column(name = "ID_")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    @Column(name = "CREATE_DATE_")
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
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
    @Column(name = "NAME_")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "PARENT_ID_")
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "SXSJ1")
    public Timestamp getSxsj1() {
        return sxsj1;
    }

    public void setSxsj1(Timestamp sxsj1) {
        this.sxsj1 = sxsj1;
    }

    @Basic
    @Column(name = "SXSJ2")
    public Timestamp getSxsj2() {
        return sxsj2;
    }

    public void setSxsj2(Timestamp sxsj2) {
        this.sxsj2 = sxsj2;
    }

    @Basic
    @Column(name = "VALID")
    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    @Basic
    @Column(name = "TYPE")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Basic
    @Column(name = "YWDM")
    public String getYwdm() {
        return ywdm;
    }

    public void setYwdm(String ywdm) {
        this.ywdm = ywdm;
    }

    @Basic
    @Column(name = "DTYPE")
    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bdf2Dept bdf2Dept = (Bdf2Dept) o;

        if (id != null ? !id.equals(bdf2Dept.id) : bdf2Dept.id != null) return false;
        if (companyId != null ? !companyId.equals(bdf2Dept.companyId) : bdf2Dept.companyId != null) return false;
        if (createDate != null ? !createDate.equals(bdf2Dept.createDate) : bdf2Dept.createDate != null) return false;
        if (desc != null ? !desc.equals(bdf2Dept.desc) : bdf2Dept.desc != null) return false;
        if (name != null ? !name.equals(bdf2Dept.name) : bdf2Dept.name != null) return false;
        if (parentId != null ? !parentId.equals(bdf2Dept.parentId) : bdf2Dept.parentId != null) return false;
        if (sxsj1 != null ? !sxsj1.equals(bdf2Dept.sxsj1) : bdf2Dept.sxsj1 != null) return false;
        if (sxsj2 != null ? !sxsj2.equals(bdf2Dept.sxsj2) : bdf2Dept.sxsj2 != null) return false;
        if (valid != null ? !valid.equals(bdf2Dept.valid) : bdf2Dept.valid != null) return false;
        if (type != null ? !type.equals(bdf2Dept.type) : bdf2Dept.type != null) return false;
        if (ywdm != null ? !ywdm.equals(bdf2Dept.ywdm) : bdf2Dept.ywdm != null) return false;
        if (dtype != null ? !dtype.equals(bdf2Dept.dtype) : bdf2Dept.dtype != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (sxsj1 != null ? sxsj1.hashCode() : 0);
        result = 31 * result + (sxsj2 != null ? sxsj2.hashCode() : 0);
        result = 31 * result + (valid != null ? valid.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (ywdm != null ? ywdm.hashCode() : 0);
        result = 31 * result + (dtype != null ? dtype.hashCode() : 0);
        return result;
    }
}
