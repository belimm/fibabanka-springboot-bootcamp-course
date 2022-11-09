package com.example.rest.resource;

import com.example.rest.Product;
import com.example.rest.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductResource {

    @Autowired
    private ProductServiceImpl productService;



    @GetMapping("/api/product/{id}")
    public Product getProduct(@PathVariable("id") Long productId){
        return productService.find(productId);
    }

    @GetMapping("/api/products")
    public List<Product> getProducts(){
        return List.of(
                new Product(1L,"Macbook air",1000D),
                new Product(2L,"Macbook pro",1200D)
        );
    }

    @PostMapping("/api/product")
    public Product postProduct(@RequestBody Product product){
        return product;
    }

    @PutMapping("/api/product")
    public Product putProduct(@RequestBody Product product){

        System.out.println("Ürün güncellendi "+product.getProductId()+" "+product.getProductName()+" "+product.getSalesPrice());
        return product;
    }

    @DeleteMapping("/api/product/{id}")
    public void deleteProduct(@PathVariable("id") Long productId){
        System.out.println("Ürün silindi");
    }
}
