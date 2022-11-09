package com.example.rest.resource;

import com.example.rest.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusResource {

    @GetMapping("/status/ok/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Long productId){
        if(productId==0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ürün bulunamadı");
        }
        Product product = new Product(
                productId,
                "Macboor air",
                1000D
        );

        return ResponseEntity.ok().body(product);
    }


}
