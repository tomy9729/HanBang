package com.ssafy.hanbang.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafy.hanbang.model.mapper")
public class DatabaseConfig {

}
