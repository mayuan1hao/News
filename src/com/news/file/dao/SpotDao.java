package com.news.file.dao;

import java.util.Date;
import java.util.List;

import com.news.file.bean.Spot;
import com.news.file.bean.User;

public interface SpotDao {
	/**
	 * ���������Ϣ
	 * @param Spot
	 * @return
	 */
	int saveSpot(Spot spot);
	/**
	 * ɾ��������Ϣ
	 * @param Spot
	 * @return
	 */
	int delSpot(Spot spot);
	/**
	 * ����������Ϣ
	 * @param Spot
	 * @return
	 */
	int updateSpot(Spot spot);
	/**
	 * ��ȡ���������б�
	 * @return
	 */
	List<Spot> getSpots();
	/**
	 * ��������ID��ȡ������Ϣ
	 * @param id
	 * @return
	 */
	Spot getSpotByid(String id);
	/**
	 * �������ű����ȡ�����б�(ģ����ѯ)
	 * @param name
	 * @return
	 */
	List<Spot> getSpotByTitle(String title);
	/**
	 * �����������ͻ�ȡ�����б�
	 * @param type
	 * @return
	 */
	List<Spot> getSpotsByType(int type);
	/**
	 * ��������������ȡ�����б�ģ����ѯ��
	 * @param author
	 * @return
	 */
	List<Spot> getSpotsByAuthor(String author);
	/**
	 * �������·���ʱ��λ�ȡ�����б�
	 * @param minTime
	 * @param maxTime
	 * @return
	 */
	List<Spot> getSpotsByTime(Date minTime,Date maxTime);
}
