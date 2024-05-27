package com.esi.adviserservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.esi.adviserservice.dto.SSMRequestDto;
import com.esi.adviserservice.model.SSMAdvisor;
import com.esi.adviserservice.repository.SSMAdvisorRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class SSMAdvisorService {

  @Autowired
  private SSMAdvisorRepository ssmAdvisorRepository;

  private final KafkaTemplate<String, SSMRequestDto> kafkaTemplate;

  public void consumeSSMRequest(SSMRequestDto ssmRequestDto) {
    log.info("An SSM Request with user id: {} has been received", ssmRequestDto.getUserId());

    SSMAdvisor ssmAdvisor = SSMAdvisor.builder()
        .userId(ssmRequestDto.getUserId())
        .eventName(ssmRequestDto.getEventName())
        .location(ssmRequestDto.getLocation())
        .cost(ssmRequestDto.getCost())
        .ssmRequestStatus(ssmRequestDto.getSsmRequestStatus())
        .build();
  }

  public void updateSSMResponse(SSMRequestDto ssmRequestDto) {

    SSMAdvisor ssmAdvisor = SSMAdvisor.builder()
        .userId(ssmRequestDto.getUserId())
        .userId(ssmRequestDto.getUserId())
        .eventName(ssmRequestDto.getEventName())
        .location(ssmRequestDto.getLocation())
        .cost(ssmRequestDto.getCost())
        .ssmRequestStatus(ssmRequestDto.getSsmRequestStatus())
        .build();

    log.info("An SSM Reuest with user id: {} has been updated", ssmAdvisor.getUserId());
    log.info("An SSM Reuest with user id: {} has been updated", ssmAdvisor.toString());

    ssmAdvisorRepository.save(ssmAdvisor);

  }

}
