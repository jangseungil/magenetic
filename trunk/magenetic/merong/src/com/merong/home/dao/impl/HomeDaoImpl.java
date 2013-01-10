package com.merong.home.dao.impl;

import java.text.SimpleDateFormat;
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
import com.google.appengine.api.datastore.Query;
import com.merong.home.dao.HomeDao;
import com.merong.home.vo.HomeVo;

@Repository
public class HomeDaoImpl implements HomeDao{

	@Override
	public List<HomeVo> selectBookMarkList() {
	
	    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
	    Query query = new Query("TN_BOOKMARK").addSort("date", Query.SortDirection.DESCENDING);
	    
	    List<Entity> bookMarks = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(30));
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
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

}
