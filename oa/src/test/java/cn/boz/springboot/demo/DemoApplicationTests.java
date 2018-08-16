package cn.boz.springboot.demo;

import cn.boz.springboot.demo.entity.Bdf2User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private EntityManagerFactory emf;

	@Qualifier("primaryDataSource")
	@Autowired
	private DataSource ds;

	@Test
	public void contextLoads() {
		EntityManager em = emf.createEntityManager();
		List list = em.createQuery("from Bdf2User").getResultList();
		ObjectMapper om = new ObjectMapper();
		list.forEach((Object it) ->{
			try {
				String json = om.writeValueAsString(it);
				System.out.println(json);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		});



	}

}
