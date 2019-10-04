package com.jayden.admin.util;

import java.io.File;
import java.net.URL;

public abstract class FileUtil {

    private FileUtil() {

    }

    public static File getFileFromResources(String filePath) {
        ClassLoader classLoader = FileUtil.class.getClassLoader();
        URL resource = classLoader.getResource(filePath);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found");
        }
        return new File(resource.getFile());
    }

}
