package com.news.file.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.news.file.bean.User;
import com.news.file.dao.UserDao;
import com.news.file.util.BaseDao;

public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public int saveUser(User user) {
		int result = 0;
		String sql = "INSERT INTO `user`(uName,`password`,uType) VALUES (?,?,?) ";
		result = execUpdate(sql, user.getuName(),user.getPassword(),user.getuType());
		return result;
	}

	@Override
	public int delUser(User user) {
		int result = 0;
		String sql = "DELETE FROM `user` WHERE uId=?";
		result = execUpdate(sql, user.getuId());
		return result;
	}

	@Override
	public int updateUser(User user) {
		int result = 0;
		String sql = "UPDATE `user` SET uName=?,`password`=?,uType=? WHERE uId=?;";
		result = execUpdate(sql, user.getuName(),user.getPassword(),user.getuType(),user.getuId());
		return result;
	}

	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		String sql = "SELECT uId,uName,`password`,uType FROM `user`";
		rs = selectSet(sql);
		try {
			while (rs.next()) {
				User user = new User();
				user.setuId(rs.getString("uId"));
				user.setuName(rs.getString("uName"));
				user.setPassword(rs.getString("password"));
				user.setuType(rs.getInt("uType"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return users;
	}

	@Override
	public User getUserByid(String id) {
		User user = null;
		String sql = "SELECT uId,uName,`password`,uType FROM `user` WHERE uId=?";
		rs = selectSet(sql, id);
		try {
			if (rs.next()) {
				user = new User();
				user.setuId(rs.getString("uId"));
				user.setuName(rs.getString("uName"));
				user.setPassword(rs.getString("password"));
				user.setuType(rs.getInt("uType"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return user;
	}

	@Override
	public User getUserByName(String name) {
		User user = null;
		String sql = "SELECT uId,uName,`password`,uType FROM `user` WHERE uName=?";
		rs = selectSet(sql, name);
		try {
			if (rs.next()) {
				user = new User();
				user.setuId(rs.getString("uId"));
				user.setuName(rs.getString("uName"));
				user.setPassword(rs.getString("password"));
				user.setuType(rs.getInt("uType"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return user;
	}

	@Override
	public List<User> getUsersByType(int type) {
		List<User> users = new ArrayList<User>();
		String sql = "SELECT uId,uName,`password`,uType FROM `user` WHERE uType=?";
		rs = selectSet(sql,type);
		try {
			while (rs.next()) {
				User user = new User();
				user.setuId(rs.getString("uId"));
				user.setuName(rs.getString("uName"));
				user.setPassword(rs.getString("password"));
				user.setuType(rs.getInt("uType"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return users;
	}

}
