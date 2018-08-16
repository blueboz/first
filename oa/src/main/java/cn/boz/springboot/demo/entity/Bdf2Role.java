package cn.boz.springboot.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "BDF2_ROLE", schema = "ZHSPDEV", catalog = "")
public class Bdf2Role {
    private String id;
    private String companyId;
    private Timestamp createDate;
    private String createUser;
    private String desc;
    private Boolean enabled;
    private String name;
    private String parentId;
    private String type;

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
    @Column(name = "CREATE_USER_")
    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
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
    @Column(name = "ENABLED_")
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
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
    @Column(name = "TYPE_")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bdf2Role bdf2Role = (Bdf2Role) o;

        if (id != null ? !id.equals(bdf2Role.id) : bdf2Role.id != null) return false;
        if (companyId != null ? !companyId.equals(bdf2Role.companyId) : bdf2Role.companyId != null) return false;
        if (createDate != null ? !createDate.equals(bdf2Role.createDate) : bdf2Role.createDate != null) return false;
        if (createUser != null ? !createUser.equals(bdf2Role.createUser) : bdf2Role.createUser != null) return false;
        if (desc != null ? !desc.equals(bdf2Role.desc) : bdf2Role.desc != null) return false;
        if (enabled != null ? !enabled.equals(bdf2Role.enabled) : bdf2Role.enabled != null) return false;
        if (name != null ? !name.equals(bdf2Role.name) : bdf2Role.name != null) return false;
        if (parentId != null ? !parentId.equals(bdf2Role.parentId) : bdf2Role.parentId != null) return false;
        if (type != null ? !type.equals(bdf2Role.type) : bdf2Role.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createUser != null ? createUser.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (enabled != null ? enabled.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
