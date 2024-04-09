package com.sst.productservicesst.services;

import com.sst.productservicesst.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);

    List<Product> getAllProducts();

    Product createProduct(Product product);
}
