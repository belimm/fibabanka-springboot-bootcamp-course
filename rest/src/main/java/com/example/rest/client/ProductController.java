package com.example.rest.client;

import com.example.rest.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class ProductController {

    private String uri = "http://localhost:8080/api/product";

    @GetMapping("/product/get")
    @ResponseBody
    public String getProduct(){

        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject(uri+"/301",Product.class);

        System.out.println(product);

        return "İşlem Başarılı "+product.getProductName()+" "+product.getSalesPrice();
    }

    @GetMapping("/product/post")
    @ResponseBody
    public String postProduct(){
        Product newProduct = new Product(4L,"iPhone",1000D);

        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.postForObject(uri,newProduct,Product.class);

        System.out.println(product);
        return "Yollama Başarılı "+product.getProductName();
    }

    @GetMapping("/product/put")
    @ResponseBody
    public String putProduct(){
        Product newProduct = new Product(5L,"iMac",1200D);

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.exchange(
                uri,
                HttpMethod.PUT,
                new HttpEntity<Product>(newProduct),
                Product.class);


        return "Yollama Başarılı "+newProduct.getProductName();
    }

    @GetMapping("/product/delete")
    @ResponseBody
    public String deleteProduct(){
        Product newProduct = new Product(5L,"iMac",1200D);

        RestTemplate restTemplate = new RestTemplate();

        restTemplate.delete(uri+"/5");


        return "Silme Başarılı "+newProduct.getProductName();
    }

}
