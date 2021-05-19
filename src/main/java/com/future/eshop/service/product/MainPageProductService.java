package com.future.eshop.service.product;

import com.future.eshop.domain.product.Product;

import java.util.List;

public interface MainPageProductService {

    List<Product> getPopularProductsBySubcategory(Integer subcategoryID, Integer limit);

}
