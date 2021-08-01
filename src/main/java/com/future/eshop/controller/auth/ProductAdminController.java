package com.future.eshop.controller.auth;


import com.future.eshop.domain.product.Product;
import com.future.eshop.dto.product.ProductDTO;
import com.future.eshop.service.product.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@PreAuthorize("hasAuthority('ADMIN_AURHORITY')")
public class ProductAdminController {

    private final ProductServiceImpl productCrudService;


    public ProductAdminController(ProductServiceImpl productCrudService) {
        this.productCrudService = productCrudService;
    }

    @CrossOrigin
    @PostMapping("/add/product")
    public ResponseEntity<Product> addNewProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productCrudService.addProduct(productDTO), HttpStatus.OK);
    }
}
