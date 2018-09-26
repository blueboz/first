package cn.boz.ora.mapper;

import cn.boz.domain.ora.pojo.DbaColComments;
import cn.boz.domain.ora.pojo.DbaColCommentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DbaColCommentsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS.DBA_COL_COMMENTS
     *
     * @mbg.generated Fri Sep 21 19:40:06 CST 2018
     */
    long countByExample(DbaColCommentsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS.DBA_COL_COMMENTS
     *
     * @mbg.generated Fri Sep 21 19:40:06 CST 2018
     */
    int deleteByExample(DbaColCommentsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS.DBA_COL_COMMENTS
     *
     * @mbg.generated Fri Sep 21 19:40:06 CST 2018
     */
    int insert(DbaColComments record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS.DBA_COL_COMMENTS
     *
     * @mbg.generated Fri Sep 21 19:40:06 CST 2018
     */
    int insertSelective(DbaColComments record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS.DBA_COL_COMMENTS
     *
     * @mbg.generated Fri Sep 21 19:40:06 CST 2018
     */
    List<DbaColComments> selectByExample(DbaColCommentsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS.DBA_COL_COMMENTS
     *
     * @mbg.generated Fri Sep 21 19:40:06 CST 2018
     */
    int updateByExampleSelective(@Param("record") DbaColComments record, @Param("example") DbaColCommentsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table SYS.DBA_COL_COMMENTS
     *
     * @mbg.generated Fri Sep 21 19:40:06 CST 2018
     */
    int updateByExample(@Param("record") DbaColComments record, @Param("example") DbaColCommentsExample example);
}