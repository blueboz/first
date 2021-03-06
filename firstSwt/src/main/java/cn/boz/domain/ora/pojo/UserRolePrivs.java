package cn.boz.domain.ora.pojo;

public class UserRolePrivs {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SYS.USER_ROLE_PRIVS.USERNAME
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	private String username;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SYS.USER_ROLE_PRIVS.GRANTED_ROLE
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	private String grantedRole;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SYS.USER_ROLE_PRIVS.ADMIN_OPTION
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	private String adminOption;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SYS.USER_ROLE_PRIVS.DEFAULT_ROLE
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	private String defaultRole;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column SYS.USER_ROLE_PRIVS.OS_GRANTED
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	private String osGranted;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SYS.USER_ROLE_PRIVS.USERNAME
	 * @return  the value of SYS.USER_ROLE_PRIVS.USERNAME
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SYS.USER_ROLE_PRIVS.USERNAME
	 * @param username  the value for SYS.USER_ROLE_PRIVS.USERNAME
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SYS.USER_ROLE_PRIVS.GRANTED_ROLE
	 * @return  the value of SYS.USER_ROLE_PRIVS.GRANTED_ROLE
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	public String getGrantedRole() {
		return grantedRole;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SYS.USER_ROLE_PRIVS.GRANTED_ROLE
	 * @param grantedRole  the value for SYS.USER_ROLE_PRIVS.GRANTED_ROLE
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	public void setGrantedRole(String grantedRole) {
		this.grantedRole = grantedRole == null ? null : grantedRole.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SYS.USER_ROLE_PRIVS.ADMIN_OPTION
	 * @return  the value of SYS.USER_ROLE_PRIVS.ADMIN_OPTION
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	public String getAdminOption() {
		return adminOption;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SYS.USER_ROLE_PRIVS.ADMIN_OPTION
	 * @param adminOption  the value for SYS.USER_ROLE_PRIVS.ADMIN_OPTION
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	public void setAdminOption(String adminOption) {
		this.adminOption = adminOption == null ? null : adminOption.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SYS.USER_ROLE_PRIVS.DEFAULT_ROLE
	 * @return  the value of SYS.USER_ROLE_PRIVS.DEFAULT_ROLE
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	public String getDefaultRole() {
		return defaultRole;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SYS.USER_ROLE_PRIVS.DEFAULT_ROLE
	 * @param defaultRole  the value for SYS.USER_ROLE_PRIVS.DEFAULT_ROLE
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	public void setDefaultRole(String defaultRole) {
		this.defaultRole = defaultRole == null ? null : defaultRole.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column SYS.USER_ROLE_PRIVS.OS_GRANTED
	 * @return  the value of SYS.USER_ROLE_PRIVS.OS_GRANTED
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	public String getOsGranted() {
		return osGranted;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column SYS.USER_ROLE_PRIVS.OS_GRANTED
	 * @param osGranted  the value for SYS.USER_ROLE_PRIVS.OS_GRANTED
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	public void setOsGranted(String osGranted) {
		this.osGranted = osGranted == null ? null : osGranted.trim();
	}
}