package cn.boz.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import cn.boz.jpa.pojo.User;

/**
 * 
 * @author Administrator
 *
 *	添加@NoRepositoryBean这个注解，将不会将其注入Spring容器。一般用在父类中
 */
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User getUserByNameAndPassword(String name,String password);
	
	public User getUserByIdAndBirthday(int id,String birthday);
	
	public List<User> getUserByNameLike(String name);
	
}
