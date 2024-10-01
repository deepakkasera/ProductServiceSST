package com.sst.productservicesst.controllers;

import com.sst.productservicesst.models.Product;
import com.sst.productservicesst.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService; // This will NOT be an actual object, rather it will a mocked object.

    @Test
    public void testGetProductById_Success() {
//        Product product = new Product();
//        product.setTitle("iPhone 16 pro");
//        product.setDescription("Again best iPhone ever");
//
//        when(productService.getProductById(1L))
//                .thenReturn(product);
//
//        Product response = productController.getProductById(10L);
//
//      assertEquals(product, response);
    }

    @Test
    public void testGetAllProducts() {
        List<Product> products = new ArrayList<>();

        Product p1 = new Product(); // @1234
        p1.setId(1L);
        p1.setTitle("Macbook");
        p1.setDescription("Best Macbook ever");
        products.add(p1);

        Product p2 = new Product(); // @3421
        p2.setId(2L);
        p2.setTitle("Macbook pro");
        p2.setDescription("Best Macbook ever");
        products.add(p2);

        Product p3 = new Product(); // @1245
        p3.setId(3L);
        p3.setTitle("Macbook Pro Ultra");
        p3.setDescription("Best Macbook ever");
        products.add(p3);


        when(productService.getAllProducts(0, 10))
                .thenReturn(products);

        Page<Product> productsPage = productController.getAllProducts(0, 10);
        List<Product> response = productsPage.getContent();

        assertEquals(products.size(), response.size());

        for (int i = 0; i < products.size(); i++) {
            assertEquals(products.get(i).getTitle(), response.get(i).getTitle());
        }
;    }

}