package com.tools.databases;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

public class AdminInfo {
	String adminMail="";
	public String getAdminMail() {
		return adminMail;
	}

	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}

	public void init()
	{

		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		// Use class Query to assemble a query
		Query q = new Query("adminInfo");
		// Use PreparedQuery interface to retrieve results
		PreparedQuery pq = datastore.prepare(q);
		for (Entity result : pq.asIterable()) {
			this.adminMail = (String) result.getProperty("adminMail");
//			System.out.println("adminMail:"+adminMail);

		}
	}
	
	public void save(){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		Entity adminInfo = new Entity("adminInfo","adminInfo");
		adminInfo.setProperty("adminMail", "");

		datastore.put(adminInfo);
		System.out.println("data saved");
	}
}
