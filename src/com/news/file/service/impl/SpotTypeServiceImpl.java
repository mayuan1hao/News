package com.news.file.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.jms.Topic;

import com.news.file.bean.Spot;
import com.news.file.bean.SpotType;
import com.news.file.dao.SpotDao;
import com.news.file.dao.SpotTypeDao;
import com.news.file.dao.impl.SpotDaoImpl;
import com.news.file.dao.impl.SpotTypeDaoImpl;
import com.news.file.service.SpotTypeService;

public class SpotTypeServiceImpl implements SpotTypeService{

	@Override
	public List<SpotType> findAllSpotType() {
		SpotTypeDao sTypeDao = new SpotTypeDaoImpl();
		List<SpotType> spotTypes=sTypeDao.getSpotTypes();
		return spotTypes;
	}

	@Override
	public int updateSpotType(SpotType spotType) {
		SpotTypeDao sTypeDao = new SpotTypeDaoImpl();
		int result ;
		SpotType sType = sTypeDao.getSpotTypeByName(spotType.getnTname());
		if(sType==null){
			sTypeDao.updateSpotType(spotType);
			result = 1;
		}else {
			result = 0;
		}
		return result;
	}

	@Override
	public int addSpotType(String name) {
		SpotTypeDao sTypeDao = new SpotTypeDaoImpl();
		SpotType spotType = new SpotType();
		spotType.setnTname(name);
		int result ;
		SpotType sType = sTypeDao.getSpotTypeByName(name);
		if(sType==null){
			sTypeDao.saveSpotType(spotType);
			result = 1;
		}else {
			result = 0;
		}
		return result;
	}

	@Override
	public int delSpotType(String tid) {
		SpotTypeDao sTypeDao = new SpotTypeDaoImpl();
		SpotDao spotDao = new SpotDaoImpl();
		SpotType spotType = new SpotType();
		spotType.setnTid(tid);
		int result;
		List<Spot> spots = spotDao.getSpotsByType(Integer.parseInt(tid));
		if (spots.size()==0) {
			if (sTypeDao.delSpotType(spotType)>0) {
				result=1;
			}else {
				result=0;
			}
		}else {
			result=-1;
		}
		return result;
	}

	@Override
	public SpotType findSpotTypeByname(String name) {
		SpotTypeDao sTypeDao = new SpotTypeDaoImpl();
		SpotType spotType = sTypeDao.getSpotTypeByName(name);
		return spotType;
	}
}
