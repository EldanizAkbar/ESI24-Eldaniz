package com.esi.adviserservice.model;

import java.math.BigDecimal;

import com.esi.adviserservice.dto.SSMRequestStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "adviserservicetable")
public class SSMAdvisor {
    @Id
    private String userId;
    private String eventName;
    private String location;
    private BigDecimal cost;
    @Enumerated(EnumType.STRING)
    private SSMRequestStatus ssmRequestStatus;
}
