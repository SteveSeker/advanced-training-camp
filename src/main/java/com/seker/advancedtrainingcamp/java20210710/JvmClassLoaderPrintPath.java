package com.seker.advancedtrainingcamp.java20210710;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

public class JvmClassLoaderPrintPath {

    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        System.out.println("启动类加载器");
        for (URL url : urls) {
            System.out.println("===>" + url.toExternalForm());
        }

        printClassLoader("扩展类加载器", JvmClassLoaderPrintPath.class.getClassLoader().getParent());
        printClassLoader("应用类加载器", JvmClassLoaderPrintPath.class.getClassLoader());
    }

    public static void printClassLoader(String name, ClassLoader classLoader) {
        System.out.println();

        if (null != classLoader) {
            System.out.println(name + "ClassLoader ->" + classLoader.toString());
            printURLForClassLoader(classLoader);
        } else {
            System.out.println(name + "ClassLoader -> null");
        }
    }

    public static void printURLForClassLoader(ClassLoader classLoader) {
        Object ucp = insightField(classLoader, "ucp");
        Object path = insightField(ucp, "path");
        List paths = (List) path;
        for (Object p : paths) {
            System.out.println("===>" + p.toString());
        }
    }

    public static Object insightField(Object obj, String fName) {
        Field f = null;
        try {
            if (obj instanceof URLClassLoader) {
                f = URLClassLoader.class.getDeclaredField(fName);
            } else {
                f = obj.getClass().getDeclaredField(fName);
            }
            f.setAccessible(true);
            return f.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

}
