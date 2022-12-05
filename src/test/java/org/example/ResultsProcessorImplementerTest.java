package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class ResultsProcessorImplementerTest extends Assertions {
    private static final List<Runner> runnerList1 = new ArrayList<>();
    private static final List<Runner> runnerList5 = new ArrayList<>();
    private static final List<Runner> runnerList10 = new ArrayList<>();
    private static Reader in;

    @BeforeAll
    static void setUp() throws IOException {
        in = new InputStreamReader(new FileInputStream("D:\\ProductStar\\runner.csv"), StandardCharsets.UTF_8);
        runnerList1.add(new Runner("Чернов Кирилл", "M", 1, LocalTime.parse("00:02:52.72")));
        runnerList1.add(new Runner("Никонов Никита", "M", 1, LocalTime.parse("00:03:00.59")));
        runnerList1.add(new Runner("Бачилов Владимир", "M", 1, LocalTime.parse("00:03:04.08")));
        runnerList1.add(new Runner("Лупаина Владислав", "M", 1, LocalTime.parse("00:03:06.14")));
        runnerList1.add(new Runner("Орлов Денис", "M", 1, LocalTime.parse("00:03:07.10")));
        runnerList1.add(new Runner("Печерикина Анна", "F", 1, LocalTime.parse("00:03:38.57")));
        runnerList1.add(new Runner("Гавриленко Ирина", "F", 1, LocalTime.parse("00:03:50.00")));
        runnerList1.add(new Runner("Жокова Анастасия", "F", 1, LocalTime.parse("00:03:50.84")));
        runnerList1.add(new Runner("Пищенкова Мария", "F", 1, LocalTime.parse("00:03:58.93")));
        runnerList1.add(new Runner("Кутузова Валентина", "F", 1, LocalTime.parse("00:04:04.83")));
        runnerList5.add(new Runner("Юсюк Евгений", "M", 5, LocalTime.parse("00:16:46.35")));
        runnerList5.add(new Runner("Шлепков Алексей", "M", 5, LocalTime.parse("00:16:51.11")));
        runnerList5.add(new Runner("Сосновский Виктор", "M", 5, LocalTime.parse("00:16:57.03")));
        runnerList5.add(new Runner("Симонов Юрий", "M", 5, LocalTime.parse("00:17:02.80")));
        runnerList5.add(new Runner("Калинин Сергей", "M", 5, LocalTime.parse("00:17:05.34")));
        runnerList10.add(new Runner("Маньшин Тимур", "M", 5, LocalTime.parse("00:17:17.72")));
        runnerList10.add(new Runner("Студеникина Наталья", "F", 5, LocalTime.parse("00:18:09.64")));
        runnerList10.add(new Runner("Бышкина Нина", "F", 5, LocalTime.parse("00:18:55.67")));
        runnerList10.add(new Runner("Ефремова Полина", "F", 5, LocalTime.parse("00:19:03.93")));
        runnerList10.add(new Runner("Титаренко Наталья", "F", 5, LocalTime.parse("00:19:31.03")));
        runnerList10.add(new Runner("Семенова Ольга", "F", 5, LocalTime.parse("00:19:57.27")));
        runnerList10.add(new Runner("Гуркина Елизавета", "F", 5, LocalTime.parse("00:20:36.63")));
        runnerList10.add(new Runner("Соболев Евгений", "M", 10, LocalTime.parse("00:32:36.05")));
        runnerList10.add(new Runner("Мусатов Даниил", "M", 10, LocalTime.parse("00:32:44.62")));
        runnerList10.add(new Runner("Кукузей Владимир", "M", 10, LocalTime.parse("00:33:18.87")));
        runnerList10.add(new Runner("Механошин Павел", "M", 10, LocalTime.parse("00:33:43.07")));
        runnerList10.add(new Runner("Яналов Николай", "M", 10, LocalTime.parse("00:33:43.54")));
        runnerList10.add(new Runner("Языкова Юлия", "F", 10, LocalTime.parse("00:39:38.01")));
        runnerList10.add(new Runner("Ящикова Анна", "F", 10, LocalTime.parse("00:39:53.20")));
        runnerList10.add(new Runner("Уварова Svetlana", "F", 10, LocalTime.parse("00:40:12.01")));
        runnerList10.add(new Runner("Казакевич Марина", "F", 10, LocalTime.parse("00:40:28.61")));
        runnerList10.add(new Runner("Тишина Елена", "F", 10, LocalTime.parse("00:40:28.80")));
    }

    @Test
    void loadRunners() {
        ResultsProcessor processor = new ResultsProcessorImplementer();
        try {
            processor.loadRunners(in);
            assertTrue(processor.contains(runnerList1));
            assertTrue(processor.contains(runnerList5));
            assertTrue(processor.contains(runnerList10));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getFastestRunners() {
        ResultsProcessor processor = new ResultsProcessorImplementer();
        List<Runner> fastestRunners;
        try {
            processor.loadRunners(in);
            long N = 3L;
            // Дистанция 1 км, мужчины, N самых быстрых
            fastestRunners = processor.getFastestRunners(N, 1, "M");
            assertTrue(runnerList1.containsAll(fastestRunners));
            // Дистанция 1 км, женщины, N самых быстрых
            fastestRunners = processor.getFastestRunners(N, 1, "F");
            assertTrue(runnerList1.containsAll(fastestRunners));
            // Дистанция 5 км, мужчины, N самых быстрых
            fastestRunners = processor.getFastestRunners(N, 5, "M");
            assertTrue(runnerList1.containsAll(fastestRunners));
            // Дистанция 5 км, женщины, N самых быстрых
            fastestRunners = processor.getFastestRunners(N, 5, "F");
            assertTrue(runnerList1.containsAll(fastestRunners));
            // Дистанция 10 км, мужчины, N самых быстрых
            fastestRunners = processor.getFastestRunners(N, 10, "M");
            assertTrue(runnerList1.containsAll(fastestRunners));
            // Дистанция 10 км, женщины, N самых быстрых
            fastestRunners = processor.getFastestRunners(N, 10, "F");
            assertTrue(runnerList1.containsAll(fastestRunners));
            // Неизвестная дистанция
            fastestRunners = processor.getFastestRunners(N, 50, "F");
            assertTrue(fastestRunners.isEmpty());
            // Неизвестный пол
            fastestRunners = processor.getFastestRunners(N, 10, "ОНО");
            assertTrue(fastestRunners.isEmpty());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}