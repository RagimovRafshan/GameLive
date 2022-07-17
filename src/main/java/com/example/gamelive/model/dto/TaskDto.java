package com.example.gamelive.model.dto;

import lombok.Builder;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Builder
public record TaskDto(
        Long id,
        String descriptionTask,
        Date startPoint,
        Boolean isPerformed,
        Long userId,
        Long moneyCapital,
        Timestamp leadTime
) implements Serializable {
}
