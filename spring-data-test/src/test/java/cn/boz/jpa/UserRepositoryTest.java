package cn.boz.jpa;

import java.util.List;
import java.util.Set;

import org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import cn.boz.jpa.dao.SdbfUserRepository;
import cn.boz.jpa.dao.UserRepository;
import cn.boz.jpa.pojo.SdbfUser;
import cn.boz.jpa.pojo.User;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:app-ctx.xml")
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void baeTest() throws Exception {
		User user = new User();
		user.setName("Jay");
		user.setPassword("123456");
		user.setBirthday("2008-08-08");
		userRepository.save(user);
//      userRepository.delete(user);
//      userRepository.findOne(1);
	}

	@Test
	public void findUser() {
		User user = userRepository.getUserByNameAndPassword("Jay", "123456");
		System.out.println(user);
	}

	@Test
	public void findUserByIdAndBi() {
		User u = userRepository.getUserByIdAndBirthday(1, "2008-08-08");
		System.out.println(u);
	}

	@Test
	public void findNameLike() {
		var u = userRepository.getUserByNameLike("Ja%");
		System.out.println(u);
	}
	
	@Test
	public void findModel() {
		JPAMetaModelEntityProcessor jpaMMEP = new JPAMetaModelEntityProcessor();
		Set<String> sets = jpaMMEP.getSupportedAnnotationTypes();
		sets.forEach(it->{
			System.out.println(it);
		});
	}
	
	
	@Autowired
	private SdbfUserRepository sdbfUserRepository;

	@Test
	public void testfindSdbfUser() {
		List<SdbfUser> users = sdbfUserRepository.findAll();
		users.forEach(it->{
			System.out.println(it);
		});
	}
}