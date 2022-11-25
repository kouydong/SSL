package com.example.ssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@RestController
public class SslApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslApplication.class, args);
	}

	@RequestMapping("/test")
	public String test(HttpServletRequest request, HttpServletResponse response) {
		return "테스트 페이지 입니다.";
	}
}
