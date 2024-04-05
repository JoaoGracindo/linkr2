package app.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LinkrApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkrApplication.class, args);
		System.out.print("\033\143");
		System.out.println("Server is running on port 8080...");

	}

}
