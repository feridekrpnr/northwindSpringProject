package com.etiya.northwind.business.responses.categories;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCategoryResponse {
    private int categoryId;
    private String categoryName;
}
