DROP TABLE instruments;
CREATE TABLE instruments (
    id INT NOT NULL PRIMARY KEY COMMENT 'ID',
    name VARCHAR(100) NOT NULL COMMENT '名前',
    brand VARCHAR(100) COMMENT 'ブランド',
    material VARCHAR(100) COMMENT '材質',
    body VARCHAR(100) COMMENT 'ボディ構造',
    price INT CHECK(price >= 0) COMMENT '価格',
    comment VARCHAR(200) COMMENT 'コメント',
    ins_dt DATETIME COMMENT '登録日時',
    upd_dt DATETIME COMMENT '更新日時'
)COMMENT 'ギター'