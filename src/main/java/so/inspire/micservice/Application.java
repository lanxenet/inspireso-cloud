/*
 * Copyright (c) 2015. Sunisco and/or its affiliates.
 */

package so.inspire.micservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Inspireso Tream
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    private static ApplicationContext applicationContext = null;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // Customize the application or call application.sources(...) to add sources
        // Since our example is itself a @Configuration class we actually don't
        // need to override this method.
//        application.sources(OrganizationAutoConfigure.class);
        return application;
    }


    public static void main(String[] args) throws Exception {
        SpringApplication app = new SpringApplication(Application.class);
        applicationContext = app.run(args);
    }

}