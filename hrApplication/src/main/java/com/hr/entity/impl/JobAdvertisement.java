package com.hr.entity.impl;


import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import com.hr.entity.AbstractEntity;

@Entity
@Table(name = "JOB_ADVERTİSEMENT")
@AttributeOverride(name="id", column=@Column(name="JOB_ADVERTİSEMENT_ID"))
public class JobAdvertisement extends AbstractEntity {

	@Transient
	private static final long serialVersionUID = 1L;
	
	@Column(name="TITLE", nullable = false, length = 250)
	private String title;
	
	@Column(name="DESCRIPTION", length = 2000)
	private String description;
	
	@Column(name="NUMBER_OF_PEOPLE_HIRE", nullable = false, length = 4)
	private Integer numberOfPeopleHire;
	
	@Temporal(TemporalType.DATE)
	@Column(name="LAST_APPLİCATON_DATE", nullable = false)
	private Date lastApplicationDate;
	
	/*GETTERS*/
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Integer getNumberOfPeopleHire() {
		return numberOfPeopleHire;
	}
	
	public Date getLastApplicationDate() {
		return lastApplicationDate;
	}
	
	/*SETTERS*/
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setNumberOfPeopleHire(Integer numberOfPeopleHire) {
		this.numberOfPeopleHire = numberOfPeopleHire;
	}
	
	public void setLastApplicationDate(Date lastApplicationDate) {
		this.lastApplicationDate = lastApplicationDate;
	}


}
