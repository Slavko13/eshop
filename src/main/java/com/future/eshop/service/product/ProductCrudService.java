package com.future.eshop.service.product;

import com.future.eshop.domain.product.Product;
import com.future.eshop.dto.general.PageDTO;
import com.future.eshop.dto.product.ProductDTO;

import java.util.List;

public interface ProductCrudService {

    List<Product> getAllProducts(PageDTO pageDTO, Integer limit);
    Product getProductByID(Integer productID);
    void deleteProductByID(Integer productID);
    Product updateProduct(ProductDTO productDTO);
    Product addProduct(ProductDTO productDTO);

}
