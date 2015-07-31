/*
 * Copyright (c) 2015, Inspireso and/or its affiliates. All rights reserved.
 */

package so.inspire.springboot;

import java.io.File;
import java.io.FilenameFilter;
import java.util.List;

import org.springframework.boot.loader.JarLauncher;
import org.springframework.boot.loader.archive.Archive;
import org.springframework.boot.loader.archive.JarFileArchive;
import org.springframework.boot.loader.jar.JarFile;

/**
 * Created by Inspireso Tream
 */
public class Bootstrap extends JarLauncher {
    private static ClassLoader classLoader = null;
    private static Bootstrap bootstrap = null;

    @Override
    protected void postProcessClassPathArchives(List<Archive> archives) throws Exception {
        super.postProcessClassPathArchives(archives);
        String serviceBase = System.getProperty("service.base");
        System.out.println("###path:" + serviceBase);
        File lib = new File(serviceBase + "/lib");
        System.out.println("###lib:" + lib.getAbsolutePath() + lib.exists());
        if (lib.exists()) {
            File[] jars = lib.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".jar");
                }
            });
            for (File jar : jars) {
                archives.add(new JarFileArchive(jar));
            }
        }
    }

    protected void launch(String[] args, String mainClass, ClassLoader classLoader, boolean wait)
            throws Exception {
        Runnable runner = createMainMethodRunner(mainClass, args, classLoader);
        Thread runnerThread = new Thread(runner);
        runnerThread.setContextClassLoader(classLoader);
        runnerThread.setName(Thread.currentThread().getName());
        runnerThread.start();
        if (wait == true) {
            runnerThread.join();
        }

    }

    public static void start(String[] args) {
        System.out.println("### starting service....");
        bootstrap = new Bootstrap();
        try {
            System.out.println("###args:" + args);
            System.out.println("###mainclass:" + bootstrap.getMainClass());
            JarFile.registerUrlProtocolHandler();
            List<Archive> archives = bootstrap.getClassPathArchives();
            for (Archive ar : archives) {
                System.out.println(ar.getUrl());
            }
            classLoader = bootstrap.createClassLoader(archives);

            bootstrap.launch(args, bootstrap.getMainClass(), classLoader, true);
            System.out.println("### service had started!");
        } catch (Exception ex) {
            System.out.println(ex.toString());
            System.exit(1);
        }
    }

    public static void stop(String[] args) {
        try {
            System.out.println("### stopping service....");
            if (bootstrap != null) {
                bootstrap.launch(args, bootstrap.getMainClass(), classLoader, true);
                bootstrap = null;
                classLoader = null;
            }
            System.out.println("### service had stoped!");
        } catch (Exception ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
            System.exit(0);
        }
    }
//
//    public static void main(String[] args) {
//        String mode = args != null && args.length > 0 ? args[0] : null;
//        if ("start".equals(mode)) {
//            Bootstrap.start(args);
//        } else if ("stop".equals(mode)) {
//            Bootstrap.stop(args);
//        }
//    }

}
