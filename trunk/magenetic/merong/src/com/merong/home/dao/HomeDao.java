package com.merong.home.dao;

import java.util.List;

import com.merong.home.vo.HomeVo;
import com.merong.home.vo.ScoreVo;
import com.merong.home.vo.UserVo;

public interface HomeDao {
	List<HomeVo> selectBookMarkList();
	
	void insertBookMark(HomeVo homeVo);
	
	void insertScore(ScoreVo scoreVo);
	
	List<ScoreVo> selectScoreHistoryList();
	
	void insertUser(UserVo userVo);
	
	List<UserVo> selectUserList();
	
	void deleteUser(UserVo userVo);
	
}