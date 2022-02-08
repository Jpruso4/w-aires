package com.waires.Waires;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication//Yo agregue esto para que me dejara correr el proyecto, me ponia problema con el mongo
public class WAiresApplication {

	public static void main(String[] args) {
		SpringApplication.run(WAiresApplication.class, args);
	}

}
