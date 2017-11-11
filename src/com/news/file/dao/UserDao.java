package com.news.file.dao;

import java.util.List;

import com.news.file.bean.User;

public interface UserDao {
	/**
	 * �����û�ע����Ϣ
	 * @param user
	 * @return
	 */
	int saveUser(User user);
	/**
	 * ɾ���û���Ϣ
	 * @param user
	 * @return
	 */
	int delUser(User user);
	/**
	 * �����û���Ϣ
	 * @param user
	 * @return
	 */
	int updateUser(User user);
	/**
	 * ��ȡ�����û��б�
	 * @return
	 */
	List<User> getUsers();
	/**
	 * �����û�ID��ȡ�û���Ϣ
	 * @param id
	 * @return
	 */
	User getUserByid(String id);
	/**
	 * �����û�������ȡ�û���Ϣ
	 * @param name
	 * @return
	 */
	User getUserByName(String name);
	/**
	 * �����û����ͻ�ȡ�û��б�
	 * @param type
	 * @return
	 */
	List<User> getUsersByType(int type);
}
