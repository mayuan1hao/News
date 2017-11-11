package com.news.file.service;

import java.util.List;

import javax.jms.Topic;

import com.news.file.bean.SpotType;

public interface SpotTypeService {
	/**
	 * 获取所有主题
	 * @return
	 */
	public List<SpotType> findAllSpotType();
	/**
	 * 更新主题
	 * @param topic
	 * @return
	 */
	public int updateSpotType(SpotType spotType);
	/**
	 * 添加主题
	 * @param name
	 * @return
	 */
	public int addSpotType(String name);
	/**
	 * 删除主题
	 * @param tid
	 * @return
	 */
	public int delSpotType(String tid);
	/**
	 * 查找主题
	 * @param name
	 * @return
	 */
	public SpotType findSpotTypeByname(String name);
}
