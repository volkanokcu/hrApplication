package com.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hr.entity.impl.JobAdvertisement;
import com.hr.model.CustomResponse;
import com.hr.service.JobAdvertisementService;

@RestController
public class JobAdverismentREST {
	
	private final JobAdvertisementService service;
	
	@Autowired
	public JobAdverismentREST(JobAdvertisementService service) {
		this.service = service;
	}
	
	@GetMapping("job/details/{id}")
	public ResponseEntity<JobAdvertisement> get(@PathVariable Integer id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}
	
	@GetMapping("job/list")
	public ResponseEntity<List<JobAdvertisement>> getList() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("auth/job")
	public ResponseEntity<CustomResponse> post(@RequestBody JobAdvertisement entity) {
		service.save(entity);
		return new ResponseEntity<>(new CustomResponse(HttpStatus.CREATED.toString()), HttpStatus.CREATED);
	}
	
	@PutMapping("auth/job")
	public ResponseEntity<CustomResponse> put(@RequestBody JobAdvertisement entity) {
		JobAdvertisement advertisement = service.findById(entity.getId());
		if (advertisement == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else { 
			service.save(entity);
			return new ResponseEntity<>(new CustomResponse(HttpStatus.OK.toString()), HttpStatus.OK);
		}
	}
	
	@DeleteMapping("auth/job/{id}") 
	public ResponseEntity<CustomResponse> delete(@PathVariable Integer id) {
		JobAdvertisement advertisement = service.findById(id);
		if (null == advertisement) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			service.delete(advertisement);
			return new ResponseEntity<>(new CustomResponse(HttpStatus.OK.toString()), HttpStatus.OK);
		}
	}
	

}
