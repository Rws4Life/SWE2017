package server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

	@Bean //Server is injected into the controller
	public Server s() {
		return new Server();
	}
	
	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(Main.class);
		
		logger.info("Program Starting"); //<immediateFlush>true</immediateFlush> couldn't be written into logback.xml because Windows does it automatically
		SpringApplication.run(Main.class, args);


	}

}
