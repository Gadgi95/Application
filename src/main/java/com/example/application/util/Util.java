package com.example.application.util;

import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;

public class Util {
    private Util() {
    }

    public static <T extends Comparable<T>> boolean isBetweenHalfOpen(LocalDate value, @Nullable LocalTime start, @Nullable LocalTime end) {
        return (start == null || value.compareTo(ChronoLocalDate.from(start)) >= 0) && (end == null || value.compareTo(ChronoLocalDate.from(end)) < 0);
    }
}