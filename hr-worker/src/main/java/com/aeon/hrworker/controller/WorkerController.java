package com.aeon.hrworker.controller;

import java.util.List;

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

	private WorkerRepository workRepo;

	public WorkerController(WorkerRepository workRepo) {
		this.workRepo = workRepo;
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> workList = workRepo.findAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(workList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id) {
		System.out.println(id);
			
		Worker work = workRepo.findById(id).get();
		
		return ResponseEntity.status(HttpStatus.OK).body(work);
	}
	
}
