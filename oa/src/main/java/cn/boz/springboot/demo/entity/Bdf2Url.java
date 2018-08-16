package cn.boz.springboot.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "BDF2_URL", schema = "ZHSPDEV", catalog = "")
public class Bdf2Url {
    private String id;
    private String companyId;
    private String desc;
    private boolean forNavigation;
    private String icon;
    private String name;
    private Integer order;
    private String parentId;
    private String systemId;
    private String url;

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
    @Column(name = "DESC_")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @Column(name = "FOR_NAVIGATION_")
    public boolean isForNavigation() {
        return forNavigation;
    }

    public void setForNavigation(boolean forNavigation) {
        this.forNavigation = forNavigation;
    }

    @Basic
    @Column(name = "ICON_")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
    @Column(name = "ORDER_")
    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
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
    @Column(name = "SYSTEM_ID_")
    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    @Basic
    @Column(name = "URL_")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bdf2Url bdf2Url = (Bdf2Url) o;

        if (forNavigation != bdf2Url.forNavigation) return false;
        if (id != null ? !id.equals(bdf2Url.id) : bdf2Url.id != null) return false;
        if (companyId != null ? !companyId.equals(bdf2Url.companyId) : bdf2Url.companyId != null) return false;
        if (desc != null ? !desc.equals(bdf2Url.desc) : bdf2Url.desc != null) return false;
        if (icon != null ? !icon.equals(bdf2Url.icon) : bdf2Url.icon != null) return false;
        if (name != null ? !name.equals(bdf2Url.name) : bdf2Url.name != null) return false;
        if (order != null ? !order.equals(bdf2Url.order) : bdf2Url.order != null) return false;
        if (parentId != null ? !parentId.equals(bdf2Url.parentId) : bdf2Url.parentId != null) return false;
        if (systemId != null ? !systemId.equals(bdf2Url.systemId) : bdf2Url.systemId != null) return false;
        if (url != null ? !url.equals(bdf2Url.url) : bdf2Url.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (forNavigation ? 1 : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        result = 31 * result + (systemId != null ? systemId.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
