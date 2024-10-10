package test.example.catalog.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * 楽器（ギター）
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instrument {

// ギターID
private Integer id;
// ブランドID
private String brandId;
//ギター名前
private String name;
// ブランド
private String brand;
//材質　
private String material;
// ボディ構造
private String body;
//価格
private Integer price;
// コメント
private String comment;
//登録日時
private LocalDateTime insDt;
//更新日時
private LocalDateTime updDt;
}
