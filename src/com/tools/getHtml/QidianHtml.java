package com.tools.getHtml;

public class QidianHtml {
	public String[] getInfo(String html){
		String[] chapter=new String[4];
		//		System.out.println(file);
		int start;
		int end;
		start=html.lastIndexOf("<li");
		end=html.lastIndexOf("</li>");
		//		System.out.println(file.substring(start, end));
		String chapters=html.substring(start, end);

		String time;
		String title;
		String txtBody;
		String booktitle;
		
		start=html.indexOf("《")+1;
		end=html.indexOf("》");
		booktitle=html.substring(start, end);
		booktitle=booktitle.replace("\r", "");
		booktitle=booktitle.replace("\n", "");

		start=chapters.indexOf("更新时间：2")+5;
		end=chapters.indexOf("  ", start);
		time=chapters.substring(start, end);

		start=end;
		end=chapters.indexOf("'", start);
		txtBody=chapters.substring(start, end);

		start=chapters.indexOf(">", end)+1;
		end=chapters.indexOf("<", start);
		title=chapters.substring(start, end);;


		//		System.out.println(time);
		//		System.out.println(title);
		//		System.out.println(txtBody);
//		System.out.println(booktitle);
		chapter[0]=time;
		chapter[1]=title;
		chapter[2]=txtBody;
		chapter[3]=booktitle;
		return chapter;
	}
}
