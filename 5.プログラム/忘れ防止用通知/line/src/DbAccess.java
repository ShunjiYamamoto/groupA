import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

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
			String sql = "SELECT line_token,line_time FROM users WHERE line_notice_on = true";

			// create statement
			stmt = con.prepareStatement(sql);

			// execute
			ResultSet rs = stmt.executeQuery();

			// output
			while (rs.next()) {
				String token = rs.getString("line_token");
				Time time = rs.getTime("line_time");

				//System.out.println("token = " + token);
				//System.out.println("time = " + time);

				LineNotify.sub(token,time);


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
