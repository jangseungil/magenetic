package com.merong.home.dao;

import java.util.List;

import com.merong.home.vo.HomeVo;
import com.merong.home.vo.ScoreVo;
import com.merong.home.vo.SortVo;
import com.merong.home.vo.UserVo;

public interface HomeDao {
	List<HomeVo> selectBookMarkList(SortVo sortVo);
	
	void insertBookMark(HomeVo homeVo);
	
	void insertScore(ScoreVo scoreVo);
	
	List<ScoreVo> selectScoreHistoryList(SortVo sortVo);
	
	void insertUser(UserVo userVo);
	
	List<UserVo> selectUserList(SortVo sortVo);
	
	void deleteUser(UserVo userVo);
	
}
