package com.ejab;

import collector.CreateExecutableFileFrom;
import java.util.Set;
import org.reflections.Reflections;

public class Main {
    public static void main(String[] args) {
        Reflections reflection = new Reflections("com.ejab");

        Set<Class<?>> classes = reflection.getTypesAnnotatedWith(CreateExecutableFileFrom.class);
        classes.parallelStream().forEach(Main::createSourceFile);

    }

    private static void createSourceFile(Class<?> clazz) {
        clazz.getAnnotation(CreateExecutableFileFrom.class).value().getConsumer().accept(clazz);
    }
}