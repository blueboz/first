package cn.boz.mybaits.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import cn.boz.domain.pojo.ActReProcdef;

/**
 * 采用注解的方式，只需要在mybatis-config 配置文件中
 * 配置package 属性即可
 * 自动回将这个扫描并且注入
 * @author Administrator
 *
 */
public interface MyMapper2 {
	
	@Select("SELECT * FROM act_re_procdef WHERE id_=#{id}")
	public @ResultMap(value = "") ActReProcdef findProcDefById(@Param("id") String id);

}
