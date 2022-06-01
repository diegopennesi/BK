package com.service.backend.BK;

import com.service.backend.BK.Repository.Test1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ServiceBkApplication{

	@Autowired
	Test1Repository Test1Repo;

	public static void main(String[] args) {
		SpringApplication.run(ServiceBkApplication.class, args);
	}

}
