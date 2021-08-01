package com.future.eshop.service.product;

import com.future.eshop.domain.product.Brand;
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
public class ProductServiceImpl implements ProductCrudService, MainPageProductService {

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
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
        BeanUtils.copyProperties(productDTO, product);
        if (productDTO.getSubCategoryID() != null) {
            product.setSubcategory(new Subcategory(productDTO.getSubCategoryID()));
        }
        if (productDTO.getBrandID() != null) {
            product.setBrand(new Brand(productDTO.getBrandID()));
        }
        return productRepo.save(product);
    }

    @Override
    public List<Product> getPopularProductsBySubcategory(Integer subcategoryID, Integer limit) {
        return null;
    }
}
