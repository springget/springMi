package com.jk;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jk.dao")
public class SpringbootYywProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootYywProviderApplication.class, args);
    }

}
