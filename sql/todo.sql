DROP DATABASE IF EXISTS todo;

create database todo;

use todo;

-- ユーザ
CREATE TABLE user (
 userId INT auto_increment,
 userName VARCHAR(64) NOT NULL,
 dspName VARCHAR(64) NOT NULL,
 password VARCHAR(64) NOT NULL,
 role ENUM('USER','ADMIN','SYSTEM') NOT NULL,
 primary key(userId)
);

-- タスク
CREATE TABLE task (
 taskId INT auto_increment,
 userId INT NOT NULL,
 taskName VARCHAR(128) NOT NULL,
 memo VARCHAR(512),
 createDate DATE NOT NULL,
 severity ENUM('urgent', 'high', 'normal', 'low', 'none'),
 deadline DATE,
 taskStatus ENUM('open', 'closed', 'cancel') NOT NULL,
 parentId INT,
 primary key(taskId),
 foreign key(userId) references user(userId) on update cascade on delete cascade,
 foreign key(parentId) references task(taskId) on update cascade on delete cascade
);

-- タスクタグ
CREATE TABLE tasktag (
 tasktagId INT auto_increment,
 tagName VARCHAR(64),
 userId INT NOT NULL,
 primary key(tasktagId),
 foreign key(userId) references user(userId) on update cascade on delete cascade
);

-- タスクタグ関連
CREATE TABLE tasktagR (
 tasktagRId INT auto_increment,
 taskId INT NOT NULL,
 tasktagId INT NOT NULL,
 primary key(tasktagRId),
 foreign key(taskId) references task(taskId) on update cascade on delete cascade,
 foreign key(tasktagId) references tasktag(tasktagId) on update cascade on delete cascade
);

-- メンバー
CREATE TABLE member (
 menId INT auto_increment,
 taskId INT,
 userId INT,
 menStatus ENUM('member','invitation','reject'),
 primary key(menId),
 foreign key(taskId) references task(taskId) on update cascade on delete cascade,
 foreign key(userId) references user(userId) on update cascade on delete cascade
);

-- タグイベント
CREATE TABLE tagEvent (
 tagEventId INT auto_increment,
 eventName VARCHAR(128),
 eventOutline VARCHAR(255),
 primary key(tagEventId)
);

-- 思考ログ
CREATE TABLE thinkingLog (
 logId INT auto_increment,
 taskId INT,
 userId INT NOT NULL,
 createDate DATETIME,
 contents VARCHAR(512),
 primary key(logId),
 foreign key(taskId) references task(taskId) on update cascade on delete cascade,
 foreign key(userId) references user(userId) on update cascade on delete cascade
);

-- 思考ログタグ
CREATE TABLE logtag (
 logtagId INT auto_increment,
 tagName VARCHAR(64),
 userId INT NOT NULL,
 tagEventId INT,
 primary key(logtagId),
 foreign key(userId) references user(userId) on update cascade on delete cascade,
 foreign key(tagEventId) references tagEvent(tagEventId) on update cascade on delete cascade
);

-- 思考ログタグ関連
CREATE TABLE logtagR (
 logtagRId INT auto_increment,
 logId INT NOT NULL,
 logtagId INT NOT NULL,
 primary key(logtagRId),
 foreign key(logId) references thinkingLog(logId) on update cascade on delete cascade,
 foreign key(logtagId) references logtag(logtagId) on update cascade on delete cascade
);

-- お知らせ
CREATE TABLE news (
 newsId INT auto_increment,
 contents VARCHAR(512),
 createDate DATETIME,
 primary key(newsId)
);
