package com.sst.productservicesst.controllers;

import com.sst.productservicesst.authCommons.AuthenticationCommons;
import com.sst.productservicesst.dtos.UserDto;
import com.sst.productservicesst.models.Product;
import com.sst.productservicesst.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

//This controller is capable to host HTTP API's
////localhost:8080/products -> ProductController
@RestController
@RequestMapping("/products")
public class ProductController { // waiter
    private ProductService productService;

    private AuthenticationCommons authenticationCommons;

    ProductController(@Qualifier("selfProductService") ProductService productService,
                      AuthenticationCommons authenticationCommons) {
        this.productService = productService;
        this.authenticationCommons = authenticationCommons;
    }

    //localhost:8080/products/10
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id, @RequestHeader String authenticationToken) {
        //In order to make this service authenticated, we can pass token
        // in the input parameter and then we'll have to validate the token
        // from UserService

        UserDto userDto = authenticationCommons.validateToken(authenticationToken);

        ResponseEntity<Product> response = null;

        if (userDto == null) {
            response = new ResponseEntity<>(
                    null,
                    HttpStatus.UNAUTHORIZED
            );

            return response;
        }

        //throw new RuntimeException("Something went wrong");
//        ResponseEntity<Product> responseEntity = null;
//        Product product = null;
//        try {
//            product = productService.getProductById(id);
//            responseEntity = new ResponseEntity<>(product, HttpStatus.OK);
//            System.out.println("Hello");
//            return responseEntity;
//        } catch (RuntimeException exception) {
//            ExceptionDto dto = new ExceptionDto();
//            dto.setMessage("Something went wrong");
//            ResponseEntity<ExceptionDto> response =
//                    new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
//            return response;
//        }
        Product product = productService.getProductById(id); //@1234

        response = new ResponseEntity<>(
                product,
                HttpStatus.OK
        );

        return response;
    }

    //localhost:8080/products
    @GetMapping
    public Page<Product> getAllProducts(@RequestParam("pageNumber") int pageNumber,
                                        @RequestParam("pageSize") int pageSize) {
        List<Product> products = productService.getAllProducts(pageNumber, pageSize);
        // List<Product> // @1234, @3241, @1245

        for (Product product : products) {
            product.setTitle("Hello " + product.getTitle());
        }

        return new PageImpl<>(products);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
}
