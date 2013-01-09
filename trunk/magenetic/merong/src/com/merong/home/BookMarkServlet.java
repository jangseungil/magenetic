package com.merong.home;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@SuppressWarnings("serial")
public class BookMarkServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/plain");
		resp.getWriter().println("Hello, world");
		
        Key guestbookKey = KeyFactory.createKey("Guestbook", "1");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR, 9);
        
        Entity greeting = new Entity("TN_BOOKMARK", guestbookKey);
	    greeting.setProperty("name", req.getParameter("name"));
	    greeting.setProperty("content", req.getParameter("content"));
	    greeting.setProperty("date", c.getTime());
		
	    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(greeting);
        
        /*
        Query query = new Query("Greeting", guestbookKey).addSort("date", Query.SortDirection.DESCENDING);
        
        List<Entity> greetings = datastore.prepare(query).asList(FetchOptions.Builder.withLimit(5));
        
        
        for (Entity greeting1 : greetings) {
        	System.out.println(   greeting1.getProperty("content"));
        
  
        }
        
        */
        
        resp.sendRedirect("/Melong.jsp");
        
        
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
	}
	
}
