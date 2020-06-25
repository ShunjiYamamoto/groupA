package jp.co.example.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.MoneyDao;
import jp.co.example.entity.ItemNameAndMoney;
import jp.co.example.entity.Money;


	@Repository
	public class PgMoneyDao implements MoneyDao {

		@Autowired
		private NamedParameterJdbcTemplate jdbcTemplate;

		private static final String SELECTMONEY = "select sum(amount) as amount from money group by input_date";
		private static final String SELECTDATANDMONEY = "select input_date, sum(amount) as amount "+
		"from money join items on money.items_id = items.items_id "+
				"where input_date between :DayStart and :DayEnd and users_id =:usersId and income_outgo = 2 "+
				"group by input_date order by input_date";

		private static final String SELECTAMOUNTLIST = "select amount from money";
		private static final String SELECTDAIRYDATA = "select item_name, amount " +
				"from items i " +
				"join money m " +
				"on i.items_id = m.items_id " +
				"where users_id = :usersId and input_date =:date";


		private static final String SELECT_TOTAL_ITEMS_OF_MONTH ="select item_name, sum(amount) as amount " +
				"from items " +
				"join money " +
				"on items.items_id = money.items_id " +
				"where users_id = :usersId and income_outgo = 2 and input_date between :DayStart and :DayEnd " +
				"group by item_name "+
				"order by amount desc";

		private static final String SELECT_TOTAL_INCOME_OF_MONTH = "select coalesce(sum(amount),0) as amount " +
				"from items i " +
				"join money m " +
				"on i.items_id = m.items_id " +
				"where users_id = :usersId and income_outgo = 1 and input_date between :DayStart and :DayEnd";

		private static final String SELECT_TOTAL_OUTGO_OF_MONTH = "select coalesce(sum(amount),0) as amount " +
				"from items i " +
				"join money m " +
				"on i.items_id = m.items_id " +
				"where users_id = :usersId and income_outgo = 2 and input_date between :DayStart and :DayEnd";

		// カレンダーに支出を表示するためにデータベースから値をとってくる。
			@Override
			public List<Money> findMoneyForCalendar(Integer usersId,Date dayStart, Date dayEnd){

				MapSqlParameterSource param = new MapSqlParameterSource();

				String sql = SELECTDATANDMONEY;
				System.out.println(sql);

				param.addValue("DayStart", dayStart);
				param.addValue("DayEnd", dayEnd);
				param.addValue("usersId", usersId);

				List<Money> resultList = jdbcTemplate.query(sql,param,
						new BeanPropertyRowMapper<Money>(Money.class));

				return resultList;
			}


		// 指定した日の項目と金額をデータベースからとってくる。
			@Override
			public List<ItemNameAndMoney> findDairyData(Integer usersId, String date){

				System.out.println("dao:"+date);
				System.out.println("dao:"+date);

				Date sqlDate = java.sql.Date.valueOf(date);

				System.out.println("date型:"+sqlDate);

				MapSqlParameterSource param = new MapSqlParameterSource();

				String sql = SELECTDAIRYDATA;

				param.addValue("usersId", usersId);
				param.addValue("date", sqlDate);

				List<ItemNameAndMoney> resultList = jdbcTemplate.query(sql, param,
						new BeanPropertyRowMapper<ItemNameAndMoney>(ItemNameAndMoney.class));

				return resultList;


			}

			@Override
			public List<ItemNameAndMoney> findMonthlyData(Integer usersId,Date dayStart, Date dayEnd){

				MapSqlParameterSource param = new MapSqlParameterSource();

				String sql = SELECT_TOTAL_ITEMS_OF_MONTH;

				param.addValue("DayStart", dayStart);
				param.addValue("DayEnd", dayEnd);
				param.addValue("usersId", usersId);

				List<ItemNameAndMoney> resultList = jdbcTemplate.query(sql,param,
						new BeanPropertyRowMapper<ItemNameAndMoney>(ItemNameAndMoney.class));

				return resultList;


			}

			@Override
			public List<Money> findToTalIncomeOfMonth(Integer usersId,Date dayStart, Date dayEnd){

				MapSqlParameterSource param = new MapSqlParameterSource();

				String sql = SELECT_TOTAL_INCOME_OF_MONTH;

				param.addValue("DayStart", dayStart);
				param.addValue("DayEnd", dayEnd);
				param.addValue("usersId", usersId);

				List<Money> resultList = jdbcTemplate.query(sql,param,
						new BeanPropertyRowMapper<Money>(Money.class));

				return resultList;

			}

			@Override
			public List<Money> findToTalOutgoOfMonth(Integer usersId,Date dayStart, Date dayEnd){

				MapSqlParameterSource param = new MapSqlParameterSource();

				String sql = SELECT_TOTAL_OUTGO_OF_MONTH;

				param.addValue("DayStart", dayStart);
				param.addValue("DayEnd", dayEnd);
				param.addValue("usersId", usersId);

				List<Money> resultList = jdbcTemplate.query(sql,param,
						new BeanPropertyRowMapper<Money>(Money.class));

				return resultList;

			}


		}

