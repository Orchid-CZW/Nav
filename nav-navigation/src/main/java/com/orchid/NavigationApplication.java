package com.orchid;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


//@MapperScan相对于为dao包内所有接口都添加一个@Mapper
//@MapperScan("com.orchid.navigation.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class NavigationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NavigationApplication.class, args);
    }

}
