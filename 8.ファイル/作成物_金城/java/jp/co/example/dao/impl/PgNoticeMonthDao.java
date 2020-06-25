package jp.co.example.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.example.dao.NoticeMonthDao;
import jp.co.example.entity.NoticeMonth;

@Repository
public class PgNoticeMonthDao implements NoticeMonthDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void inputNoticeMonth(NoticeMonth noticeMonth) {
		String sql = "INSERT INTO notices_month (notice_date, notices_month_setting_id) VALUES (:noticeDate , :noticesMonthSettingId)";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("noticeDate", noticeMonth.getNoticeDate());
		param.addValue("noticesMonthSettingId", noticeMonth.getNoticesMonthSettingId());

		jdbcTemplate.update(sql, param);
	}

	@Override
	public List<NoticeMonth> findByUsersId(Integer usersId){
		String sql = "SELECT notices_month_id, notice_date, nm.notices_month_setting_id, notice_delete, content FROM notices_month nm JOIN notices_month_setting nms ON nm.notices_month_setting_id = nms.notices_month_setting_id WHERE nm.notices_month_setting_id IN (SELECT nms.notices_month_setting_id FROM notices_month_setting WHERE nms.users_id = 2) AND notice_delete = FALSE";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("usersId", usersId);

		return jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<NoticeMonth>(NoticeMonth.class));
	}

	@Override
	public void deleteNoticeMonth(Integer noticesMonthId) {
		String sql = "UPDATE notices_month SET notice_delete = TRUE WHERE notices_month_id = :noticesMonthId";

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("noticesMonthId", noticesMonthId);

		jdbcTemplate.update(sql, param);
	}
}
