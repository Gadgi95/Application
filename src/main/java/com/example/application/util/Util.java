package com.example.application.util;

import com.example.application.model.Material;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.example.application.repository.datajpa.DataJpaTicketRepository.getTemp;

public class Util {
    private Util() {
    }

    public static <T extends Comparable<T>> boolean isBetweenHalfOpen(LocalDate value, @Nullable LocalTime start, @Nullable LocalTime end) {
        return (start == null || value.compareTo(ChronoLocalDate.from(start)) >= 0) && (end == null || value.compareTo(ChronoLocalDate.from(end)) < 0);
    }

    public static List<Material> cycleMaterials() {
        List<Material> materials = new ArrayList<>();
        for (int i = 1; i <= getTemp().size() - 1; i++) {
            materials.add((Material) getTemp().get(i));
        }
        return materials;
    }
}