package org.inspireso.cloud.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

import so.inspire.boot.startup.InspireApplication;

@SpringBootApplication
@EnableConfigServer
public class Application {
    public static void main(String[] args) {
        InspireApplication.run(Application.class, args);
    }
}
