package com.example.orm.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {

    @Bean
    public MyBean myBean(){
        MyBean myBean = new MyBean();

        myBean.setMyLong(12L);
        myBean.setMyString("Godoro");
        myBean.setMyDouble(123.4);
        return myBean;
    }
}
