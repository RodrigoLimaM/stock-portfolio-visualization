package br.com.stockportfoliovisualization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
@EnableFeignClients
@EnableCaching
public class StockPortfolioVisualizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockPortfolioVisualizationApplication.class, args);
	}

}
