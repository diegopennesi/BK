package com.service.backend.BK;

import com.service.backend.BK.Engine.Repository.DetailedOrderRepository;
import com.service.backend.BK.Engine.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableMongoRepositories
public class ServiceBkApplication{

	@Autowired
	DetailedOrderRepository detailedOrderService;
	@Autowired
	UserRepository userRepository;


	public static void main(String[] args) {
		SpringApplication.run(ServiceBkApplication.class, args);
	}

}
