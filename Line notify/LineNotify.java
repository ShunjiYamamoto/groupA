package sampleTest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class LineNotify {

	    public static void main(String[] args) {
	        String トークン = "mDB3HoDS7yJhLF6D0FSWB7AxzHCZM6JJdO2qN330DPB";
	        LineNotify lineNotify = new LineNotify(トークン);
	        lineNotify.notify("テスト");
	    }

	    private final String token;

	    public LineNotify(String token) {
	        this.token = token;
	    }

	    public void notify(String message) {
	        HttpURLConnection connection = null;
	        try {
	            URL url = new URL("https://notify-api.line.me/api/notify");
	            connection = (HttpURLConnection) url.openConnection();
	            connection.setDoOutput(true);
	            connection.setRequestMethod("POST");
	            connection.addRequestProperty("Authorization", "Bearer " + token);
	            try (OutputStream os = connection.getOutputStream();
	                 PrintWriter writer = new PrintWriter(os)) {
	                writer.append("message=").append(URLEncoder.encode(message, "UTF-8")).flush();
	                try (InputStream is = connection.getInputStream();
	                     BufferedReader r = new BufferedReader(new InputStreamReader(is))) {

	                }
	            }
	        } catch (Exception ignore) {

	        	System.out.println("エラーが発生した");

	        } finally {
	            if (connection != null) {
	            	System.out.println("通信に失敗しました");
	                connection.disconnect();
	            }
	        }
	    }

	}