package work.martynas.lens;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LensApplication {

    private static final Logger log = LoggerFactory.getLogger(LensApplication.class);


	public static void main(String[] args) {
		log.info("Application Started");
        SpringApplication.run(LensApplication.class, args);
	}

    @Bean
    CommandLineRunner init(ApplicationContext ctx) {
        return args -> {



        };
    }
}


