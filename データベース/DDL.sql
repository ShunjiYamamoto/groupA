--suteboデータベース作成
CREATE DATABASE sutebo;

--usersテーブル作成
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

--itemsテーブル作成
CREATE TABLE items(
items_id		SERIAL		PRIMARY KEY,
users_id		INT			NOT NULL	REFERENCES users(users_id),
item_name		VARCHAR(50)	NOT NULL,
income_outgo	INT			NOT NULL	CHECK (income_outgo >=1 AND income_outgo <=2),
item_delete 	BOOLEAN		NOT NULL	DEFAULT FALSE,
UNIQUE (users_id, item_name)
);

--moneyテーブル作成
CREATE TABLE money(
money_id	SERIAL	PRIMARY KEY,
input_date	DATE	NOT NULL,
items_id 	INT		NOT NULL	REFERENCES items(items_id),
amount 		INT		NOT NULL	CHECK (amount >= 0),
UNIQUE (input_date, items_id)
);

--notesテーブル作成
CREATE TABLE notes(
notes_id	SERIAL	PRIMARY KEY,
users_id	INT		NOT NULL	REFERENCES users(users_id),
input_date	DATE	NOT NULL,
note 		TEXT	NOT NULL,
UNIQUE (input_date, users_id)
);

--notices_month_settingテーブル作成
CREATE TABLE notices_month_setting(
notices_month_setting_id	SERIAL		PRIMARY KEY,
users_id					INT			NOT NULL	REFERENCES users(users_id),
notice_day					INT			NOT NULL	CHECK (notice_day >= 1 AND notice_day <= 29),
content 					VARCHAR(50)	NOT NULL,
notice_on					BOOLEAN		NOT NULL	DEFAULT TRUE,
notice_setting_delete		BOOLEAN		NOT NULL	DEFAULT FALSE
);

--notices_monthテーブル作成
CREATE TABLE notices_month(
notices_month_id			SERIAL	PRIMARY KEY,
notice_date 				DATE	NOT NULL,
notices_month_setting_id	INT		NOT NULL		REFERENCES notices_month_setting(notices_month_setting_id),
notice_delete				BOOLEAN DEFAULT FALSE	NOT NULL,
UNIQUE (notice_date, notices_month_setting_id)
);

--コメント（ER図・テーブル定義書の作成時に使用）
comment on table items is '項目';
comment on column items.items_id is '項目管理ID';
comment on column items.users_id is 'ユーザー管理ID';
comment on column items.item_name is '項目名';
comment on column items.income_outgo is '収支:1なら収入、2なら支出';
comment on column items.item_delete is '項目削除フラグ:TRUEなら項目を表面的に削除';

comment on table money is '金額';
comment on column money.money_id is '金額管理ID';
comment on column money.input_date is '日付';
comment on column money.items_id is '項目管理ID';
comment on column money.amount is '金額';

comment on table notes is '備考';
comment on column notes.notes_id is '備考管理ID';
comment on column notes.users_id is 'ユーザー管理ID';
comment on column notes.input_date is '日付';
comment on column notes.note is '備考';

comment on table notices_month is '月別通知';
comment on column notices_month.notices_month_id is '月別通知管理ID';
comment on column notices_month.notice_date is '日付';
comment on column notices_month.notices_month_setting_id is '月別通知設定管理ID';
comment on column notices_month.notice_delete is '通知削除フラグ:TRUEなら通知を表面的に削除';

comment on table notices_month_setting is '月別通知設定';
comment on column notices_month_setting.notices_month_setting_id is '月別通知設定管理ID';
comment on column notices_month_setting.users_id is 'ユーザー管理ID';
comment on column notices_month_setting.notice_day is '通知日:1から28なら1日～28日、29なら月末';
comment on column notices_month_setting.content is '内容';
comment on column notices_month_setting.notice_on is '通知オン:TRUEなら月別通知を実行';
comment on column notices_month_setting.notice_setting_delete is '通知設定削除フラグ:TRUEなら通知設定を表面的に削除';

comment on table users is 'ユーザー';
comment on column users.users_id is 'ユーザー管理ID';
comment on column users.user_id is 'ユーザーID';
comment on column users.user_name is 'ユーザー名';
comment on column users.password is 'パスワード';
comment on column users.user_delete is 'ユーザー削除フラグ:TRUEならユーザーを表面的に削除';
comment on column users.last_login_date is '最終ログイン日:月別通知の生成に使用';
comment on column users.line_token is 'LINEトークン';
comment on column users.line_time is 'LINE通知時間';
comment on column users.line_notice_on is 'LINE通知オン:TRUEならLINE通知を実行';

