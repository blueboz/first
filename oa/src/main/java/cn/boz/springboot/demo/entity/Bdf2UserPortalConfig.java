package cn.boz.springboot.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "BDF2_USER_PORTAL_CONFIG", schema = "ZHSPDEV", catalog = "")
public class Bdf2UserPortalConfig {
    private String userName;
    private String desktopSetting;
    private String skin;

    @Id
    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "DESKTOP_SETTING")
    public String getDesktopSetting() {
        return desktopSetting;
    }

    public void setDesktopSetting(String desktopSetting) {
        this.desktopSetting = desktopSetting;
    }

    @Basic
    @Column(name = "SKIN")
    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bdf2UserPortalConfig that = (Bdf2UserPortalConfig) o;

        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (desktopSetting != null ? !desktopSetting.equals(that.desktopSetting) : that.desktopSetting != null)
            return false;
        if (skin != null ? !skin.equals(that.skin) : that.skin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userName != null ? userName.hashCode() : 0;
        result = 31 * result + (desktopSetting != null ? desktopSetting.hashCode() : 0);
        result = 31 * result + (skin != null ? skin.hashCode() : 0);
        return result;
    }
}
