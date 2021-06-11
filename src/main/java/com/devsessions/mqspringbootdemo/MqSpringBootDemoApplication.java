package com.devsessions.mqspringbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class MqSpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MqSpringBootDemoApplication.class, args);
	}

}
