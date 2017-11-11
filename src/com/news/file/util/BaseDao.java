package com.news.file.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;


public class BaseDao {
	private static String driver;
	private static String url ;
	private static String username ;
	private static String password ;
	private static Logger logger = Logger.getLogger(BaseDao.class);
	protected static Scanner input = new Scanner(System.in);
	protected static Connection con = null; // ���Ӷ���
	protected static PreparedStatement stmt = null; // ִ��sql���Ķ���
	protected static ResultSet rs = null; // ���صĽ����
	
	static{
		driver=ConfigManager.getInstance().getValue("jdbc.driver");
		url=ConfigManager.getInstance().getValue("jdbc.url");
		username=ConfigManager.getInstance().getValue("jdbc.username");
		password=ConfigManager.getInstance().getValue("jdbc.password");
	}
	/**
	 * �������ݿ�
	 * @return ���ӳɹ� ����true
	 */
	/*public static boolean getConnections(){
		try {
			if (con==null||con.isClosed()) {
				try {
					Class.forName(driver);
					con=DriverManager.getConnection(url+"??useUnicode=true&characterEncoding=utf8",username,password);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					return false;
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}*/
	/**
	 * �������ݿ�
	 * @return ���ӳɹ� ����true
	 */
	public static boolean getConnection(){
		try {
			Context ctx = new InitialContext();
			Context context = (Context) ctx.lookup("java:/comp/env");
			DataSource ds = (DataSource)context.lookup("jdbc/news");
			con = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * �ر�����
	 */
	public static void closeAll(){
		if (rs!=null) {
			try {
				rs.close();
				rs=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt!=null) {
			try {
				stmt.close();
				stmt=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con!=null) {
			try {
				con.close();
				con=null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * ���ݵ�����ɾ���Ĳ���
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int execUpdate(String sql,Object... params){
		int result = 0;
		if (!getConnection()) {
			logger.error("���ݿ�����ʧ�ܣ�");
			return 0 ;
		}
		try {
			stmt = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				stmt.setObject(i+1, params[i]);
			}
			result=stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return result;
	}
	/**
	 * ��ѯ����
	 * @param sql
	 * @param params
	 * @return ResultSet�����
	 */
	public static ResultSet selectSet(String sql,Object... params){
		if (!getConnection()) {
			logger.error("���ݿ�����ʧ�ܣ�");
		}
		try {
			stmt = con.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				stmt.setObject(i+1, params[i]);
			}
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
