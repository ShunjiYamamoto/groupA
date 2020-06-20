package jp.co.lineNotice.dao.impl;

import java.security.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.lineNotice.controller.form.LineNoticeForm;
import jp.co.lineNotice.dao.UserDao;
import jp.co.lineNotice.entity.User;

@Repository
public class PgUserDao implements UserDao {

	@Autowired
	//private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate jdbcTemplate;

	public User findById(String userId) {

		String sql = "SELECT * FROM users WHERE user_id =:userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);

		List<User> resultList = jdbcTemplate.query(sql, param,new BeanPropertyRowMapper<User>(User.class));

		return resultList.isEmpty() ? null : resultList.get(0);

	}

	public int insert( String userId,String userName,String password,
						String lineToken,Timestamp lineTime,boolean lineNoticeOn) {

		String sql = "INSERT INTO users(user_id, user_name,password,line_token, line_time,line_notice_on) "
				+ "		VALUES (:userId, :userName, :password,:lineToken, :lineTime, :lineNoticeOn)";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);
		param.addValue("userName", userName);
		param.addValue("password", password);
		param.addValue("lineToken", lineToken);
		param.addValue("lineTime", lineTime);
		param.addValue("lineNoticeOn", lineNoticeOn);

		return jdbcTemplate.update(sql, param);

	}

	public int update(User user) {

		String sql = "INSERT INTO users(user_id, user_name,password,line_token, line_time,line_notice_on) "
				+ "		VALUES (:userId, :userName, :password,:lineToken, :lineTime, :lineNoticeOn)";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("lineToken", LineNoticeForm.getLineToken());

		return jdbcTemplate.update(sql, param);

	}
}
