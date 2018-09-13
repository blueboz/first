package cn.boz.jpa.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the sdbf_user database table.
 * 
 */
@Entity
@Table(name="sdbf_user")
@NamedQuery(name="SdbfUser.findAll", query="SELECT s FROM SdbfUser s")
public class SdbfUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CZRY_DM")
	private String czryDm;

	@Column(name="CZRY_MC")
	private String czryMc;

	@Column(name="LOGIN_NAME")
	private String loginName;

	@Column(name="LOGIN_PWD")
	private String loginPwd;

	@Column(name="SFLB_DM")
	private String sflbDm;

	@Temporal(TemporalType.TIMESTAMP)
	private Date sxsj;

	private String tbbz;

	private String xybz;

	private String yxbz;

	@Temporal(TemporalType.TIMESTAMP)
	private Date zfsj;

	public SdbfUser() {
	}

	public String getCzryDm() {
		return this.czryDm;
	}

	public void setCzryDm(String czryDm) {
		this.czryDm = czryDm;
	}

	public String getCzryMc() {
		return this.czryMc;
	}

	public void setCzryMc(String czryMc) {
		this.czryMc = czryMc;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPwd() {
		return this.loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getSflbDm() {
		return this.sflbDm;
	}

	public void setSflbDm(String sflbDm) {
		this.sflbDm = sflbDm;
	}

	public Date getSxsj() {
		return this.sxsj;
	}

	public void setSxsj(Date sxsj) {
		this.sxsj = sxsj;
	}

	public String getTbbz() {
		return this.tbbz;
	}

	public void setTbbz(String tbbz) {
		this.tbbz = tbbz;
	}

	public String getXybz() {
		return this.xybz;
	}

	public void setXybz(String xybz) {
		this.xybz = xybz;
	}

	public String getYxbz() {
		return this.yxbz;
	}

	public void setYxbz(String yxbz) {
		this.yxbz = yxbz;
	}

	public Date getZfsj() {
		return this.zfsj;
	}

	public void setZfsj(Date zfsj) {
		this.zfsj = zfsj;
	}

	@Override
	public String toString() {
		return "SdbfUser [czryDm=" + czryDm + ", czryMc=" + czryMc + ", loginName=" + loginName + ", loginPwd="
				+ loginPwd + ", sflbDm=" + sflbDm + ", sxsj=" + sxsj + ", tbbz=" + tbbz + ", xybz=" + xybz + ", yxbz="
				+ yxbz + ", zfsj=" + zfsj + "]";
	}

	
}