import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DbAccess {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			// load JDBC Driver
			Class.forName("org.postgresql.Driver");

			// confirm
			//System.out.println(" --- before connection --- ");

			// database connect
			con = DriverManager.getConnection("jdbc:postgresql:sutebo", "axizuser", "axiz");

			// confirm
			//System.out.println(" --- after connection --- ");

			// SQL query string
			//String sql = "SELECT line_token,line_time FROM users WHERE line_notice_on = true";



			String sql = "SELECT user_id,line_token,line_time,line_day FROM users WHERE line_notice_on = true";

			// create statement
			stmt = con.prepareStatement(sql);

			// execute
			ResultSet rs = stmt.executeQuery();

			// output
			while (rs.next()) {
				String userId = rs.getString("user_id");
				String token = rs.getString("line_token");
				Time time = rs.getTime("line_time");
				Date date = rs.getDate("line_day");

				//日付フォーマットの設定
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				//インスタンス作成
				Calendar calendar = Calendar.getInstance();

				LineNotify.sub(token,time,date);

				//日付を+1してセット
				calendar.add(Calendar.DAY_OF_MONTH,1);
				date = calendar.getTime();

				// SQL query string
				String sql2 = "UPDATE users SET line_day='" + sdf.format(date) + "' WHERE user_id = '" + userId + "'";

				// create statement
				stmt = con.prepareStatement(sql2);

				stmt.executeUpdate();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
