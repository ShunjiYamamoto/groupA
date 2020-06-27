package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.YearDao;
import jp.co.example.entity.Year;

@Repository
public class PgYearDao implements YearDao{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Year> yearDate(int usersId){

		String sql ="select " +
				"substr(to_char(input_date,'YYYYMMDD'), 1, 4) years " +
				"from money m  " +
				"join items i on m.items_id = i.items_id  " +
				"where input_date between '1/01/01' and '99999/12/31' " +
				"and users_id = :usersId  " +
				"group by substr(to_char(input_date, 'YYYYMMDD'), 1, 4) ";


		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("usersId", usersId);

		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Year>(Year.class));

	}

}
