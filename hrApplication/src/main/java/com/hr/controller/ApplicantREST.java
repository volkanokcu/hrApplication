package com.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hr.entity.impl.Applicant;
import com.hr.model.CustomResponse;
import com.hr.service.ApplicantService;

@RestController
public class ApplicantREST {
	
private final ApplicantService service;
	
	@Autowired
	public ApplicantREST(ApplicantService service) {
		this.service = service;
	}
	
	@GetMapping("auth/applicant/details/{id}")
	public ResponseEntity<Applicant> get(@PathVariable Integer id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}
	
	@GetMapping("auth/applicant/list")
	public ResponseEntity<List<Applicant>> getList() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(path = "applicant/add", consumes = {"multipart/form-data"})
	public ResponseEntity<CustomResponse> post(@RequestBody Applicant entity, @RequestParam("file") MultipartFile file) {
		
		service.save(entity);
		return new ResponseEntity<>(new CustomResponse(HttpStatus.CREATED.toString()), HttpStatus.CREATED);
	}

	
	@DeleteMapping("auth/applicant/delete/{id}") 
	public ResponseEntity<CustomResponse> delete(@PathVariable Integer id) {
		Applicant applicant = service.findById(id);
		if (null == applicant) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			service.delete(applicant);
			return new ResponseEntity<>(new CustomResponse(HttpStatus.OK.toString()), HttpStatus.OK);
		}
	}

}
