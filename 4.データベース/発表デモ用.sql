--デモ用アカウント作成（一回実行するだけ）
INSERT INTO users (user_id, user_name, password, last_login_date) VALUES
('kinjo', '金城', 'kinjo', '2020-5-1');
INSERT INTO notices_month_setting (users_id, notice_day, content) VALUES
((SELECT users_id FROM users WHERE user_id = 'kinjo'), 5, '光熱費'),
((SELECT users_id FROM users WHERE user_id = 'kinjo'), 25, 'スマートフォン料金');

--通知のリセット、ログイン日の調整（毎回デモを行った後に実行する）
DELETE FROM notices_month;
DELETE FROM notices_month_setting;
INSERT INTO notices_month_setting (users_id, notice_day, content) VALUES
((SELECT users_id FROM users WHERE user_id = 'kinjo'), 5, '光熱費'),
((SELECT users_id FROM users WHERE user_id = 'kinjo'), 25, 'スマートフォン料金');
UPDATE users SET last_login_date = '2020-5-1' WHERE user_id = 'kinjo';

DELETE FROM money WHERE NOT (users_id = 43);
DELETE FROM items WHERE NOT (users_id = 43);
DELETE FROM users WHERE user_id = 'axiz';
