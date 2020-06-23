package jp.co.lineNotice.timer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import jp.co.lineNotice.dao.impl.PgUserDao;
import jp.co.lineNotice.entity.User;
import jp.co.lineNotice.util.DbUtil;

public class LineNoticeTimer {

	public static void subAll() throws ParseException{

			sub();
	}

	public static void sub() throws ParseException{

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Timer timer = new Timer(false);

        Connection connection = DbUtil.getConnection();
        PgUserDao info = new PgUserDao(connection);
        List<User> line = info.findAllToken();

        for (User u : line) {
        	System.out.println(u);
        }


		TimerTask task = new TimerTask() {

			@Override
			public void run() {

				String トークン = "PFZhYRVOV8x8Bbpgrk8afxoHeHZlDJyBZtgMitNpU6B";	//トークン
		        LineNoticeTimer lineNotify = new LineNoticeTimer(トークン);		//インスタンスの生成
		        lineNotify.notify("テスト");	//通知内容

				System.out.println("てすと");
				timer.cancel();
			}
		};

		timer.schedule(task, sdf.parse("2020/06/23 10:24:00"));

	}

	public static void sub2(int a) throws ParseException{

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Timer timer = new Timer(false);

		TimerTask task = new TimerTask() {

			@Override
			public void run() {

				String トークン = "PFZhYRVOV8x8Bbpgrk8afxoHeHZlDJyBZtgMitNpU6B";	//トークン
		        LineNoticeTimer lineNotify = new LineNoticeTimer(トークン);		//インスタンスの生成
		        lineNotify.notify("テスト");	//通知内容

				System.out.println("てすと");
				timer.cancel();
			}
		};

		timer.schedule(task, sdf.parse("2020/06/23 09:29:0" + a));

	}

	  private final String token;

	    //コンストラクト
	    public LineNoticeTimer(String token) {
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
