package com.stopError.MyBoard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.stopError.MyBoard")
public class MyBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBoardApplication.class, args);
	}

}
