package com.example.demo1;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@javax.persistence.Entity
@Data
@javax.persistence.Table(name="PLAN_MASTER")
public class Plan {
	
	@javax.persistence.Id
	@javax.persistence.GeneratedValue
	@javax.persistence.Column(name="PLAN_ID")
	private Integer planId;
	
	@javax.persistence.Column(name="PLAN_NAME")
	private String planName;
	
	
	@javax.persistence.Column(name="PLAN_START_DATE")
	private LocalDateTime startDate;
	
	
	@javax.persistence.Column(name="PLAN_END_DATE")
	private LocalDateTime endDate;
	
	@javax.persistence.Column(name="Active_SW")
	private String activeSw;

	@Column(name = "PLAN_CATEGORY_ID")
	private Integer planCategoryId;
	
	
	@javax.persistence.Column(name = "CREATED_BY")
	private String createdBy;
	
	@javax.persistence.Column(name = "UPDATED_BY")
	private String updatedBy;
	
	@javax.persistence.Column(name = "CREATED_DATE" , updatable = false)
	@CreationTimestamp
	private LocalDate createDate;
	
	@javax.persistence.Column(name = "UPDATED_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDate updateDate;
}

