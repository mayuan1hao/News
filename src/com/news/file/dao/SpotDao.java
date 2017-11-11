package com.news.file.dao;

import java.util.Date;
import java.util.List;

import com.news.file.bean.Spot;
import com.news.file.bean.User;

public interface SpotDao {
	/**
	 * 添加新闻信息
	 * @param Spot
	 * @return
	 */
	int saveSpot(Spot spot);
	/**
	 * 删除新闻信息
	 * @param Spot
	 * @return
	 */
	int delSpot(Spot spot);
	/**
	 * 更新新闻信息
	 * @param Spot
	 * @return
	 */
	int updateSpot(Spot spot);
	/**
	 * 获取所有新闻列表
	 * @return
	 */
	List<Spot> getSpots();
	/**
	 * 根据新闻ID获取新闻信息
	 * @param id
	 * @return
	 */
	Spot getSpotByid(String id);
	/**
	 * 根据新闻标题获取新闻列表(模糊查询)
	 * @param name
	 * @return
	 */
	List<Spot> getSpotByTitle(String title);
	/**
	 * 根据新闻类型获取新闻列表
	 * @param type
	 * @return
	 */
	List<Spot> getSpotsByType(int type);
	/**
	 * 根据作者姓名获取新闻列表（模糊查询）
	 * @param author
	 * @return
	 */
	List<Spot> getSpotsByAuthor(String author);
	/**
	 * 根据文章发表时间段获取新闻列表
	 * @param minTime
	 * @param maxTime
	 * @return
	 */
	List<Spot> getSpotsByTime(Date minTime,Date maxTime);
}
