

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class LineNotify {

	public static void sub(String token,Time time, Date date2) throws ParseException{

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy/MM/dd");

		Timer timer = new Timer(false);

		//Date date = new Date();

		TimerTask task = new TimerTask() {

			@Override
			public void run() {

				String トークン = token;	//トークン
		        LineNotify lineNotify = new LineNotify(トークン);		//インスタンスの生成
		        lineNotify.notify("指定した時間になりました");	//通知内容

				timer.cancel();
			}
		};

		timer.schedule(task, (sdf.parse(sdf2.format(date2) + " " + time)));

	}
	    private final String token;

	    //コンストラクト
	    public LineNotify(String token) {
	        this.token = token;
	    }

	    public void notify(String message) {
	        HttpURLConnection connection = null;
	        try {
	            URL url = new URL("https://notify-api.line.me/api/notify");		//Line NotifyのURL
	            //コネクションの設定
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

	        	System.out.println("エラーが発生しました");

	        } finally {
	            if (connection != null) {
	                connection.disconnect();
	            }
	        }
	    }

	}