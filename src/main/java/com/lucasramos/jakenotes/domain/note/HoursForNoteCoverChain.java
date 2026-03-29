package com.lucasramos.jakenotes.domain.note;

import com.lucasramos.jakenotes.enums.EpochsForNoteCover;
import net.minidev.json.annotate.JsonIgnore;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class HoursForNoteCoverChain {

    public static String getCreatedAtForNoteCover(OffsetDateTime createdAt) {
        OffsetDateTime now = OffsetDateTime.now();
        Long seconds = ChronoUnit.SECONDS.between(createdAt, now);

        if(seconds <= EpochsForNoteCover.DAY.multiply(2L)) {
            return HoursForNoteCoverChain.getAboutHour(seconds);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.of("pt", "BR"));
        return createdAt.format(formatter);
    }

    public static String getAboutHour(Long seconds) {
        if (seconds <= EpochsForNoteCover.HOUR.getSeconds()) {
            return "Menos de uma hora atrás";
        }

        return getHours(seconds);
    }

    public static String getHours(Long seconds) {
        if(seconds <= EpochsForNoteCover.DAY.getSeconds()) {
            Long hours = seconds / EpochsForNoteCover.HOUR.getSeconds();
            if (hours == 1) {
                return "Uma hora atrás";
            }

            return hours + " horas atrás";
        }

        return "Ontem";
    }
}