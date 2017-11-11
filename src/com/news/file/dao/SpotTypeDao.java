package com.news.file.dao;

import java.util.List;

import com.news.file.bean.Spot;
import com.news.file.bean.SpotType;

public interface SpotTypeDao {
	/**
	 * �������������Ϣ
	 * @param SpotType
	 * @return
	 */
	int saveSpotType(SpotType spotType);
	/**
	 * ɾ������������Ϣ
	 * @param SpotType
	 * @return
	 */
	int delSpotType(SpotType spotType);
	/**
	 * ��������������Ϣ
	 * @param SpotType
	 * @return
	 */
	int updateSpotType(SpotType spotType);
	/**
	 * ��ȡ�������������б�
	 * @return
	 */
	List<SpotType> getSpotTypes();
	/**
	 * ��������ID��ȡ����������Ϣ
	 * @param id
	 * @return
	 */
	SpotType getSpotTypeByid(String id);
	/**
	 * �������ű����ȡ���������б�(ģ����ѯ)
	 * @param name
	 * @return
	 */
	SpotType getSpotTypeByName(String name);
}
