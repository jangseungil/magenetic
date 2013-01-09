package com.merong.home;
import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MerongServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		/*
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Query query = new Query("TN_BOOKMARK").addSort("date", Query.SortDirection.DESCENDING);
        
        List<Entity> greetings = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(2));
        
        
        for (Entity greeting1 : greetings) {
        	System.out.println(   greeting1.getProperty("name"));
        	System.out.println(   greeting1.getProperty("content"));
        	System.out.println(   greeting1.getProperty("date"));
        }
        */
        resp.sendRedirect("/Melong.jsp");
        
	}
}
