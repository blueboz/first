package cn.boz.nettystd;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.boz.domain.ora.pojo.DbaColCommentsExample;
import cn.boz.domain.ora.pojo.DbaTabComments;
import cn.boz.domain.ora.pojo.DbaTabCommentsExample;
import cn.boz.domain.ora.pojo.DbaTabCommentsExample.Criteria;
import cn.boz.ora.mapper.DbaColCommentsMapper;
import cn.boz.ora.mapper.DbaTabCommentsMapper;
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
    
	@Test
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
	
}
