package com.post.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.post.entity.User;


public interface UserRepository extends JpaRepository<User, Serializable> {
	@Query("select u from User u where username = ?1 and password = ?2")
	User findByUsernameAndPassword(String username, String password);
	User findByUsername(String username);

}
