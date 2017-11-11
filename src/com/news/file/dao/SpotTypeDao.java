package com.news.file.dao;

import java.util.List;

import com.news.file.bean.Spot;
import com.news.file.bean.SpotType;

public interface SpotTypeDao {
	/**
	 * 添加新闻类型信息
	 * @param SpotType
	 * @return
	 */
	int saveSpotType(SpotType spotType);
	/**
	 * 删除新闻类型信息
	 * @param SpotType
	 * @return
	 */
	int delSpotType(SpotType spotType);
	/**
	 * 更新新闻类型信息
	 * @param SpotType
	 * @return
	 */
	int updateSpotType(SpotType spotType);
	/**
	 * 获取所有新闻类型列表
	 * @return
	 */
	List<SpotType> getSpotTypes();
	/**
	 * 根据新闻ID获取新闻类型信息
	 * @param id
	 * @return
	 */
	SpotType getSpotTypeByid(String id);
	/**
	 * 根据新闻标题获取新闻类型列表(模糊查询)
	 * @param name
	 * @return
	 */
	SpotType getSpotTypeByName(String name);
}
