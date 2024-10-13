DROP TABLE IF EXISTS instruments;
CREATE TABLE instruments (
    id INT NOT NULL PRIMARY KEY COMMENT 'ギターID',
    brand_id VARCHAR(2) NOT NULL COMMENT 'ブランドID',
    name VARCHAR(50) COMMENT 'ギター名前',
    material VARCHAR(20) COMMENT '材質）',
    body VARCHAR(20) COMMENT 'ボディ構造',
    price INT COMMENT '価格',
    comment VARCHAR(100) COMMENT 'コメント',
    insDt DATETIME COMMENT'登録日時',
    updDt DATETIME COMMENT'更新日時'
)COMMENT 'ギター詳細';

DROP TABLE IF EXISTS brand;
CREATE TABLE brand (
   brand_id VARCHAR(2) NOT NULL PRIMARY KEY COMMENT 'ブランドID',
   brand_name VARCHAR(20) COMMENT 'ブランド名'
) COMMENT 'ブランド';