package com.merong.home.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.merong.home.dao.impl.HomeDaoImpl;
import com.merong.home.service.HomeService;
import com.merong.home.vo.HomeVo;

@Service
public class HomeServiceImpl implements HomeService{
	@Autowired
	private HomeDaoImpl homeDaoImpl;
	
	public List<HomeVo> selectBookMarkList() {
		return homeDaoImpl.selectBookMarkList();
	}
	
	@Override
	public void insertBookMark(HomeVo homeVo) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR, 9);
		homeVo.setDate(c.getTime());
		homeDaoImpl.insertBookMark(homeVo);
	}
	
}
