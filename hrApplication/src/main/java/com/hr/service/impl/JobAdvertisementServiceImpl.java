package com.hr.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.entity.impl.JobAdvertisement;
import com.hr.repository.JobAdvertisementRepository;
import com.hr.service.JobAdvertisementService;

@Service
public class JobAdvertisementServiceImpl implements JobAdvertisementService {

	private final JobAdvertisementRepository repository;
	
	@Autowired
	public JobAdvertisementServiceImpl(JobAdvertisementRepository repository) {
		this.repository = repository;
	}

	@Override
	public void save(JobAdvertisement entity) {
		repository.save(entity);
	}

	@Override
	public void update(JobAdvertisement entity) {
		repository.save(entity);
	}

	@Override
	public void delete(JobAdvertisement entity) {
		repository.delete(entity);
	}

	@Override
	public List<JobAdvertisement> findAll() {
		return repository.findAll();
	}

	@Override
	public List<JobAdvertisement> findAll(List<Integer> ids) {
		return repository.findAll(ids);
	}

	@Override
	public JobAdvertisement findById(Integer id) {
		return repository.findOne(id);
	}

}
