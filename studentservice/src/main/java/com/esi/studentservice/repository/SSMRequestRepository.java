package com.esi.studentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esi.studentservice.model.SSMRequest;

public interface SSMRequestRepository extends JpaRepository<SSMRequest, String> {
}
