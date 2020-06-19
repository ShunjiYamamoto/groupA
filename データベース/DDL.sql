--sutebo�f�[�^�x�[�X�쐬
CREATE DATABASE sutebo;

--users�e�[�u���쐬
CREATE TABLE users(
users_id		SERIAL 		PRIMARY KEY,
user_id			VARCHAR(50) NOT NULL	UNIQUE,
user_name		VARCHAR(50) NOT NULL,
password		VARCHAR(50) NOT NULL,
user_delete		BOOLEAN 	NOT NULL	DEFAULT FALSE,
last_login_date	DATE,
line_token		VARCHAR(60),
line_time		TIME,
line_notice_on	BOOLEAN
);

--items�e�[�u���쐬
CREATE TABLE items(
items_id		SERIAL		PRIMARY KEY,
users_id		INT			NOT NULL	REFERENCES users(users_id),
item_name		VARCHAR(50)	NOT NULL,
income_outgo	INT			NOT NULL	CHECK (income_outgo >=1 AND income_outgo <=2),
item_delete 	BOOLEAN		NOT NULL	DEFAULT FALSE,
UNIQUE (users_id, item_name)
);

--money�e�[�u���쐬
CREATE TABLE money(
money_id	SERIAL	PRIMARY KEY,
input_date	DATE	NOT NULL,
items_id 	INT		NOT NULL	REFERENCES items(items_id),
amount 		INT		NOT NULL	CHECK (amount >= 0),
UNIQUE (input_date, items_id)
);

--notes�e�[�u���쐬
CREATE TABLE notes(
notes_id	SERIAL	PRIMARY KEY,
users_id	INT		NOT NULL	REFERENCES users(users_id),
input_date	DATE	NOT NULL,
note 		TEXT	NOT NULL,
UNIQUE (input_date, users_id)
);

--notices_month_setting�e�[�u���쐬
CREATE TABLE notices_month_setting(
notices_month_setting_id	SERIAL		PRIMARY KEY,
users_id					INT			NOT NULL	REFERENCES users(users_id),
notice_day					INT			NOT NULL	CHECK (notice_day >= 1 AND notice_day <= 29),
content 					VARCHAR(50)	NOT NULL,
notice_on					BOOLEAN		NOT NULL	DEFAULT TRUE,
notice_setting_delete		BOOLEAN		NOT NULL	DEFAULT FALSE
);

--notices_month�e�[�u���쐬
CREATE TABLE notices_month(
notices_month_id			SERIAL	PRIMARY KEY,
notice_date 				DATE	NOT NULL,
notices_month_setting_id	INT		NOT NULL		REFERENCES notices_month_setting(notices_month_setting_id),
notice_delete				BOOLEAN DEFAULT FALSE	NOT NULL,
UNIQUE (notice_date, notices_month_setting_id)
);

--�R�����g�iER�}�E�e�[�u����`���̍쐬���Ɏg�p�j
comment on table items is '����';
comment on column items.items_id is '���ڊǗ�ID';
comment on column items.users_id is '���[�U�[�Ǘ�ID';
comment on column items.item_name is '���ږ�';
comment on column items.income_outgo is '���x:1�Ȃ�����A2�Ȃ�x�o';
comment on column items.item_delete is '���ڍ폜�t���O:TRUE�Ȃ獀�ڂ�\�ʓI�ɍ폜';

comment on table money is '���z';
comment on column money.money_id is '���z�Ǘ�ID';
comment on column money.input_date is '���t';
comment on column money.items_id is '���ڊǗ�ID';
comment on column money.amount is '���z';

comment on table notes is '���l';
comment on column notes.notes_id is '���l�Ǘ�ID';
comment on column notes.users_id is '���[�U�[�Ǘ�ID';
comment on column notes.input_date is '���t';
comment on column notes.note is '���l';

comment on table notices_month is '���ʒʒm';
comment on column notices_month.notices_month_id is '���ʒʒm�Ǘ�ID';
comment on column notices_month.notice_date is '���t';
comment on column notices_month.notices_month_setting_id is '���ʒʒm�ݒ�Ǘ�ID';
comment on column notices_month.notice_delete is '�ʒm�폜�t���O:TRUE�Ȃ�ʒm��\�ʓI�ɍ폜';

comment on table notices_month_setting is '���ʒʒm�ݒ�';
comment on column notices_month_setting.notices_month_setting_id is '���ʒʒm�ݒ�Ǘ�ID';
comment on column notices_month_setting.users_id is '���[�U�[�Ǘ�ID';
comment on column notices_month_setting.notice_day is '�ʒm��:1����28�Ȃ�1���`28���A29�Ȃ猎��';
comment on column notices_month_setting.content is '���e';
comment on column notices_month_setting.notice_on is '�ʒm�I��:TRUE�Ȃ猎�ʒʒm�����s';
comment on column notices_month_setting.notice_setting_delete is '�ʒm�ݒ�폜�t���O:TRUE�Ȃ�ʒm�ݒ��\�ʓI�ɍ폜';

comment on table users is '���[�U�[';
comment on column users.users_id is '���[�U�[�Ǘ�ID';
comment on column users.user_id is '���[�U�[ID';
comment on column users.user_name is '���[�U�[��';
comment on column users.password is '�p�X���[�h';
comment on column users.user_delete is '���[�U�[�폜�t���O:TRUE�Ȃ烆�[�U�[��\�ʓI�ɍ폜';
comment on column users.last_login_date is '�ŏI���O�C����:���ʒʒm�̐����Ɏg�p';
comment on column users.line_token is 'LINE�g�[�N��';
comment on column users.line_time is 'LINE�ʒm����';
comment on column users.line_notice_on is 'LINE�ʒm�I��:TRUE�Ȃ�LINE�ʒm�����s';

