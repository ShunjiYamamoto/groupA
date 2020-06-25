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
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<Item> findByIdAndIncomeOutgoAndNotDelete(Integer usersId, Integer incomeOutgo){
		String sql = "SELECT * FROM items WHERE users_id = :usersId AND income_outgo = :incomeOutgo AND item_delete = FALSE ORDER BY items_id";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("usersId", usersId);
		param.addValue("incomeOutgo", incomeOutgo);

		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Item>(Item.class));
	}

	@Override
	public void inputItem(Item item) {
		String sql = "INSERT INTO items (users_id, item_name, income_outgo) VALUES (:usersId, :itemName, :incomeOutgo)";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("usersId", item.getUsersId());
		param.addValue("itemName", item.getItemName());
		param.addValue("incomeOutgo", item.getIncomeOutgo());

		jdbcTemplate.update(sql, param);
	}

	@Override
	public List<Item> findById(Integer usersId){
		String sql = "SELECT * FROM items WHERE users_id = :usersId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("usersId", usersId);

		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Item>(Item.class));
	}

	@Override
	public List<Item> findByIdAndIncomeOutgoAndDelete(Integer usersId, Integer incomeOutgo){
		String sql = "SELECT * FROM items WHERE users_id = :usersId AND income_outgo = :incomeOutgo AND item_delete = TRUE";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("usersId", usersId);
		param.addValue("incomeOutgo", incomeOutgo);

		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Item>(Item.class));
	}

	@Override
	public void deleteItem(Integer itemsId) {
		String sql = "UPDATE items SET item_delete = TRUE WHERE items_id = :itemsId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("itemsId", itemsId);

		jdbcTemplate.update(sql, param);
	}

	@Override
	public void reInputItem(Integer itemsId) {
		String sql = "UPDATE items SET item_delete = FALSE WHERE items_id = :itemsId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("itemsId", itemsId);

		jdbcTemplate.update(sql, param);
	}
}

