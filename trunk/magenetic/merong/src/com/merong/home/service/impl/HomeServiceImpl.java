package com.merong.home.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merong.home.dao.impl.HomeDaoImpl;
import com.merong.home.service.HomeService;
import com.merong.home.vo.HomeVo;
import com.merong.home.vo.ScoreVo;
import com.merong.home.vo.SortVo;
import com.merong.home.vo.UserVo;

@Service
public class HomeServiceImpl implements HomeService{
	@Autowired
	private HomeDaoImpl homeDaoImpl;
	
	@Override
	public List<HomeVo> selectBookMarkList(SortVo sortVo) {
		return homeDaoImpl.selectBookMarkList(sortVo);
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
	public List<ScoreVo> selectScoreHistoryList(SortVo sortVo) {
		return homeDaoImpl.selectScoreHistoryList(sortVo);
	}

	@Override
	public List<ScoreVo> selectRankingList(SortVo sortVo) {
		List<ScoreVo> scoreVoList =  homeDaoImpl.selectScoreHistoryList(sortVo);
		
		List<String> winnerList = new ArrayList<String>();
		
		for(ScoreVo scoreVo: scoreVoList) {
			winnerList.add(scoreVo.getWinner());
			winnerList.add(scoreVo.getLooser());
		}
		
		List<ScoreVo> rankingInfoList = new ArrayList<ScoreVo>();
	
		List<UserVo> userList = homeDaoImpl.selectUserList(sortVo);
		for(UserVo userVo : userList) {
			String name = userVo.getName();
			int winCnt = 0;
			int defeatCnt = 0;
			int goalCnt = 0;
			int lostGoalCnt = 0;
			ScoreVo scoreVoForRanking = new ScoreVo();
		
			for(ScoreVo scoreVo: scoreVoList) {
				if(name.equals(scoreVo.getWinner())) {
					winCnt++;
					goalCnt += Integer.parseInt(scoreVo.getWinnerScore());
					lostGoalCnt += Integer.parseInt(scoreVo.getLooserScore());
				}
				if(name.equals(scoreVo.getLooser())) {
					defeatCnt++;
					goalCnt += Integer.parseInt(scoreVo.getLooserScore());
					lostGoalCnt += Integer.parseInt(scoreVo.getWinnerScore());
				}
				
				
			}
			
			scoreVoForRanking.setName(name);
			scoreVoForRanking.setWinCnt(winCnt);
			scoreVoForRanking.setDefeatCnt(defeatCnt);
			scoreVoForRanking.setTotalGoalCnt(goalCnt);
			scoreVoForRanking.setLostGoalCnt(lostGoalCnt);
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
	public List<UserVo> selectUserList(SortVo sortVo) {
		return homeDaoImpl.selectUserList(sortVo);
	}

	@Override
	public void deleteUser(UserVo userVo) {
		homeDaoImpl.deleteUser(userVo);
		
	}
	
	@Override
	public List<ScoreVo> selectChartByDate(SortVo sortVo) {
		List<ScoreVo> scoreVoList =  homeDaoImpl.selectScoreHistoryList(sortVo);
		List<ScoreVo> rankingInfoList = new ArrayList<ScoreVo>();
		
		long maxDay = 0l;
		long minDay = 0l;
		long beforeDay = 99999l;	
		for(ScoreVo scoreVo: scoreVoList) {
			Date scoreDate = scoreVo.getDate();
			long nextDay = scoreDate.getTime()/1000/60/60/24;
			if(nextDay > beforeDay) {
				maxDay = nextDay;
			}
			if(beforeDay > nextDay ) {
				minDay = nextDay;
			}
			beforeDay = nextDay;
		}
		
		//System.out.println(maxDay);
		//System.out.println(minDay);
		long gapDay = (maxDay-minDay)/5;
		//System.out.println(gapDay);
		
		int fromDay = 0;
		int toDay = (int) minDay;
		int temDay =(int) minDay;
		
		int k=0;
		for(int i=0; temDay <= maxDay; i++){
			
			toDay = temDay ;
			System.out.println(toDay);
			temDay = (int) (temDay + gapDay-1);
			fromDay = temDay;
			System.out.println(fromDay);
			
			
			
			k++;
			if(k>999) {
				break;
			}
		}
		
		List<UserVo> userList = homeDaoImpl.selectUserList(sortVo);
		
		int winCnt = 0;
		
		ScoreVo scoreVoForRanking = new ScoreVo();
		for(ScoreVo scoreVo: scoreVoList) {
			
			Date scoreDate = scoreVo.getDate();
			long days = scoreDate.getTime()/1000/60/60/24;
			
		
			if(days>=15718 && days<=15720){
				for(UserVo userVo : userList) {
					String name = userVo.getName();
					if(name.equals(scoreVo.getWinner())) {
						
							//System.out.println(scoreVo.getWinner() + "  |  " +  scoreVo.getDate() + "     |    " + days);
							winCnt++;
							
					}
					if(name.equals(scoreVo.getLooser())) {
						
					}

				}
			}
			
		}
		
		
		
		
		
		
	
		for(UserVo userVo : userList) {
			String name = userVo.getName();
			
			
			for(ScoreVo scoreVo: scoreVoList) {
				
				Date scoreDate = scoreVo.getDate();
				
				long days = scoreDate.getTime()/1000/60/60/24;
				
				if(name.equals(scoreVo.getWinner())) {
					if(days>=15716 && days<=15718){
						//System.out.println(scoreVo.getWinner() + "  |  " +  scoreVo.getDate() + "     |    " + days);
						winCnt++;
						
					}
				}
				if(name.equals(scoreVo.getLooser())) {

				}
				
				
			}
			//scoreVoForRanking.setDate(days);
			scoreVoForRanking.setName(name);
			scoreVoForRanking.setWinCnt(winCnt);
			rankingInfoList.add(scoreVoForRanking);
		}
		
		return rankingInfoList;
	}
	
}
