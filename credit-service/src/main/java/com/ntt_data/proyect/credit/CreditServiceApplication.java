package com.ntt_data.proyect.credit;

import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

@SpringBootApplication
public class CreditServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CreditServiceApplication.class, args);
		System.out.println("el servidor esta corriendo");
		System.out.println(LocalDate.now().plusDays(30));
	}

}
