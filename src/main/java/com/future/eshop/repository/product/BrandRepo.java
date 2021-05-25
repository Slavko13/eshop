package com.future.eshop.repository.product;

import com.future.eshop.domain.product.Brand;
import org.springframework.data.repository.CrudRepository;

public interface BrandRepo extends CrudRepository<Brand, Integer> {
}
