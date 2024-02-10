package org.careconnect.careconnectbooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CareConnectBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CareConnectBookingApplication.class, args);
	}

}
