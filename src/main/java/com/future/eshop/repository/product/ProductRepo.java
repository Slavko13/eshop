package com.future.eshop.repository.product;

import com.future.eshop.domain.product.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Integer> {

}
