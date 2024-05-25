package com.esi.adviserservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esi.adviserservice.dto.SSMRequestDto;
import com.esi.adviserservice.service.SSMAdvisorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SSMAdvisorController {

    @Autowired
    private SSMAdvisorService ssmAdvisorService;

    @PutMapping("/ssmresponse")
    public ResponseEntity<String> updateSSMResponse(@RequestBody SSMRequestDto ssmRequestDto) {
        ssmAdvisorService.updateSSMResponse(ssmRequestDto);
        return ResponseEntity.ok("An SSM Request is updated");

    }
}
