package com.tools.databases;
import com.google.appengine.api.datastore.*;
import com.google.appengine.api.datastore.Query.*;


public class BookInfo {
	String bookID="";
	String mail="";
	long time=0;
	String booktitle="";
	String title="";
	String txtBody="";
	String updateTime="";
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTxtBody() {
		return txtBody;
	}
	public void setTxtBody(String txtBody) {
		this.txtBody = txtBody;
	}

	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}

	public void init(String bookID)
	{
		this.bookID=bookID;
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		// Use class Query to assemble a query
		Query q = new Query(this.bookID);
		// Use PreparedQuery interface to retrieve results
		PreparedQuery pq = datastore.prepare(q);
		for (Entity result : pq.asIterable()) {
			this.time = (Long) result.getProperty("time");
//			System.out.println("time:"+time);
			this.mail = (String) result.getProperty("mail");
//			System.out.println("mail:"+mail);
		}
	}
	public void save(){
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

		Entity book = new Entity(this.bookID,this.bookID);
		book.setProperty("type", "book");
		book.setProperty("mail", this.mail);
		book.setProperty("time", this.time);
		book.setProperty("bookID", this.bookID);
		book.setProperty("booktitle", this.booktitle);
		book.setProperty("title", this.title);
		book.setProperty("txtBody", this.txtBody);
		book.setProperty("updateTime", this.updateTime);
		datastore.put(book);
		System.out.println("data saved");
	}
//	public long select(String checkName){
//		long time=0;
//
//
//		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
//
//		// Use class Query to assemble a query
//		Query q = new Query(checkName);
//
//		// Use PreparedQuery interface to retrieve results
//		PreparedQuery pq = datastore.prepare(q);
//
//
//		for (Entity result : pq.asIterable()) {
//
//			time = (Long) result.getProperty("time");
//
////			System.out.println("time:"+time);
//		}
//
//		return time;
//	}
}
