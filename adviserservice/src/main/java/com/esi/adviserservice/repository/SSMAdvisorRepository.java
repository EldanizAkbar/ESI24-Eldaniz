package com.esi.adviserservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esi.adviserservice.model.SSMAdvisor;

public interface SSMAdvisorRepository extends JpaRepository<SSMAdvisor, String> {
}
