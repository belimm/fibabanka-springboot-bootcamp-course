package com.example.orm.presentation.mvc;

import com.example.orm.data.entity.Product;
import com.example.orm.data.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/inventory")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/product/insert")
    @ResponseBody
    private String insertProduct(){
        Product product = new Product(
                0L,
                "Cep telefonu",
                1000D
        );

        productRepository.save(product);

        return "Eklendi " + product.getProductName();

    }

    @GetMapping("product/{productId}")
    @ResponseBody
    private ResponseEntity<?> findProduct(@PathVariable("productId") Long productId){
        Optional product = productRepository.findById(productId);

        if(product.isPresent()){
            return ResponseEntity
                    .ok()
                    .body(product);

        }

        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("Ürün bulunamadı");

    }


    @GetMapping("/products")
    @ResponseBody
    private ResponseEntity<?> getProducts(){
        Iterable<Product> products = productRepository.findAll();

        return ResponseEntity
                .ok()
                .body(products);

    }

    @GetMapping("/product/delete/{productId}")
    @ResponseBody
    private ResponseEntity<?> deleteProductById(@PathVariable("productId") Long productId){

        if(!productRepository.existsById(productId)){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Ürün bulunamadı");
        }
        productRepository.deleteById(productId);

        return ResponseEntity
                .ok()
                .body("Silindi");
    }


    @GetMapping("/product/expensives/{minPrice}")
    @ResponseBody
    private ResponseEntity<?> listBySalesPriceMin(@PathVariable("minPrice") Double minPrice){


        List<Product> products = productRepository.listBySalesPriceMin(minPrice);

        return ResponseEntity
                .ok()
                .body(products);
    }


}
