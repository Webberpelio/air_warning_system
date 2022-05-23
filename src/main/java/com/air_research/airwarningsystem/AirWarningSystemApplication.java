package com.air_research.airwarningsystem;

import com.air_research.airwarningsystem.temp.SimulateTask;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author zwell
 */
@SpringBootApplication
@MapperScan("com.air_research.airwarningsystem")
public class AirWarningSystemApplication {

    @Autowired
    private SimulateTask simulateTask;

    public static void main(String[] args) {
        SpringApplication.run(AirWarningSystemApplication.class, args);
    }

    /*@Bean
    public CommandLineRunner run() {
        return args -> {
            //模拟生成数据，以供程序运行展示系统功能
            simulateTask.simulatePredictionStore();
        };
    }*/
}
