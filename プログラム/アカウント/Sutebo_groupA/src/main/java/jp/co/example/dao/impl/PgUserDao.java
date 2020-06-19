package jp.co.example.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.UserDao;
import jp.co.example.entity.User;

@Repository
public class PgUserDao implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public User findById(String userId) {

		String sql = "SELECT * FROM users WHERE user_id =:userId";

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, userId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new User(rs.getString("user_id"), rs.getString("user_name"), rs.getString("password"));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return null;

	}

	public void insert(String userId,String userName,String password) {

		String sql = ("INSERT INTO users VALUES(:userId,:userName,password"));

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", userId);
		param.addValue("userName", userName);
		param.addValue("password", password);

	}

	@Override
	public User findById() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public int insert() {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}
}
