package com.sst.productservicesst.repositories;

import com.sst.productservicesst.models.Category;
import com.sst.productservicesst.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Override
    Category save(Category category);
}
