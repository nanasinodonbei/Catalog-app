package test.example.catalog.beans;

import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 検索条件
 */

@Data
public class SearchForm {
    
    private String brandId;

    @Size(min = 2, max = 10)
    private String keyword;
}

