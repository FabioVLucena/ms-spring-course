package com.aeon.hrworker.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aeon.hrworker.entity.Worker;
import com.aeon.hrworker.repository.WorkerRepository;

@RestController
@RequestMapping("/api/v1/workers")
public class WorkerController {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerController.class);
	
	private Environment environment;
	
	private WorkerRepository workerRepository;

	public WorkerController(Environment environment, WorkerRepository workerRepo) {
		this.environment = environment;
		this.workerRepository = workerRepo;
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> workerList = workerRepository.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(workerList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		logger.info("PORT = " + environment.getProperty("server.port"));
		
		Worker worker = workerRepository.findById(id).get();
		
		return ResponseEntity.status(HttpStatus.OK).body(worker);
	}
	
}
