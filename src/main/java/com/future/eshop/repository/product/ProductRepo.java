package com.future.eshop.repository.product;

import com.future.eshop.domain.product.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface ProductRepo extends CrudRepository<Product, Integer> {

    List<Product> getAll(Pageable pageable);

//    @Query()
//    List<Product> getAllWithLimit();

    // List<Product> getAllBySubcategoryIDLimitedOrder

}
