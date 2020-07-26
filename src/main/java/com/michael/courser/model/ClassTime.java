package com.michael.courser.model;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class ClassTime {

    private DayOfWeek day;

    private LocalTime startTime;
    private LocalTime endTime;

    public ClassTime(DayOfWeek day, LocalTime startTime, LocalTime endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public DayOfWeek getDay() { return day; }

    public void setDay(DayOfWeek day) { this.day = day; }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "ClassTime{" +
                "day=" + day +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
