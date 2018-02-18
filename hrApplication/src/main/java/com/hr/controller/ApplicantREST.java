package com.hr.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hr.entity.impl.Applicant;
import com.hr.entity.impl.JobAdvertisement;
import com.hr.model.CustomResponse;
import com.hr.service.ApplicantService;
import com.hr.util.FileUtil;

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
	
	@PostMapping("applicant/add")
	public ResponseEntity<CustomResponse> post(@RequestParam("name") String name, 
		@RequestParam("email") String email, 
		@RequestParam("phone") String phone,
		@RequestParam("thoughtsOnJob") String thoughtsOnJob,
		@RequestParam("jobId") Integer jobId,
		@RequestParam("file") MultipartFile file) {
		
		String resume = null;
		try {
			resume = FileUtil.write(file, this.getClass());
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(new CustomResponse(HttpStatus.CONFLICT.toString()), HttpStatus.CONFLICT);
		}
		JobAdvertisement advertisement = new JobAdvertisement();
		advertisement.setId(jobId);
		Applicant entity = new Applicant(name, email, phone, thoughtsOnJob, resume, advertisement);
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
			try {
				FileUtil.delete(applicant.getResume(), this.getClass());
			} catch (IOException e) {
				System.out.println("Dosya Bulunamadı");
			}
			return new ResponseEntity<>(new CustomResponse(HttpStatus.OK.toString()), HttpStatus.OK);
		}
	}

}
