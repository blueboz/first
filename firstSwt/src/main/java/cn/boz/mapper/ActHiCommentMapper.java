package cn.boz.mapper;

import cn.boz.domain.pojo.ActHiComment;
import cn.boz.domain.pojo.ActHiCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActHiCommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_hi_comment
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    long countByExample(ActHiCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_hi_comment
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    int deleteByExample(ActHiCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_hi_comment
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    int insert(ActHiComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_hi_comment
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    int insertSelective(ActHiComment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_hi_comment
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    List<ActHiComment> selectByExampleWithBLOBs(ActHiCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_hi_comment
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    List<ActHiComment> selectByExample(ActHiCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_hi_comment
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    int updateByExampleSelective(@Param("record") ActHiComment record, @Param("example") ActHiCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_hi_comment
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    int updateByExampleWithBLOBs(@Param("record") ActHiComment record, @Param("example") ActHiCommentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table act_hi_comment
     *
     * @mbg.generated Sun Aug 26 11:58:27 CST 2018
     */
    int updateByExample(@Param("record") ActHiComment record, @Param("example") ActHiCommentExample example);
}