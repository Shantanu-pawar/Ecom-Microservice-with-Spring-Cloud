package com.Ecom.productservice.Service;

import com.Ecom.productservice.Module.Product;
import com.Ecom.productservice.Repository.ProductRepo;
import com.Ecom.productservice.dto.ProductRequest;
import com.Ecom.productservice.dto.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public String createProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .build();

        productRepo.save(product);
        log.info("product {} is saved", product.getId());
        return "product created successfully";
    }

    public List<ProductResponse> getAllProduct() {
        List<Product> products = productRepo.findAll();

        return products.stream()
                .map(product -> mapToProductResponse(product))
                .collect(Collectors.toList());
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

}
