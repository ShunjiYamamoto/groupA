package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.ItemDao;
import jp.co.example.entity.Item;

@Repository
public class PgItemDao implements ItemDao {

	@Autowired
	public NamedParameterJdbcTemplate jdbcTemp;

	@Override
	public List<Item> itemsAllFindForUserId(String usersId,Integer incomeOrOutgo) {
		final String ITEM_FIND_FOR_USERID = "select * from items where users_id = :usersId and income_outgo = :incomeOrOutgo";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("usersId", (Integer)Integer.parseInt(usersId));
		param.addValue("incomeOrOutgo", incomeOrOutgo);

		List<Item> result = jdbcTemp.query(ITEM_FIND_FOR_USERID, param, new BeanPropertyRowMapper<Item>(Item.class));
		return result;
	}

	@Override
	public List<Item> itemNameFindForItemsId(String itemsId) {
		final String ITEMNAME_FIND_FOR_ITEMSID = "select item_name from items where items_id = :itemsId";
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("itemsId",(Integer)Integer.parseInt(itemsId));
		List<Item> result = jdbcTemp.query(ITEMNAME_FIND_FOR_ITEMSID,param,new BeanPropertyRowMapper<Item>(Item.class));
		return result;
	}

}