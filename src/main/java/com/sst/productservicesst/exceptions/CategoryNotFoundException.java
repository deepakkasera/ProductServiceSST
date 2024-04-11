package com.sst.productservicesst.exceptions;

import com.sst.productservicesst.repositories.CategoryRepository;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
