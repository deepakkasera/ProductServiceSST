package com.sst.productservicesst;

import com.sst.productservicesst.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceSstApplicationTests {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

//    @Test
//    void testEagerVsLazyFetch() {
//        Optional<Category> optionalCategory =
//                categoryRepository.findById(1L);
//
//        Category category = optionalCategory.get();
//
//        System.out.println("Fetching list of products for the above category");
//        //List<Product> products = category.getProducts();
//        //System.out.println(products.get(0).getTitle());
//
//        System.out.println("DEBUG");
//    }

    @Test
    void sampleTestCase() {
        //
    }
}
