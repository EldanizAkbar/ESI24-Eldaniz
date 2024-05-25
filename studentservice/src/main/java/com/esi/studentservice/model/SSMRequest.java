package com.esi.studentservice.model;

import java.math.BigDecimal;

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
@Table(name = "ssmrequeststable")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SSMRequest {
    @Id
    private String userId;
    private String eventName;
    private String location;
    private BigDecimal cost;
    private String advisoryDescription;
    @Enumerated(EnumType.STRING)
    private SSMRequestStatus ssmRequestStatus;
}
