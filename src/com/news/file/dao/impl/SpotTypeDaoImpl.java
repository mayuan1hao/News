package com.news.file.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.news.file.bean.SpotType;
import com.news.file.dao.SpotTypeDao;
import com.news.file.util.BaseDao;

public class SpotTypeDaoImpl extends BaseDao implements SpotTypeDao{

	@Override
	public int saveSpotType(SpotType spotType) {
		int result = 0;
		String sql = "INSERT INTO `spot_type`(nTname) VALUES (?) ";
		result = execUpdate(sql, spotType.getnTname());
		return result;
	}

	@Override
	public int delSpotType(SpotType spotType) {
		int result = 0;
		String sql = "DELETE FROM `spot_type` WHERE nTid=?";
		result = execUpdate(sql, spotType.getnTid());
		return result;
	}

	@Override
	public int updateSpotType(SpotType spotType) {
		int result = 0;
		String sql = "UPDATE `spot_type` SET nTname=? where nTid=?";
		result = execUpdate(sql, spotType.getnTname(),spotType.getnTid());
		return result;
	}

	@Override
	public List<SpotType> getSpotTypes() {
		List<SpotType> sTypes = new ArrayList<SpotType>();
		String sql = "SELECT nTid,nTname FROM spot_type";
		rs = selectSet(sql);
		try {
			while (rs.next()) {
				SpotType spotType = new SpotType();
				spotType.setnTid(rs.getString("nTid"));
				spotType.setnTname(rs.getString("nTname"));
				sTypes.add(spotType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return sTypes;
	}

	@Override
	public SpotType getSpotTypeByid(String id) {
		SpotType spotType = null;
		String sql = "SELECT nTid,nTname FROM spot_type WHERE nTid=?";
		rs = selectSet(sql, id);
		try {
			if (rs.next()) {
				spotType = new SpotType();
				spotType.setnTid(rs.getString("nTid"));
				spotType.setnTname(rs.getString("nTname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return spotType;
	}

	@Override
	public SpotType getSpotTypeByName(String name) {
		SpotType spotType = null;
		String sql = "SELECT nTid,nTname FROM spot_type WHERE nTname=?";
		rs = selectSet(sql, name);
		try {
			if (rs.next()) {
				spotType = new SpotType();
				spotType.setnTid(rs.getString("nTid"));
				spotType.setnTname(rs.getString("nTname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally{
			closeAll();
		}
		return spotType;
	}
}
