package cn.boz.springboot.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "BDF2_COMPONENT", schema = "ZHSPDEV", catalog = "")
public class Bdf2Component {
    private String id;
    private String componentId;
    private String desc;

    @Id
    @Column(name = "ID_")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "COMPONENT_ID_")
    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    @Basic
    @Column(name = "DESC_")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bdf2Component that = (Bdf2Component) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (componentId != null ? !componentId.equals(that.componentId) : that.componentId != null) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (componentId != null ? componentId.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        return result;
    }
}
