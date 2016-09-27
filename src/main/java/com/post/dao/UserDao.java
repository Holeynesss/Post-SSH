package com.post.dao;

import com.post.entity.User;

public interface UserDao {
	public User find(String username, String password);
	public User findByUsername(String username);
}
