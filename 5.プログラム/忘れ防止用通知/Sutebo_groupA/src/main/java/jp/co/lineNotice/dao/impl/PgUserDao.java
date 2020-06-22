package jp.co.lineNotice.dao.impl;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.lineNotice.dao.UserDao;
import jp.co.lineNotice.entity.User;

@Repository
public class PgUserDao implements UserDao {

	@Autowired
	//private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public String findByToken(String userId) {


		String sql = "SELECT line_token FROM users WHERE user_id =:userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);

		List<User> resultList = jdbcTemplate.query(sql, param,new BeanPropertyRowMapper<User>(User.class));

		String lineToken = resultList.get(0).getLineToken();

		return resultList.isEmpty() ? null : lineToken;

	}

	@Override
	public int update(String userId,String lineToken,Integer hour,Integer minute,boolean lineNoticeOn) {

		String sql = "UPDATE users SET line_token = :lineToken,line_time = :lineTime,"
				+ "	line_notice_on = :lineNoticeOn  WHERE user_id = :userId";

		Time lineTime = new Time(hour,minute,0);

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("lineToken", lineToken);
		param.addValue("lineTime",lineTime);
		param.addValue("lineNoticeOn", lineNoticeOn);
		param.addValue("userId", userId);

		return jdbcTemplate.update(sql, param);

	}
}
