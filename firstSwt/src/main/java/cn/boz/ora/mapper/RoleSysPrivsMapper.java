package cn.boz.ora.mapper;

import cn.boz.domain.ora.pojo.RoleSysPrivs;
import cn.boz.domain.ora.pojo.RoleSysPrivsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleSysPrivsMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYS.ROLE_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	long countByExample(RoleSysPrivsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYS.ROLE_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	int deleteByExample(RoleSysPrivsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYS.ROLE_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	int insert(RoleSysPrivs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYS.ROLE_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	int insertSelective(RoleSysPrivs record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYS.ROLE_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	List<RoleSysPrivs> selectByExample(RoleSysPrivsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYS.ROLE_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	int updateByExampleSelective(@Param("record") RoleSysPrivs record, @Param("example") RoleSysPrivsExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table SYS.ROLE_SYS_PRIVS
	 * @mbg.generated  Tue Aug 28 11:39:07 CST 2018
	 */
	int updateByExample(@Param("record") RoleSysPrivs record, @Param("example") RoleSysPrivsExample example);
}