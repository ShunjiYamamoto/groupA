package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.NoticeMonthDao;
import jp.co.example.entity.MonthSum;

@Repository
public class PgNoticeMonthDao implements NoticeMonthDao{

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<MonthSum> monthDateIncomeSpending(int usersId){

		String sql ="select s.month_date,coalesce(month_income,0) month_income, coalesce(month_spending,0) month_spending,coalesce(month_income_spending_difference,0) month_income_spending_difference from " +
				"(select '01' month_date " +
				"union  " +
				"select '02' " +
				"union  " +
				"select '03' " +
				"union  " +
				"select '04' " +
				"union  " +
				"select '05' " +
				"union  " +
				"select '06' " +
				"union  " +
				"select '07' " +
				"union  " +
				"select '08' " +
				"union  " +
				"select '09' " +
				"union  " +
				"select '10' " +
				"union  " +
				"select '11' " +
				"union  " +
				"select '12') s " +
				"left join " +
				"(select " +
				" substr(to_char(input_date,'YYYYMMDD'), 5, 2) month_date " +
				", sum(  " +
				"        case  " +
				"		    when income_outgo = 1 then amount  " +
				"			else 0  " +
				"		end) month_income " +
				", sum(  " +
				"    case  " +
				"		when income_outgo = 2 then amount  " +
				"		else 0  " +
				"	 end) month_spending " +
				", sum(  " +
				"    case  " +
				"		when income_outgo = 1 then amount  " +
				"		when income_outgo = 2 then amount * -1 " +
				"	 end) month_income_spending_difference " +
				"from money m " +
				"join items i on m.items_id = i.items_id  " +
				"where input_date between '2020/01/01' and '2020/12/31' " +
				"and users_id = :usersId " +
				"group by substr(to_char(input_date, 'YYYYMMDD'), 5, 2)) t " +
				" " +
				"on s.month_date =t.month_date " +
				"order by month_date";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("usersId", usersId);

		List<MonthSum> resultList =jdbcTemplate.query(sql,param,new BeanPropertyRowMapper<MonthSum>(MonthSum.class));

		return resultList;
	}

	@Override
	public List<MonthSum> monthSum(int usersId){

		String sql ="select  " +
				"sum( " +
				"		case " +
				"			when income_outgo = 1 then amount " +
				"			else 0" +
				"		end)month_income_sum " +
				",sum( " +
				"		case " +
				"			when income_outgo = 2 then amount " +
				"			else 0 " +
				"		end)month_spending_sum " +
				",sum( " +
				"		case " +
				"			when income_outgo = 1 then amount " +
				"			when income_outgo = 2 then amount * -1 " +
				"		end)month_income_spending_difference_sum " +
				"from money m  " +
				"join items i on m.items_id = i.items_id " +
				"where input_date between '2020/01/01' and '2020/12/31' " +
				"and users_id = :usersId ";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("usersId", usersId);

		List<MonthSum> resultList =jdbcTemplate.query(sql,param,new BeanPropertyRowMapper<MonthSum>(MonthSum.class));

		return resultList;
	}



}
