package com.news.file.dao.impl;

import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.news.file.bean.Spot;
import com.news.file.dao.SpotDao;
import com.news.file.util.BaseDao;

public class SpotDaoImpl extends BaseDao implements SpotDao{

	@Override
	public int saveSpot(Spot spot) {
		int result = 0;
		String sql = "INSERT INTO `spot`(nTid,nAuthor,nTime,nTitle) VALUES (?,?,?,?) ";
		result = execUpdate(sql, spot.getnTid(),spot.getnAuthor(),spot.getnTime(),spot.getnTitle());
		return result;
	}

	@Override
	public int delSpot(Spot spot) {
		int result = 0;
		String sql = "DELETE FROM `spot` WHERE nId=?";
		result = execUpdate(sql, spot.getnId());
		return result;
	}

	@Override
	public int updateSpot(Spot spot) {
		int result = 0;
		String sql = "UPDATE `spot` SET nTid=?,nAuthor=?,nTime=?,nTitle=? where nId=?";
		result = execUpdate(sql, spot.getnTid(),spot.getnAuthor(),spot.getnTime(),spot.getnTitle(),spot.getnId());
		return result;
	}

	@Override
	public List<Spot> getSpots() {
		List<Spot> spots = new ArrayList<Spot>();
		String sql = "SELECT nId,nTid,nAuthor,nTime,nTitle FROM `spot` ORDER BY nTime DESC";
		rs = selectSet(sql);
		try {
			while (rs.next()) {
				Spot spot = new Spot();
				spot.setnId(rs.getString("nId"));
				spot.setnTid(rs.getString("nTid"));
				spot.setnAuthor(rs.getString("nAuthor"));
				spot.setnTime(rs.getDate("nTime"));
				spot.setnTitle(rs.getString("nTitle"));
				spots.add(spot);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return spots;
	}

	@Override
	public Spot getSpotByid(String id) {
		Spot spot = null;
		String sql = "SELECT nId,nTid,nAuthor,nTime,nTitle FROM `spot` where nId=? ORDER BY nTime DESC";
		rs = selectSet(sql, id);
		try {
			if (rs.next()) {
				spot = new Spot();
				spot.setnId(rs.getString("nId"));
				spot.setnTid(rs.getString("nTid"));
				spot.setnAuthor(rs.getString("nAuthor"));
				spot.setnTime(rs.getDate("nTime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return spot;
	}

	@Override
	public List<Spot> getSpotByTitle(String title) {
		List<Spot> spots = new ArrayList<Spot>();
		String sql = "SELECT nId,nTid,nAuthor,nTime,nTitle FROM `spot` WHERE nTitle LIKE ? ORDER BY nTime DESC";
		rs = selectSet(sql,"%"+title+"%");
		try {
			while (rs.next()) {
				Spot spot = new Spot();
				spot.setnId(rs.getString("nId"));
				spot.setnTid(rs.getString("nTid"));
				spot.setnAuthor(rs.getString("nAuthor"));
				spot.setnTime(rs.getDate("nTime"));
				spot.setnTitle(rs.getString("nTitle"));
				spots.add(spot);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return spots;
	}

	@Override
	public List<Spot> getSpotsByType(int type) {
		List<Spot> spots = new ArrayList<Spot>();
		String sql = "SELECT nId,nTid,nAuthor,nTime,nTitle FROM `spot` WHERE nTid=? ORDER BY nTime DESC";
		rs = selectSet(sql,type);
		try {
			while (rs.next()) {
				Spot spot = new Spot();
				spot.setnId(rs.getString("nId"));
				spot.setnTid(rs.getString("nTid"));
				spot.setnAuthor(rs.getString("nAuthor"));
				spot.setnTime(rs.getDate("nTime"));
				spot.setnTitle(rs.getString("nTitle"));
				spots.add(spot);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return spots;
	}

	@Override
	public List<Spot> getSpotsByAuthor(String author) {
		List<Spot> spots = new ArrayList<Spot>();
		String sql = "SELECT nId,nTid,nAuthor,nTime,nTitle FROM `spot` WHERE nAuthor LIKE ? ORDER BY nTime DESC";
		rs = selectSet(sql,"%"+author+"%");
		try {
			while (rs.next()) {
				Spot spot = new Spot();
				spot.setnId(rs.getString("nId"));
				spot.setnTid(rs.getString("nTid"));
				spot.setnAuthor(rs.getString("nAuthor"));
				spot.setnTime(rs.getDate("nTime"));
				spot.setnTitle(rs.getString("nTitle"));
				spots.add(spot);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return spots;
	}

	@Override
	public List<Spot> getSpotsByTime(Date minTime, Date maxTime) {
		List<Spot> spots = new ArrayList<Spot>();
		String sql = "SELECT nId,nTid,nAuthor,nTime,nTitle FROM `spot` WHERE nTime between ? and ? ORDER BY nTime DESC";
		rs = selectSet(sql,minTime,maxTime);
		try {
			while (rs.next()) {
				Spot spot = new Spot();
				spot.setnId(rs.getString("nId"));
				spot.setnTid(rs.getString("nTid"));
				spot.setnAuthor(rs.getString("nAuthor"));
				spot.setnTime(rs.getDate("nTime"));
				spot.setnTitle(rs.getString("nTitle"));
				spots.add(spot);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll();
		}
		return spots;
	}
}
