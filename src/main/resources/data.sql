-- ギターデータ
INSERT INTO instruments (
    id,
    brand_id,
    name,
    material,
    body,
    price,
    comment,
    insDt,
    updDt
) VALUES 
    (1, '01', 'Stratocaster',  'Alder', 'Solid', 120000, '人気のエレキギター。多様な音色が特徴。', NOW(), null), 
    (2, '02', 'Les Paul',  'Mahogany', 'Solid', 150000, 'クラシックなデザインで、豊かな音色。', NOW(), null), 
    (3, '01', 'Telecaster', 'Ash', 'Solid', 110000, 'シンプルで扱いやすい、初心者にもおすすめ。', NOW(), null), 
    (4, '03', 'RG', 'Ibanez',  'Solid', 90000, '速弾きに最適なエレキギター。', NOW(), null), 
    (5, '04', 'FG', 'Yamaha',  'Dreadnought', 70000, 'アコースティックギターのスタンダードモデル。', NOW(), null);

-- ギターブランド
INSERT INTO brand (
    brand_id,
    brand_name
) VALUES 
    ('01', 'Fender'),        
    ('02', 'Gibson'),        
    ('03', 'Ibanez'),        
    ('04', 'Yamaha'),        
    ('05', 'PRS');

