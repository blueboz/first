package cn.boz.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.boz.jpa.pojo.SdbfUser;

public interface SdbfUserRepository extends JpaRepository<SdbfUser, String>{
	
}
