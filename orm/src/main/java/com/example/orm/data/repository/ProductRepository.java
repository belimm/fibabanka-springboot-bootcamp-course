package com.example.orm.data.repository;

import com.example.orm.data.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("select p from Product as p where p.salesPrice>= :minPrice")
    List<Product> listBySalesPriceMin(Double minPrice);
}
