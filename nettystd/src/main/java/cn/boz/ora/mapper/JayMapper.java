package cn.boz.ora.mapper;

import cn.boz.domain.ora.pojo.Jay;
import cn.boz.domain.ora.pojo.JayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JayMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ZHSPDEV.JAY
	 * @mbg.generated  Thu Sep 27 11:05:34 CST 2018
	 */
	long countByExample(JayExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ZHSPDEV.JAY
	 * @mbg.generated  Thu Sep 27 11:05:34 CST 2018
	 */
	int deleteByExample(JayExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ZHSPDEV.JAY
	 * @mbg.generated  Thu Sep 27 11:05:34 CST 2018
	 */
	int deleteByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ZHSPDEV.JAY
	 * @mbg.generated  Thu Sep 27 11:05:34 CST 2018
	 */
	int insert(Jay record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ZHSPDEV.JAY
	 * @mbg.generated  Thu Sep 27 11:05:34 CST 2018
	 */
	int insertSelective(Jay record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ZHSPDEV.JAY
	 * @mbg.generated  Thu Sep 27 11:05:34 CST 2018
	 */
	List<Jay> selectByExampleWithBLOBs(JayExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ZHSPDEV.JAY
	 * @mbg.generated  Thu Sep 27 11:05:34 CST 2018
	 */
	List<Jay> selectByExample(JayExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ZHSPDEV.JAY
	 * @mbg.generated  Thu Sep 27 11:05:34 CST 2018
	 */
	Jay selectByPrimaryKey(String id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ZHSPDEV.JAY
	 * @mbg.generated  Thu Sep 27 11:05:34 CST 2018
	 */
	int updateByExampleSelective(@Param("record") Jay record, @Param("example") JayExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ZHSPDEV.JAY
	 * @mbg.generated  Thu Sep 27 11:05:34 CST 2018
	 */
	int updateByExampleWithBLOBs(@Param("record") Jay record, @Param("example") JayExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ZHSPDEV.JAY
	 * @mbg.generated  Thu Sep 27 11:05:34 CST 2018
	 */
	int updateByExample(@Param("record") Jay record, @Param("example") JayExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ZHSPDEV.JAY
	 * @mbg.generated  Thu Sep 27 11:05:34 CST 2018
	 */
	int updateByPrimaryKeySelective(Jay record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ZHSPDEV.JAY
	 * @mbg.generated  Thu Sep 27 11:05:34 CST 2018
	 */
	int updateByPrimaryKeyWithBLOBs(Jay record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ZHSPDEV.JAY
	 * @mbg.generated  Thu Sep 27 11:05:34 CST 2018
	 */
	int updateByPrimaryKey(Jay record);
}