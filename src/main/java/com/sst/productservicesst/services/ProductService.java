package com.sst.productservicesst.services;

import com.sst.productservicesst.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);

    List<Product> getAllProducts(int pageNumber, int pageSize);

    Product createProduct(Product product);
}
