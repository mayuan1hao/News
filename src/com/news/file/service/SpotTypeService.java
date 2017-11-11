package com.news.file.service;

import java.util.List;

import javax.jms.Topic;

import com.news.file.bean.SpotType;

public interface SpotTypeService {
	/**
	 * ��ȡ��������
	 * @return
	 */
	public List<SpotType> findAllSpotType();
	/**
	 * ��������
	 * @param topic
	 * @return
	 */
	public int updateSpotType(SpotType spotType);
	/**
	 * �������
	 * @param name
	 * @return
	 */
	public int addSpotType(String name);
	/**
	 * ɾ������
	 * @param tid
	 * @return
	 */
	public int delSpotType(String tid);
	/**
	 * ��������
	 * @param name
	 * @return
	 */
	public SpotType findSpotTypeByname(String name);
}
