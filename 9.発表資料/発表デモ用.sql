--�f���p�A�J�E���g�쐬�i�����s���邾���j
INSERT INTO users (user_id, user_name, password, last_login_date) VALUES
('kinjo', '����', 'kinjo', '2020-5-1');
INSERT INTO notices_month_setting (users_id, notice_day, content) VALUES
((SELECT users_id FROM users WHERE user_id = 'kinjo'), 5, '���M��'),
((SELECT users_id FROM users WHERE user_id = 'kinjo'), 25, '�X�}�[�g�t�H������');

--�ʒm�̃��Z�b�g�A���O�C�����̒����i�f�����s���O�ɖ�����s����j
DELETE FROM notices_month;
UPDATE users SET last_login_date = '2020-5-1' WHERE user_id = 'kinjo';

