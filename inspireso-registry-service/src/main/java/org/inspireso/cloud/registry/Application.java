package org.inspireso.cloud.registry;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import so.inspire.boot.startup.InspireApplication;

@SpringBootApplication
@EnableEurekaServer
public class Application {
    public static void main(String[] args) {
        InspireApplication.run(Application.class, args);
    }
}
