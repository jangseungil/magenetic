package com.merong.home.dao;

import java.util.List;

import com.merong.home.vo.HomeVo;
import com.merong.home.vo.ScoreVo;

public interface HomeDao {
	List<HomeVo> selectBookMarkList();
	
	void insertBookMark(HomeVo homeVo);
	
	void insertScore(ScoreVo scoreVo);
	
	
}
