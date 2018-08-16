package cn.boz.springboot.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "BDF2_URL_COMPONENT", schema = "ZHSPDEV", catalog = "")
public class Bdf2UrlComponent {
    private String id;
    private String authorityType;
    private String roleId;
    private String urlId;

    @Id
    @Column(name = "ID_")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "AUTHORITY_TYPE_")
    public String getAuthorityType() {
        return authorityType;
    }

    public void setAuthorityType(String authorityType) {
        this.authorityType = authorityType;
    }

    @Basic
    @Column(name = "ROLE_ID_")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "URL_ID_")
    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bdf2UrlComponent that = (Bdf2UrlComponent) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (authorityType != null ? !authorityType.equals(that.authorityType) : that.authorityType != null)
            return false;
        if (roleId != null ? !roleId.equals(that.roleId) : that.roleId != null) return false;
        if (urlId != null ? !urlId.equals(that.urlId) : that.urlId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (authorityType != null ? authorityType.hashCode() : 0);
        result = 31 * result + (roleId != null ? roleId.hashCode() : 0);
        result = 31 * result + (urlId != null ? urlId.hashCode() : 0);
        return result;
    }
}
