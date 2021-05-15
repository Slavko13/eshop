package com.future.eshop.repository.product;

import com.future.eshop.domain.product.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Integer> {
}
