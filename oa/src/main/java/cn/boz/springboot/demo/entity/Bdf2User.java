package cn.boz.springboot.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "BDF2_USER", schema = "ZHSPDEV", catalog = "")
public class Bdf2User {
    private String username;
    private String address;
    private boolean administrator;
    private Timestamp birthday;
    private String cname;
    private String companyId;
    private Timestamp createDate;
    private String email;
    private boolean enabled;
    private String ename;
    private boolean male;
    private String mobile;
    private String password;
    private String salt;

    @Id
    @Column(name = "USERNAME_")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "ADDRESS_")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "ADMINISTRATOR_")
    public boolean isAdministrator() {
        return administrator;
    }

    public void setAdministrator(boolean administrator) {
        this.administrator = administrator;
    }

    @Basic
    @Column(name = "BIRTHDAY_")
    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "CNAME_")
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
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
    @Column(name = "EMAIL_")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "ENABLED_")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Basic
    @Column(name = "ENAME_")
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Basic
    @Column(name = "MALE_")
    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    @Basic
    @Column(name = "MOBILE_")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "PASSWORD_")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "SALT_")
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bdf2User bdf2User = (Bdf2User) o;

        if (administrator != bdf2User.administrator) return false;
        if (enabled != bdf2User.enabled) return false;
        if (male != bdf2User.male) return false;
        if (username != null ? !username.equals(bdf2User.username) : bdf2User.username != null) return false;
        if (address != null ? !address.equals(bdf2User.address) : bdf2User.address != null) return false;
        if (birthday != null ? !birthday.equals(bdf2User.birthday) : bdf2User.birthday != null) return false;
        if (cname != null ? !cname.equals(bdf2User.cname) : bdf2User.cname != null) return false;
        if (companyId != null ? !companyId.equals(bdf2User.companyId) : bdf2User.companyId != null) return false;
        if (createDate != null ? !createDate.equals(bdf2User.createDate) : bdf2User.createDate != null) return false;
        if (email != null ? !email.equals(bdf2User.email) : bdf2User.email != null) return false;
        if (ename != null ? !ename.equals(bdf2User.ename) : bdf2User.ename != null) return false;
        if (mobile != null ? !mobile.equals(bdf2User.mobile) : bdf2User.mobile != null) return false;
        if (password != null ? !password.equals(bdf2User.password) : bdf2User.password != null) return false;
        if (salt != null ? !salt.equals(bdf2User.salt) : bdf2User.salt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (administrator ? 1 : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (cname != null ? cname.hashCode() : 0);
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (enabled ? 1 : 0);
        result = 31 * result + (ename != null ? ename.hashCode() : 0);
        result = 31 * result + (male ? 1 : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (salt != null ? salt.hashCode() : 0);
        return result;
    }
}
