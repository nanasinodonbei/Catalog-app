package test.example.catalog.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * ギターのメーカー（ブランド）
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {


    //ブランドID
    private String brandId;
    //ブランド名
    private String brandName;

}
