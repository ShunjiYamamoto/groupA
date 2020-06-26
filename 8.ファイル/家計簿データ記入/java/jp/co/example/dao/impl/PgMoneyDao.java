package jp.co.example.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.MoneyDao;
import jp.co.example.form.InputMoneyForm;

@Repository
public class PgMoneyDao implements MoneyDao {

	@Autowired
	public NamedParameterJdbcTemplate jdbcTemp;

	@Override
	public void moneyInsert(InputMoneyForm form) {
		final String MONEY_INSERT_SQL = "insert into money(input_date,items_id,amount) values (:date ,:itemId ,:amount ) ";
		MapSqlParameterSource param = new MapSqlParameterSource();

		param.addValue("date", form.getDate());
		param.addValue("itemId", form.getItemsId());
		param.addValue("amount", form.getAmount());


		jdbcTemp.update(MONEY_INSERT_SQL, param);

	}

}
