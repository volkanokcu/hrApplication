package com.hr.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hr.entity.impl.Applicant;
import com.hr.repository.ApplicantRepository;
import com.hr.service.ApplicantService;

@Service
public class ApplicantServiceImpl implements ApplicantService {

	private final ApplicantRepository repository;
	
	@Autowired
	public ApplicantServiceImpl(ApplicantRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void save(Applicant entity) {
		repository.save(entity);
	}

	@Override
	public void update(Applicant entity) {
		repository.save(entity);
	}

	@Override
	public void delete(Applicant entity) {
		repository.delete(entity);
	}

	@Override
	public List<Applicant> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Applicant> findAll(List<Integer> ids) {
		return repository.findAll(ids);
	}

	@Override
	public Applicant findById(Integer id) {
		return repository.findOne(id);
	}

}
