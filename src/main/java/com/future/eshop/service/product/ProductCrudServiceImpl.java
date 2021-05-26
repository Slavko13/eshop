package com.future.eshop.service.product;

import com.future.eshop.domain.product.Product;
import com.future.eshop.domain.product.Subcategory;
import com.future.eshop.dto.general.PageDTO;
import com.future.eshop.dto.product.ProductDTO;
import com.future.eshop.exceptions.simpleException.NotFoundException;
import com.future.eshop.repository.product.ProductRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCrudServiceImpl implements ProductCrudService {

    private final ProductRepo productRepo;

    public ProductCrudServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> getAllProducts(PageDTO pageDTO, Integer limit) {
        return null;
    }

    @Override
    public Product getProductByID(Integer productID) {
        return productRepo.findById(productID).orElseThrow(() -> new NotFoundException("{ProductCrudServiceImpl.getProductByID.NotFound}"));
    }

    @Override
    public void deleteProductByID(Integer productID) {
        productRepo.deleteById(productID);
    }

    @Override
    public Product updateProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public Product addProduct(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, productDTO);
        if (productDTO.getSubCategoryID() != null) {
            Subcategory subcategory = new Subcategory(productDTO.getSubCategoryID());
            product.setSubcategory(subcategory);
        }
        return productRepo.save(product);
    }
}
