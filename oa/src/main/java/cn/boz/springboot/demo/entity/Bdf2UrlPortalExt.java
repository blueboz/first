package cn.boz.springboot.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "BDF2_URL_PORTAL_EXT", schema = "ZHSPDEV", catalog = "")
public class Bdf2UrlPortalExt {
    private String urlId;
    private String configJson;

    @Id
    @Column(name = "URL_ID_")
    public String getUrlId() {
        return urlId;
    }

    public void setUrlId(String urlId) {
        this.urlId = urlId;
    }

    @Basic
    @Column(name = "CONFIG_JSON")
    public String getConfigJson() {
        return configJson;
    }

    public void setConfigJson(String configJson) {
        this.configJson = configJson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bdf2UrlPortalExt that = (Bdf2UrlPortalExt) o;

        if (urlId != null ? !urlId.equals(that.urlId) : that.urlId != null) return false;
        if (configJson != null ? !configJson.equals(that.configJson) : that.configJson != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = urlId != null ? urlId.hashCode() : 0;
        result = 31 * result + (configJson != null ? configJson.hashCode() : 0);
        return result;
    }
}
