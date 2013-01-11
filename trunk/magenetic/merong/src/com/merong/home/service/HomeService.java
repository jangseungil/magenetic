package com.merong.home.service;

import java.util.List;

import com.merong.home.vo.HomeVo;
import com.merong.home.vo.ScoreVo;

public interface HomeService {
	List<HomeVo> selectBookMarkList();
	
	void insertBookMark(HomeVo homeVo);
	
	void insertScore(ScoreVo scoreVo);
	
	List<ScoreVo> selectScoreHistoryList();
	
	List<ScoreVo> selectRankingList();
	
}
