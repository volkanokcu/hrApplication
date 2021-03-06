package com.hr.entity.impl;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.hr.entity.AbstractEntity;

@Entity
@Table(name = "APPLICANT")
@AttributeOverride(name="id", column=@Column(name="APPLICANT_ID"))
public class Applicant extends AbstractEntity {

	@Transient
	private static final long serialVersionUID = 1L;
	
	@Column(name="NAME", nullable = false, length = 100)
	private String name;
	
	@Column(name="EMAIL", nullable=false, length = 100)
	private String email;

	@Column(name="PHONE", nullable=false, length = 100)
	private String phone;
	
	@Column(name="THOUGHTS_ON_JOB", nullable=false, length = 1000)
	private String thoughtsOnJob;
	
	@Column(name="RESUME", length = 1000)
	private String resume;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="REF_JOB_ADVERISMENT_ID")
	private JobAdvertisement jobAdvertisement;
	
	public Applicant() {
		// TODO Auto-generated constructor stub
	}
	
	public Applicant(String name, String email, String phone, String thoughtsOnJob, String resume,
			JobAdvertisement jobAdvertisement) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.thoughtsOnJob = thoughtsOnJob;
		this.resume = resume;
		this.jobAdvertisement = jobAdvertisement;
	}



	/*GETTERS*/
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getThoughtsOnJob() {
		return thoughtsOnJob;
	}

	public String getResume() {
		return resume;
	}
	
	public JobAdvertisement getJobAdvertisement() {
		return jobAdvertisement;
	}

	/*SETTERS*/
	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setThoughtsOnJob(String thoughtsOnJob) {
		this.thoughtsOnJob = thoughtsOnJob;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
	
	public void setJobAdvertisement(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisement = jobAdvertisement;
	}

}
