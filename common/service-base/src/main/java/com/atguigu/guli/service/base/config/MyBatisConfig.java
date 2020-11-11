package com.atguigu.guli.service.base.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.PreparedStatement;
@MapperScan(basePackages ="com.atguigu.guli.service.*.mapper")
@Configuration
public class MyBatisConfig {
    //分页拦截器插件
        @Bean
    public PaginationInterceptor paginationInterceptor(){
            return  new PaginationInterceptor();
        }

    //乐观锁拦截器
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
            return new OptimisticLockerInterceptor();
    }
}
