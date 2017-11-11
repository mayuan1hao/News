package com.news.file.dao;

import java.util.List;

import com.news.file.bean.User;

public interface UserDao {
	/**
	 * 保存用户注册信息
	 * @param user
	 * @return
	 */
	int saveUser(User user);
	/**
	 * 删除用户信息
	 * @param user
	 * @return
	 */
	int delUser(User user);
	/**
	 * 更新用户信息
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	/**
	 * 获取所有用户列表
	 * @return
	 */
	List<User> getUsers();
	/**
	 * 根据用户ID获取用户信息
	 * @param id
	 * @return
	 */
	User getUserByid(String id);
	/**
	 * 根据用户姓名获取用户信息
	 * @param name
	 * @return
	 */
	User getUserByName(String name);
	/**
	 * 根据用户类型获取用户列表
	 * @param type
	 * @return
	 */
	List<User> getUsersByType(int type);
}
