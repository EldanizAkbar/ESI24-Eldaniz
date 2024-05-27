package com.esi.studentservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.esi.studentservice.dto.SSMRequestDto;
import com.esi.studentservice.model.SSMRequest;
import com.esi.studentservice.model.SSMRequestStatus;
import com.esi.studentservice.repository.SSMRequestRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SSMRequestService {

    @Autowired
    private SSMRequestRepository SSMRequestRepository;

    private final KafkaTemplate<String, SSMRequestDto> kafkaTemplate;

    public List<SSMRequestDto> getAllSSMRequest() {
        List<SSMRequest> ssmRequests = new ArrayList<>();
        SSMRequestRepository.findAll().forEach(ssmRequests::add);
        return ssmRequests.stream().map(this::mapTossmSsmRequestDto).toList();
    }

    private SSMRequestDto mapTossmSsmRequestDto(SSMRequest ssmRequest) {
        return SSMRequestDto.builder()
                .userId(ssmRequest.getUserId())
                .eventName(ssmRequest.getEventName())
                .location(ssmRequest.getLocation())
                .cost(ssmRequest.getCost())
                .advisoryDescription(ssmRequest.getAdvisoryDescription())
                .ssmRequestStatus(ssmRequest.getSsmRequestStatus())
                .build();
    }

    private SSMRequest mapToSsmRequest(SSMRequestDto ssmRequestDto) {
        SSMRequest ssmRequest = new SSMRequest();
        ssmRequest.setUserId(ssmRequestDto.getUserId());
        ssmRequest.setEventName(ssmRequestDto.getEventName());
        ssmRequest.setLocation(ssmRequestDto.getLocation());
        ssmRequest.setCost(ssmRequestDto.getCost());
        ssmRequest.setAdvisoryDescription(ssmRequestDto.getAdvisoryDescription());
        ssmRequest.setSsmRequestStatus(ssmRequestDto.getSsmRequestStatus());
        return ssmRequest;

    }

    public void addSSMRequest(SSMRequestDto ssmRequestDto) {
        SSMRequest ssmRequest = mapToSsmRequest(ssmRequestDto);
        SSMRequestRepository.save(ssmRequest);
        kafkaTemplate.send("SSMRequestCreatedTopic", ssmRequestDto);
    }

}
