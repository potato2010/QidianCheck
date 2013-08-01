package com.tools.mail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.tools.databases.AdminInfo;
/**
 * @author admin
 *
 */
public class EMailSSL {
	private  String  mailAddress="";
	private  String mailSubject="";
	private  String mailText="";
	/**发送邮件（gmail）
	 * @param mailAddress 收件人地址，地址之间用英文逗号间隔
	 * @param mailSubject 邮件主题
	 * @param mailText 邮件正文
	 */
	public EMailSSL(String mailAddress,String mailSubject,String mailText){
		this.mailAddress=mailAddress;
		this.mailSubject=mailSubject;
		this.mailText=mailText;
	}

	/**发送邮件
	 * @param tryTimes 尝试次数，最小值应为1
	 */
	public  boolean sendMail(int tryTimes){
		boolean sended=false;
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);



			Message msg = new MimeMessage(session);
			try {
				//					UserService userService = UserServiceFactory.getUserService();
				//					String email = userService.getCurrentUser().getEmail();
				AdminInfo adminInfo=new AdminInfo();
				adminInfo.init();
				if(adminInfo.getAdminMail().length()<5){
					adminInfo.save();
				}else{
					msg.setFrom(new InternetAddress(adminInfo.getAdminMail()));
					msg.addRecipients(Message.RecipientType.TO,
							InternetAddress.parse(this.mailAddress));
					this.mailSubject=MimeUtility.encodeText(this.mailSubject,"utf-8","B");
					msg.setSubject(this.mailSubject);
					msg.setText(this.mailText);
					Transport.send(msg);

					sended=true;
				}

			} catch (AddressException e) {
				// TODO 自动生成的 catch 块

				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO 自动生成的 catch 块

				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}

		return sended;
	}
}