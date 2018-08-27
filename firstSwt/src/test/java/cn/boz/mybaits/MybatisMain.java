package cn.boz.mybaits;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.boz.domain.pojo.ActReProcdef;
import cn.boz.mybaits.mapper.MyMapper;
import cn.boz.mybaits.mapper.MyMapper2;

public class MybatisMain {

	private SqlSession sqlSession;

	@Before
	public void init() {
		InputStream is = this.getClass().getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		sqlSession = factory.openSession();
		
	}

	@Test
	public void test() {
		ActReProcdef pd = sqlSession.selectOne("cn.boz.mybaits.mapper.MyMapper.findProcDefById", "boz:1:97504");
		System.out.println(pd);
		MyMapper mapper = sqlSession.getMapper(MyMapper.class);
		ActReProcdef pd2 = mapper.findProcDefById("boz:1:97504");
		System.out.println(pd2);
	}

	@Test
	public void test2() {
		MyMapper2 mapper = sqlSession.getMapper(MyMapper2.class);
		ActReProcdef rst = mapper.findProcDefById("boz:1:97504");
		System.out.println(rst);
	}
	
	@After
	public void destory() {
		sqlSession.close();
	}
}
