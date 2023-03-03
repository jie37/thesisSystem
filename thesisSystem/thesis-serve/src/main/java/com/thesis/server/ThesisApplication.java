package com.thesis.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author lzj
 * @since 1.0.0
 */
@SpringBootApplication
@MapperScan("com.thesis.server.mapper")
public class ThesisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThesisApplication.class,args);
    }

}
