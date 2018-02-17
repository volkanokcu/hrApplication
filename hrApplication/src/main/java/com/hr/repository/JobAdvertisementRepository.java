package com.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hr.entity.impl.JobAdvertisement;

@Repository
public interface JobAdvertisementRepository extends JpaRepository<JobAdvertisement, Integer> {

}
