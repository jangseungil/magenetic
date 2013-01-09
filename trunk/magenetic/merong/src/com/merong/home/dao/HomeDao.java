package com.merong.home.dao;

import java.util.List;

import com.merong.home.vo.HomeVo;

public interface HomeDao {
	List<HomeVo> selectBookMarkList();
	
}
