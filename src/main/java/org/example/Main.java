package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Reader reader = new InputStreamReader(new FileInputStream("D:\\ProductStar\\runner.csv"), StandardCharsets.UTF_8);

        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ResultsProcessorConfiguration.class);
        ResultsProcessor processor = context.getBean(ResultsProcessor.class);
        processor.loadRunners(reader);
        long N = 3L;
        System.out.println("Дистанция 1 км, мужчины, " + N + " самых быстрых");
        processor.getFastestRunners(N, 1, "M").stream().forEach(System.out::println);
        System.out.println("Дистанция 1 км, женщины, " + N + " самых быстрых");
        processor.getFastestRunners(N, 1, "F").stream().forEach(System.out::println);
        System.out.println("Дистанция 5 км, мужчины, " + N + " самых быстрых");
        processor.getFastestRunners(N, 5, "M").stream().forEach(System.out::println);
        System.out.println("Дистанция 5 км, женщины, " + N + " самых быстрых");
        processor.getFastestRunners(N, 5, "F").stream().forEach(System.out::println);
        System.out.println("Дистанция 10 км, мужчины, " + N + " самых быстрых");
        processor.getFastestRunners(N, 10, "M").stream().forEach(System.out::println);
        System.out.println("Дистанция 10 км, женщины, " + N + " самых быстрых");
        processor.getFastestRunners(N, 10, "F").stream().forEach(System.out::println);

        context.registerShutdownHook();
    }
}