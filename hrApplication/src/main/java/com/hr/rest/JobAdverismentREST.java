package com.hr.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hr.entity.impl.JobAdvertisement;
import com.hr.service.JobAdvertisementService;

@RestController
public class JobAdverismentREST {
	
	private final JobAdvertisementService service;
	
	@Autowired
	public JobAdverismentREST(JobAdvertisementService service) {
		this.service = service;
	}
	
	@GetMapping("job/details/{id}")
	public ResponseEntity<JobAdvertisement> get(@RequestParam Integer id) {
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@GetMapping("job/list")
	public ResponseEntity<JobAdvertisement> getList() {
		
		return new ResponseEntity<>(null, HttpStatus.OK);
	}
	
	@PostMapping("auth/job")
	public ResponseEntity<HttpStatus> post(@RequestBody JobAdvertisement entity) {
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping("auth/job/{id}")
	public ResponseEntity<HttpStatus> put(@RequestBody JobAdvertisement entity) {
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	

}
