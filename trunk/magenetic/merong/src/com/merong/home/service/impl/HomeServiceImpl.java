package com.merong.home.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
