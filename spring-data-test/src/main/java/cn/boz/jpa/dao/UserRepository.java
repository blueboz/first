package cn.boz.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.boz.jpa.pojo.User;

public interface UserRepository extends JpaRepository<User, Integer>{}
