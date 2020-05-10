package com.xiao6.usercenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.xiao6.usercenter.mapper")
//@MapperScan("com.xiao6.usercenter.mapper")
//@EnableAutoConfiguration(exclude = {org.flowable.spring.boot.SecurityAutoConfiguration.class})
public class UsercenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsercenterApplication.class, args);
	}
}
