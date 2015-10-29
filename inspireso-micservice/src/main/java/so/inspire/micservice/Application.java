/*
 * Copyright (c) 2015. Sunisco and/or its affiliates.
 */

package so.inspire.micservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Inspireso Tream
 */
@SpringBootApplication
public class Application {


    public static void main(String[] args) throws Exception {
        so.inspire.boot.startup.InspireApplication.run(Application.class, args);
    }

}