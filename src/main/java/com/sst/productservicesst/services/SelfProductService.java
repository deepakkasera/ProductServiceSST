package com.sst.productservicesst.services;

import com.sst.productservicesst.exceptions.CategoryNotFoundException;
import com.sst.productservicesst.exceptions.ProductNotFoundException;
import com.sst.productservicesst.models.Category;
import com.sst.productservicesst.models.Product;
import com.sst.productservicesst.repositories.CategoryRepository;
import com.sst.productservicesst.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Primary
@Service("selfProductService")
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException(id, "Product not found");
        }

        return optionalProduct.get();
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {

        //Sort.by("price").ascending().and(Sort.by("description")).descending();

        Page<Product> pages = productRepository.findAll(PageRequest.of(
                pageNumber,
                pageSize,
                Sort.by("price").ascending()
                ));

        return pages;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

        if (category.getId() == null) { // save the category
            product.setCategory(categoryRepository.save(category));
        }

        Product product1 = productRepository.save(product);
        Optional<Category> optionalCategory = categoryRepository.findById(category.getId());

        if (optionalCategory.isEmpty()) {
            //The category that is passed in the input product in invalid.
            throw new CategoryNotFoundException("Invalid category id passed");
        }

        product1.setCategory(optionalCategory.get());
        return product1;
    }
}
