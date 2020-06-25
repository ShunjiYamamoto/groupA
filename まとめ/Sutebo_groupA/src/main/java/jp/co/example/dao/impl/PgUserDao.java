package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.UserDao;
import jp.co.example.entity.User;
@Repository
public class PgUserDao implements UserDao{
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public  List<User> passwordNameGet(String userId){
		String sql ="select user_name,password from users where user_id = :userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);

		List<User> resultList =jdbcTemplate.query(sql,param,new BeanPropertyRowMapper<User>(User.class));

		return resultList;
	}

	@Override
	public void updateUserName(String newUserName,String userId) {
		String sql ="update users set user_name =:newUserName where user_id = :userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("newUserName", newUserName);
		param.addValue("userId", userId);

		jdbcTemplate.update(sql, param);
	}

	@Override
	public void updatePassword(String newPassword,String userId) {
		String sql ="update users set password = :newPassword where user_id =:userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("newPassword",newPassword);
		param.addValue("userId", userId);

		jdbcTemplate.update(sql, param);
	}

	@Override
	public void updateDelete(String userId) {
		String sql ="update users set user_delete = true where user_id = :userId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);

		jdbcTemplate.update(sql, param);
	}


}
