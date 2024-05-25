package com.esi.studentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esi.studentservice.dto.SSMRequestDto;
import com.esi.studentservice.service.SSMRequestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SSMRequestController {

    @Autowired
    private SSMRequestService ssmRequestService;

    @PostMapping("/ssmrequests")
    public ResponseEntity<String> addSSMRequest(@RequestBody SSMRequestDto ssmRequestDto) {
        ssmRequestService.addSSMRequest(ssmRequestDto);
        return ResponseEntity.ok("An SSM Request has been created");

    }
}
