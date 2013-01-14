package com.merong.home.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merong.home.dao.impl.HomeDaoImpl;
import com.merong.home.service.HomeService;
import com.merong.home.vo.HomeVo;
import com.merong.home.vo.ScoreVo;
import com.merong.home.vo.UserVo;

@Service
public class HomeServiceImpl implements HomeService{
	@Autowired
	private HomeDaoImpl homeDaoImpl;
	
	@Override
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

	@Override
	public void insertScore(ScoreVo scoreVo) {
		
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR, 9);
		scoreVo.setDate(c.getTime());
		
		int score1= Integer.parseInt(scoreVo.getScore1());
		int score2= Integer.parseInt(scoreVo.getScore2());
		

		int i = 0;
		for(String name : scoreVo.getParamName()) {
			
			if(i==0) {
				if(score1 > score2) {
					scoreVo.setWinner(name);
					scoreVo.setWinnerScore(scoreVo.getScore1());
				} else if(score1 < score2) {
					scoreVo.setLooser(name);
					scoreVo.setLooserScore(scoreVo.getScore1());
				}
			} else {
				if(score2 > score1) {
					scoreVo.setWinner(name);
					scoreVo.setWinnerScore(scoreVo.getScore2());
				} else if(score2 < score1) {
					scoreVo.setLooser(name);
					scoreVo.setLooserScore(scoreVo.getScore2());
				}
			}

			i++;
		}
		homeDaoImpl.insertScore(scoreVo);
	}

	@Override
	public List<ScoreVo> selectScoreHistoryList() {
		return homeDaoImpl.selectScoreHistoryList();
	}

	@Override
	public List<ScoreVo> selectRankingList() {
		List<ScoreVo> scoreVoList =  homeDaoImpl.selectScoreHistoryList();
		
		List<String> winnerList = new ArrayList<String>();
		
		for(ScoreVo scoreVo: scoreVoList) {
			winnerList.add(scoreVo.getWinner());
			winnerList.add(scoreVo.getLooser());
		}
		
		List<String> uniqueWinnerList = new ArrayList<String>(new HashSet<String>(winnerList));
		List<ScoreVo> rankingInfoList = new ArrayList<ScoreVo>();
	
		List<UserVo> userList = homeDaoImpl.selectUserList();
		for(UserVo userVo : userList) {
			String name = userVo.getName();
			int winCnt = 0;
			int defeatCnt = 0;
			ScoreVo scoreVoForRanking = new ScoreVo();
		
			for(ScoreVo scoreVo: scoreVoList) {
				if(name.equals(scoreVo.getWinner())) {
					winCnt++;
				}
				if(name.equals(scoreVo.getLooser())) {
					defeatCnt++;
				}
			}
			scoreVoForRanking.setName(name);
			scoreVoForRanking.setWinCnt(winCnt);
			scoreVoForRanking.setDefeatCnt(defeatCnt);
			rankingInfoList.add(scoreVoForRanking);
		}
		
		for(ScoreVo scoreVo: rankingInfoList) {
			int rank = 1;
			int winCnt = scoreVo.getWinCnt();
			for(ScoreVo scoreVo2: rankingInfoList) {
				if(winCnt < scoreVo2.getWinCnt()) {
					rank++;
				}
			}
			scoreVo.setRank(String.valueOf(rank));
		}
		
		Collections.sort(rankingInfoList);
		//Collections.reverse(rankingInfoList); //역순
		return rankingInfoList;
	}

	@Override
	public void insertUser(UserVo userVo) {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR, 9);
		userVo.setDate(c.getTime());
		homeDaoImpl.insertUser(userVo);
	}

	@Override
	public List<UserVo> selectUserList() {
		return homeDaoImpl.selectUserList();
	}

	@Override
	public void deleteUser(UserVo userVo) {
		homeDaoImpl.deleteUser(userVo);
		
	}
	
}
