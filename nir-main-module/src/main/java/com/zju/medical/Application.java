package com.zju.medical;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by white_wolf on 2020/1/11.
 *
 * @author thebestwj
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.zju.medical.*"})
@MapperScan("com.zju.medical.dao.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
