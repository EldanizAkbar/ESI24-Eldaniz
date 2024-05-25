package com.esi.adviserservice.dto;

import java.math.BigDecimal;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SSMRequestDto {
    private String userId;
    private String eventName;
    private String location;
    private BigDecimal cost;
    @Enumerated(EnumType.STRING)
    private SSMRequestStatus ssmRequestStatus;
}
