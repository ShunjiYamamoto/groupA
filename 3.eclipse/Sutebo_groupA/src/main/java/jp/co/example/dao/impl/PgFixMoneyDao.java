package jp.co.example.dao.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.FixMoneyDao;
import jp.co.example.entity.Money;

@Repository
public class PgFixMoneyDao implements FixMoneyDao{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;


	private static final String SELECT_BY_ITEMNAME_AND_USERSID_AND_INPUTDATE = "SELECT amount FROM items i JOIN money m ON i.items_id = m.items_id WHERE users_id = :usersId AND item_name = :itemName AND input_date = :inputDate";
	private static final String UPDATE = "UPDATE money m  SET amount =  :amount FROM items i LEFT OUTER JOIN users u ON u.users_id = i.users_id WHERE m.items_id = i.items_id AND input_date = :inputDate  AND u.users_id = :usersId AND i.item_name = :itemName" ;



	//取得情報
	@Override
	public Money findDairyAmount(Integer Id, String itemName, Date inputDate, Integer amount) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("itemName", itemName);
		param.addValue("usersId", Id);
		param.addValue("inputDate", inputDate);
		param.addValue("amount", amount);



		List<Money> resultList = jdbcTemplate.query(SELECT_BY_ITEMNAME_AND_USERSID_AND_INPUTDATE, param, new BeanPropertyRowMapper<Money>(Money.class));

		return resultList.isEmpty() ? null : resultList.get(0);
	}


	//更新
	@Override
	public void update(Integer Id, String itemName, Date inputDate) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("Id", Id);
		param.addValue("inputDate", inputDate);
		param.addValue("itemName", itemName);

		jdbcTemplate.update(UPDATE, param);
	}
}