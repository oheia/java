package com.ohei.mybatis.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.ohei.mybatis.mbg.mapper")
public class MyBatisConfig {
}
