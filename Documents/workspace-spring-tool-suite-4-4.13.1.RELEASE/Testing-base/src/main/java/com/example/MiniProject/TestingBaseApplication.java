package com.example.MiniProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.MiniProject.trade.TradeService;


@SpringBootApplication
public class TestingBaseApplication {

	public static void main(String[] args) {
		TradeService trdService = new TradeService();
		trdService.getTradeDetails(121456903);

		SpringApplication.run(TestingBaseApplication.class, args);
	}

}
