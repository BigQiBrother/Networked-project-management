package com.agile.agiletest;

import com.agile.agiletest.config.data.DynamicDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

@Import({DynamicDataSourceConfig.class})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class AgiletestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgiletestApplication.class, args);
	}

}

