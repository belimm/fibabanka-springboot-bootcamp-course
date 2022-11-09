package com.example.rest.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class TransferController {

    @GetMapping("/client/header")
    @ResponseBody
    public String getHeader(){
        String uri = "http://localhost:8080/transfer/header";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("input","Godoro");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET,entity,String.class);


        return "Başlık gönderildi "+response.getBody();
    }

    @GetMapping("/client/setheader")
    @ResponseBody
    public String setHeader(){
        String uri = "http://localhost:8080/transfer/header";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET,entity,String.class);
        String input = response.getHeaders().getFirst("input");

        return "Başlık gönderildi "+input;
    }


}
