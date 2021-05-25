package com.future.eshop.repository.product;

import com.future.eshop.domain.product.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Integer> {

    List<Product> findAll(Pageable pageable);

//    @Query()
//    List<Product> getAllWithLimit();

    // List<Product> getAllBySubcategoryIDLimitedOrder

}
