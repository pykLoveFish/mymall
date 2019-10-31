package com.pyk.mymall.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 * 用于配置需要动态生成的mapper接口的路径
 */

@Configuration
@MapperScan({"com.pyk.mymall.mbg.mapper","com.pyk.mymall.dao"})
public class MyBatisConfig {
}
