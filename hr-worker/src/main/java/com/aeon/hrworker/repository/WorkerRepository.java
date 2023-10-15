package com.aeon.hrworker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aeon.hrworker.entity.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
