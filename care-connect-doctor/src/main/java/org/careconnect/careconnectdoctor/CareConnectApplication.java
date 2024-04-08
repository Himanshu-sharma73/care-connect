package org.careconnect.careconnectdoctor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CareConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CareConnectApplication.class, args);
	}

}
