package com.didispace.charpter11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan
//@ComponentScan({"com.didispace.charpter11"})
public class Charpter11Application {

	public static void main(String[] args) {
		SpringApplication.run(Charpter11Application.class, args);
	}

}
