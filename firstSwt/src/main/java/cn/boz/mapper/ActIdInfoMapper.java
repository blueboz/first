package cn.boz.mapper;

import cn.boz.domain.pojo.ActIdInfo;
import cn.boz.domain.pojo.ActIdInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActIdInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_info
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    long countByExample(ActIdInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_info
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    int deleteByExample(ActIdInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_info
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    int insert(ActIdInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_info
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    int insertSelective(ActIdInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_info
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    List<ActIdInfo> selectByExampleWithBLOBs(ActIdInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_info
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    List<ActIdInfo> selectByExample(ActIdInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_info
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    int updateByExampleSelective(@Param("record") ActIdInfo record, @Param("example") ActIdInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_info
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") ActIdInfo record, @Param("example") ActIdInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_id_info
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    int updateByExample(@Param("record") ActIdInfo record, @Param("example") ActIdInfoExample example);
}