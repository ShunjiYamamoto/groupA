package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.NoticeMonthSettingDao;
import jp.co.example.entity.NoticeMonthSetting;

@Repository
public class PgNoticeMonthSettingDao implements NoticeMonthSettingDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public List<NoticeMonthSetting> findById(Integer usersId){
		String sql = "SELECT * FROM notices_month_setting WHERE users_id = :usersId AND notice_setting_delete = FALSE ORDER BY notice_day, notices_month_setting_id";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("usersId", usersId);

		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<NoticeMonthSetting>(NoticeMonthSetting.class));
	}

	@Override
	public void inputNoticeMonthSetting(NoticeMonthSetting noticeMonthSetting) {
		String sql = "INSERT INTO notices_month_setting (users_id, notice_day, content) VALUES (:userId, :noticeDay, :content)";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("userId", noticeMonthSetting.getUsersId());
		param.addValue("noticeDay", noticeMonthSetting.getNoticeDay());
		param.addValue("content", noticeMonthSetting.getContent());

		jdbcTemplate.update(sql, param);
	}

	@Override
	public void updateNoticeOn(Integer noticesMonthSettingId, Boolean noticeOn) {
		String sql = "UPDATE notices_month_setting SET notice_on = :noticeOn WHERE notices_month_setting_id = :noticesMonthSettingId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("noticeOn", noticeOn);
		param.addValue("noticesMonthSettingId", noticesMonthSettingId);

		jdbcTemplate.update(sql, param);
	}

	@Override
	public void updateNoticeSettingDelete(Integer noticesMonthSettingId) {
		String sql = "UPDATE notices_month_setting SET notice_setting_delete = TRUE WHERE notices_month_setting_id = :noticesMonthSettingId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("noticesMonthSettingId", noticesMonthSettingId);

		jdbcTemplate.update(sql, param);
	}

	@Override
	public List<NoticeMonthSetting> findByIdAndNoticeOn(Integer usersId){
		String sql = "SELECT * FROM notices_month_setting WHERE users_id = :usersId AND notice_on = TRUE AND notice_setting_delete = FALSE ORDER BY notice_day, notices_month_setting_id";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("usersId", usersId);

		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<NoticeMonthSetting>(NoticeMonthSetting.class));
	}

}
