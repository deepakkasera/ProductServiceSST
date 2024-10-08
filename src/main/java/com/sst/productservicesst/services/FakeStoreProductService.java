package com.sst.productservicesst.services;

import com.sst.productservicesst.dtos.FakeStoreProductDto;
import com.sst.productservicesst.dtos.UserDto;
import com.sst.productservicesst.exceptions.ProductNotFoundException;
import com.sst.productservicesst.models.Category;
import com.sst.productservicesst.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Long id) {
        ////Call the FakeStore API to get the product with give id.
        //int x = 1/0;
//        RestTemplate restTemplate = new RestTemplate();

        //Just make a sample call to UserService.
        UserDto userDto = restTemplate.getForObject(
                "http://userservicesept24/users/1", UserDto.class
        );

//        FakeStoreProductDto fakeStoreProductDto =
//                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
//                FakeStoreProductDto.class);
//
//        if (fakeStoreProductDto == null) {
//            throw new ProductNotFoundException(id, "Please pass a valid productId");
//        }
//
//        //convert FakeStoreProductDto object to Product object.
//        return convertFakeStoreProductDtoToProduct(fakeStoreProductDto);

        return new Product();
    }

    @Override
    public List<Product> getAllProducts(int pageNumber, int pageSize) {
        return null;
    }

//    public List<Product> getAllProducts() {
//        RestTemplate restTemplate = new RestTemplate();
//        FakeStoreProductDto[] fakeStoreProductDtos =
//                restTemplate.getForObject("https://fakestoreapi.com/products",
//                        FakeStoreProductDto[].class);
//
//        List<Product> products = new ArrayList<>();
//        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos) {
//            products.add(convertFakeStoreProductDtoToProduct(fakeStoreProductDto));
//        }
//        return products;
//    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
        Product product = new Product();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        Category category = new Category();
        //category.setDescription(fakeStoreProductDto.getCategory());
        product.setCategory(category);

        return product;
    }
}
