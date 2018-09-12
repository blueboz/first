package cn.boz.jpa;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import cn.boz.jpa.dao.UserRepository;
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
//        userRepository.delete(user);
//        userRepository.findOne(1);
	}
}