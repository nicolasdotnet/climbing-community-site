package org.amisescalade;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ClimbingCommunitySiteApplication extends SpringBootServletInitializer implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(ClimbingCommunitySiteApplication.class, args);
    }

    //@Override
    public void run(String... args) throws Exception {

    }
}
