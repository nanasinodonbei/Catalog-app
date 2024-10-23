package test.example.catalog.beans;

import lombok.Data;

/**
 * 検索条件
 */

@Data
public class SearchForm {
    
    private String brandId;
    private String Keyword;
}

