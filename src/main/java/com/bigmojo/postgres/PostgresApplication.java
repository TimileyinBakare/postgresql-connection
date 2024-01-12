package com.bigmojo.postgres;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class PostgresApplication implements CommandLineRunner {
	private final DataSource dataSource;
	
	
	public PostgresApplication(final DataSource dataSource) {
		this.dataSource = dataSource;
	}


	public static void main(String[] args) {
		SpringApplication.run(PostgresApplication.class, args);
	}

	@Override
	public void run(final String... args)  {
		// logging some info
		log.info("Datasource" + dataSource.toString());
		// Assigning some variables
		final JdbcTemplate restTemplate = new JdbcTemplate(dataSource);
		// Executing some variables
		restTemplate.execute("select 1");
	}
}
