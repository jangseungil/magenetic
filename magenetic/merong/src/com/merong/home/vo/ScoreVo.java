package com.merong.home.vo;

import java.util.Date;

public class ScoreVo implements Comparable<ScoreVo>{
	
	private String[] paramName;
	
	private String rank;
	
	private String name;
	
	private int winCnt;
	
	private int defeatCnt;
	
	private String score;
	
	private String gubun;
	
	private Date date;
	
	private String winner;
	
	private String looser;
	
	private String winnerScore;
	
	private String looserScore;
	
	private String score1;
	
	private String score2;
	
	private int totalGoalCnt;
	
	private int lostGoalCnt;
	
	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String[] getParamName() {
		return paramName;
	}

	public void setParamName(String[] paramName) {
		this.paramName = paramName;
	}

	public String getGubun() {
		return gubun;
	}

	public void setGubun(String gubun) {
		this.gubun = gubun;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String getLooser() {
		return looser;
	}

	public void setLooser(String looser) {
		this.looser = looser;
	}

	public String getWinnerScore() {
		return winnerScore;
	}

	public void setWinnerScore(String winnerScore) {
		this.winnerScore = winnerScore;
	}

	public String getLooserScore() {
		return looserScore;
	}

	public void setLooserScore(String looserScore) {
		this.looserScore = looserScore;
	}

	public String getScore1() {
		return score1;
	}

	public void setScore1(String score1) {
		this.score1 = score1;
	}

	public String getScore2() {
		return score2;
	}

	public void setScore2(String score2) {
		this.score2 = score2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWinCnt() {
		return winCnt;
	}

	public void setWinCnt(int winCnt) {
		this.winCnt = winCnt;
	}

	public int getDefeatCnt() {
		return defeatCnt;
	}

	public void setDefeatCnt(int defeatCnt) {
		this.defeatCnt = defeatCnt;
	}

	@Override
	public int compareTo(ScoreVo o) {
		return rank.compareTo(o.getRank());
	
	}

	public int getTotalGoalCnt() {
		return totalGoalCnt;
	}

	public void setTotalGoalCnt(int totalGoalCnt) {
		this.totalGoalCnt = totalGoalCnt;
	}

	public int getLostGoalCnt() {
		return lostGoalCnt;
	}

	public void setLostGoalCnt(int lostGoalCnt) {
		this.lostGoalCnt = lostGoalCnt;
	}

}
