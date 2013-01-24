package com.merong.home.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.merong.home.dao.HomeDao;
import com.merong.home.vo.HomeVo;
import com.merong.home.vo.ScoreVo;
import com.merong.home.vo.SortVo;
import com.merong.home.vo.UserVo;

@Repository
public class HomeDaoImpl implements HomeDao{

	@Override
	public List<HomeVo> selectBookMarkList(SortVo sortVo) {
	
	    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	    Query query = new Query("TN_BOOKMARK").addSort("date", sortVo.getSortDirection());
	    
	    List<Entity> bookMarks = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(30));
        List<HomeVo> homeVoList = new ArrayList<HomeVo>();
        
        for (Entity bookmark : bookMarks) {
        	HomeVo homeVo = new HomeVo();
    		homeVo.setName((String) bookmark.getProperty("name"));
    		homeVo.setContent((String)bookmark.getProperty("content"));
    		homeVo.setDate((Date)bookmark.getProperty("date"));
    		homeVoList.add(homeVo);
        }

        return homeVoList;
	}

	@Override
	public void insertBookMark(HomeVo homeVo) {
		Key guestbookKey = KeyFactory.createKey("Guestbook", "1");
        
        Entity greeting = new Entity("TN_BOOKMARK", guestbookKey);
	    greeting.setProperty("name", homeVo.getName());
	    greeting.setProperty("content", homeVo.getContent());
	    greeting.setProperty("date", homeVo.getDate());
		
	    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(greeting);
	}

	@Override
	public List<ScoreVo> selectScoreHistoryList(SortVo sortVo) {
	    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	    Query query = new Query("TN_SCORE").addSort("date", sortVo.getSortDirection());
	    
	    List<Entity> scoreHistorys = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(9999));
        List<ScoreVo> scoreVoList = new ArrayList<ScoreVo>();
        
        for (Entity scoreHistory : scoreHistorys) {
        	ScoreVo scoreVo = new ScoreVo();
        	scoreVo.setWinner((String) scoreHistory.getProperty("winner"));
        	scoreVo.setLooser((String) scoreHistory.getProperty("looser"));
        	scoreVo.setWinnerScore((String) scoreHistory.getProperty("winnerScore"));
        	scoreVo.setLooserScore((String) scoreHistory.getProperty("looserScore"));
        	scoreVo.setDate((Date)scoreHistory.getProperty("date"));
        	scoreVoList.add(scoreVo);
        }

        return scoreVoList;
	}
	
	@Override
	public void insertScore(ScoreVo scoreVo) {
		Key scoreKey = KeyFactory.createKey("ScoreSeq", "1");
		
		Entity score = new Entity("TN_SCORE", scoreKey);
		score.setProperty("winner", scoreVo.getWinner());
		score.setProperty("looser", scoreVo.getLooser());
		score.setProperty("winnerScore", scoreVo.getWinnerScore());
		score.setProperty("looserScore", scoreVo.getLooserScore());
		score.setProperty("date", scoreVo.getDate());
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		datastore.put(score);
	}

	@Override
	public void insertUser(UserVo userVo) {
		Key userKey = KeyFactory.createKey("userSeq", "1");
        
        Entity user = new Entity("TN_USER", userKey);
        user.setProperty("name", userVo.getName());
        user.setProperty("date", userVo.getDate());
		
	    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(user);
	}
	
	@Override
	public List<UserVo> selectUserList(SortVo sortVo) {
	    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	    Query query = new Query("TN_USER").addSort("date", sortVo.getSortDirection());
	    
	    List<Entity> userLists = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(30));
        List<UserVo> userVoList = new ArrayList<UserVo>();
        
        for (Entity user : userLists) {
        	UserVo userVo = new UserVo();
        	userVo.setName((String)user.getProperty("name"));
        	userVo.setDate((Date)user.getProperty("date"));
        	userVoList.add(userVo);
        }

        return userVoList;
	}

	@Override
	public void deleteUser(UserVo userVo) {
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	    Query query = new Query("TN_USER");
	    query.addFilter("name", FilterOperator.EQUAL, userVo.getName());
	    PreparedQuery pq = datastore.prepare(query);
	    List<Entity> customer = pq.asList(FetchOptions.Builder.withLimit(9999));
	    
	    for(Entity entity : customer) {
	    	datastore.delete(entity.getKey()); //delete it
	    }
	    	
		
	}


}
