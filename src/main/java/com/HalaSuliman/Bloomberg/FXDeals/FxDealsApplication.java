package com.HalaSuliman.Bloomberg.FXDeals;

import com.HalaSuliman.Bloomberg.FXDeals.Entites.DealDetails;
import com.HalaSuliman.Bloomberg.FXDeals.Reposeitory.DealDetailsRepo;
import com.HalaSuliman.Bloomberg.FXDeals.Services.DealDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Timestamp;
import java.util.Currency;
import java.util.Date;

@SpringBootApplication
public class FxDealsApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(FxDealsApplication.class, args);
	}

}
