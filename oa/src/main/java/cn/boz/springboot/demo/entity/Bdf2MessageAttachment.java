package cn.boz.springboot.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "BDF2_MESSAGE_ATTACHMENT", schema = "ZHSPDEV", catalog = "")
public class Bdf2MessageAttachment {
    private String id;
    private String messageId;
    private String attachmentPath;
    private String attachmentOriginName;

    @Id
    @Column(name = "ID_")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "MESSAGE_ID_")
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    @Basic
    @Column(name = "ATTACHMENT_PATH_")
    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    @Basic
    @Column(name = "ATTACHMENT_ORIGIN_NAME_")
    public String getAttachmentOriginName() {
        return attachmentOriginName;
    }

    public void setAttachmentOriginName(String attachmentOriginName) {
        this.attachmentOriginName = attachmentOriginName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bdf2MessageAttachment that = (Bdf2MessageAttachment) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (messageId != null ? !messageId.equals(that.messageId) : that.messageId != null) return false;
        if (attachmentPath != null ? !attachmentPath.equals(that.attachmentPath) : that.attachmentPath != null)
            return false;
        if (attachmentOriginName != null ? !attachmentOriginName.equals(that.attachmentOriginName) : that.attachmentOriginName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (messageId != null ? messageId.hashCode() : 0);
        result = 31 * result + (attachmentPath != null ? attachmentPath.hashCode() : 0);
        result = 31 * result + (attachmentOriginName != null ? attachmentOriginName.hashCode() : 0);
        return result;
    }
}
