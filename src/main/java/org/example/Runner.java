package org.example;

import java.time.LocalTime;

/**
 * Бегун
 */
public class Runner {
    /**
     * Имя
     */
    private String name;
    /**
     * Пол
     */
    private String sex;
    /**
     * Расстояние забега - дистанция
     */
    private int distance;
    /**
     * Время, за которое бегун пробежал дистанцию
     */
    private LocalTime time;

    public Runner(String name, String sex, int distance, LocalTime time) {
        this.name = name;
        this.sex = sex;
        this.distance = distance;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Runner{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", distance=" + distance +
                ", time=" + time +
                '}';
    }
}
