package cn.boz.mybaits;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.boz.domain.pojo.ActReProcdef;
import cn.boz.mybaits.mapper.MyMapper;

public class MybatisMain {

	@Test
	public void test() {
		InputStream is = this.getClass().getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = factory.openSession();
		ActReProcdef pd = sqlSession.selectOne("cn.boz.mybaits.mapper.MyMapper.findProcDefById", "boz:1:97504");
		System.out.println(pd);
		MyMapper mapper = sqlSession.getMapper(MyMapper.class);
		ActReProcdef pd2 = mapper.findProcDefById("boz:1:97504");
		System.out.println(pd2);
		sqlSession.close();
	}
}
