package com.air_research.airwarningsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zwell
 */
@SpringBootApplication
@MapperScan("com.air_research.airwarningsystem")
public class AirWarningSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirWarningSystemApplication.class, args);
    }

}
