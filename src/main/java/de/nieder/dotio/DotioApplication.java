package de.nieder.dotio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DotioApplication {


    /** The SLF4J Logger. */
    private static final Logger LOGGER = LoggerFactory.getLogger(DotioApplication.class);

    public static void main(String[] args) {
        LOGGER.info("Initializing");
        SpringApplication.run(DotioApplication.class, args);
    }
}
