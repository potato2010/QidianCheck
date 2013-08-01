package checkbook;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.tools.databases.BookInfo;
import com.tools.getHtml.GetHtml;
import com.tools.getHtml.QidianHtml;
import com.tools.mail.EMailSSL;

public class CheckBook {
	public BookInfo check(BookInfo bookInfo){

		GetHtml gh=new GetHtml();
		String html;
		String[] chapter=null;
		for(int i=1;i<=20;){
			try{
				html=gh.getURL("http://read.qidian.com/BookReader/"+bookInfo.getBookID()+".aspx");
				QidianHtml qh=new QidianHtml();
				chapter=qh.getInfo(html);
				i=i+100;
			}catch (Exception e){
				i++;
				System.out.println("连接失败，重新尝试连接。");
			}
		}



		DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = null; 
		long lastUpdate=bookInfo.getTime();
		try {
			date = format.parse(chapter[0]);
			lastUpdate=date.getTime();
			
			bookInfo.setBooktitle(chapter[3]);
			bookInfo.setTitle(chapter[1]);
			bookInfo.setUpdateTime(chapter[0]);
			bookInfo.setTxtBody(chapter[2]);
			if(bookInfo.getTime()<lastUpdate){
				bookInfo.setTime(lastUpdate);
				bookInfo.save();
				if(bookInfo.getMail().length()>1){
					EMailSSL email=new EMailSSL(bookInfo.getMail(),"[更新提醒]"+chapter[3]+" "+chapter[1]+" 更新时间："+chapter[0],chapter[2]);
					if(email.sendMail(3)){
						System.out.println("邮件发送成功");
					};
				}
			}else{
				System.out.println("time same");
			}

		} catch (ParseException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}  


		return bookInfo;
	}
}
