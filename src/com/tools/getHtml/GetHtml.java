package com.tools.getHtml;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;
import java.io.IOException;

public class GetHtml {

	public String getURL(String urlSrt){
		try {
			URL url = new URL(urlSrt);
			URLConnection urlConnection = url.openConnection(); 
			urlConnection.setConnectTimeout(10000);
			urlConnection.setReadTimeout(10000);
			
			InputStream in=urlConnection.getInputStream();
			String getHtml=inputStream2String(in);
//System.out.println(getHtml);
			return getHtml;
		} catch (MalformedURLException e) {
			// ...
		} catch (IOException e) {
			// ...
		}
		return "null";
	}
	private String inputStream2String (InputStream in) throws IOException {
		StringBuffer out = new StringBuffer();
		byte[] buffer = new byte[4096];
		for (int n; (n = in.read(buffer)) != -1;) {
			out.append(new String(buffer, 0, n,"UTF-8"));
		}
		return out.toString();
	}
}
