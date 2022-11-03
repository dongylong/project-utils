package com.latte.watch;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.nio.file.*;
import java.util.Objects;
import java.util.Properties;

/**
 * @author dongyl-work
 * @date 2021/3/5 下午1:51
 **/
public class WatchUtils {
    private static String fileName = "";

    private static ClassPathResource resource = null;

    private static WatchService watchService = null;

    private static Properties properties = null;

    static {
        try {
            fileName = "xxx.properties";
            resource = new ClassPathResource(fileName);
            watchService = FileSystems.getDefault().newWatchService();
            Paths.get(resource.getFile().getParent())
                    .register(watchService,
                            StandardWatchEventKinds.ENTRY_MODIFY,
                            StandardWatchEventKinds.ENTRY_DELETE);
            properties = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread watchThread = new Thread(() -> {
            while (true) {
                try {
                    WatchKey watchKey = watchService.take();
                    for (WatchEvent<?> event : watchKey.pollEvents()) {
                        if (Objects.equals(event.context().toString(), fileName)) {
                            properties = PropertiesLoaderUtils.loadProperties(resource);
                            break;
                        }
                    }
                    watchKey.reset();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        watchThread.setDaemon(true);
        watchThread.start();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                watchService.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
}
