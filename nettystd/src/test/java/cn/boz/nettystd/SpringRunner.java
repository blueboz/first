package cn.boz.nettystd;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.boz.domain.ora.pojo.DbaColComments;
import cn.boz.domain.ora.pojo.DbaColCommentsExample;
import cn.boz.domain.ora.pojo.DbaTabColumnsExample;
import cn.boz.domain.ora.pojo.DbaTabColumnsWithBLOBs;
import cn.boz.domain.ora.pojo.DbaTabComments;
import cn.boz.domain.ora.pojo.DbaTabCommentsExample;
import cn.boz.domain.ora.pojo.JayExample;
import cn.boz.domain.ora.pojo.DbaTabCommentsExample.Criteria;
import cn.boz.domain.ora.pojo.Jay;
import cn.boz.ora.mapper.DbaColCommentsMapper;
import cn.boz.ora.mapper.DbaTabColumnsMapper;
import cn.boz.ora.mapper.DbaTabCommentsMapper;
import cn.boz.ora.mapper.JayMapper;
import oracle.jdbc.driver.SQLUtil;

/**
 * 
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-ctx.xml")
public class SpringRunner {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private DbaTabCommentsMapper dbaTabCommentsMapper;

	@Autowired
	private DbaColCommentsMapper dbaColCommentsMapper;

	@Autowired
	private JayMapper jayMapper;

	public void test() {
		DbaTabCommentsExample dtce = new DbaTabCommentsExample();
		Criteria criteria = dtce.createCriteria();
		criteria.andOwnerEqualTo("ZHSPDEV").andTableNameLike("SWLC_%");
		dtce.or().andOwnerEqualTo("ZHSPDEV").andTableNameEqualTo("UFLO_PROXY_DEF_");
		dtce.or().andOwnerEqualTo("ZHSPDEV").andTableNameEqualTo("UFLO_PROXY_TASK_ASSIGNEE_");
		dtce.or().andOwnerEqualTo("ZHSPDEV").andTableNameEqualTo("UFLO_PROXY_USER_RECORD_");
		dtce.or().andOwnerEqualTo("ZHSPDEV").andTableNameEqualTo("UFLO_PROXY_WHAT_");
		dtce.or().andOwnerEqualTo("ZHSPDEV").andTableNameEqualTo("UFLO_PROXY_WHO_");

		List<DbaTabComments> rst = dbaTabCommentsMapper.selectByExample(dtce);
		System.out.println(rst);
//		rst.forEach(it->{
//			System.out.println(it.getOwner()+"->"+it.getTableName());
//			DbaColCommentsExample dcce = new DbaColCommentsExample();
//			cn.boz.domain.ora.pojo.DbaColCommentsExample.Criteria criteria2 = dcce.createCriteria();
//			criteria2.andOwnerEqualTo(it.getOwner());
//			criteria2.andTableNameEqualTo(it.getTableName());
//			dbaColCommentsMapper.selectByExample(dcce);
//		});
	}

	public void test2() {
		List<Jay> jays = jayMapper.selectByExampleWithBLOBs(new JayExample());
		for (Jay jay : jays) {
			System.out.println(jay.getId());
			System.out.println(jay.getName());
			System.out.println(jay.getDescs());
		}
	}

	@Autowired
	private DbaTabColumnsMapper dbaTabColumnsMapper ;

	@Test
	public void test3() {
		var dbaTabColumnsExample = new DbaTabColumnsExample();
		cn.boz.domain.ora.pojo.DbaTabColumnsExample.Criteria cri = dbaTabColumnsExample.createCriteria();
		cri.andOwnerEqualTo("ZHSPDEV");
		cri.andTableNameEqualTo("JAY");
		List<DbaTabColumnsWithBLOBs> rst = dbaTabColumnsMapper.selectByExampleWithBLOBs(dbaTabColumnsExample);
		for (DbaTabColumnsWithBLOBs dbaTabColumnsWithBLOBs : rst) {
			String dataDeflt = dbaTabColumnsWithBLOBs.getDataDefault();
			System.out.println(dataDeflt);
		}
	}

}
