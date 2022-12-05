package org.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultsProcessorImplementer implements ResultsProcessor{
    private final List<Runner> runners;

    public ResultsProcessorImplementer() {
        this.runners = new ArrayList<>();
    }

    @Override
    public void loadRunners(Reader in) throws IOException {
        CSVFormat.Builder builder = CSVFormat.Builder.create();
        builder.setHeader("Фамилия Имя","Пол","Дистанция","Время").setSkipHeaderRecord(true);
        Iterable<CSVRecord> records = builder.build().parse(in);
        for (CSVRecord record : records) {
            String name = record.get(0);
            String sex = record.get(1);
            String distance = record.get(2).trim();
            String time = record.get(3).trim();

            runners.add(new Runner(name,sex,Integer.parseInt(distance), LocalTime.parse(time)));
        }
    }

    @Override
    public List<Runner> getFastestRunners(long N, int distance, String sex) {
        return runners.stream()
                .filter(x -> x.getDistance() == distance)
                //.filter(x -> sex.equals(x.getSex()))
                //.sorted(Comparator.comparing(Runner::getTime))
                .limit(N).collect(Collectors.toList());
    }

    public boolean contains(List<Runner> runnerList) {
        return runners.containsAll(runnerList);
    }
}
