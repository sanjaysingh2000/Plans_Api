package com.example.demo1;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@javax.persistence.Entity
@Data
@javax.persistence.Table(name="PLAN_CATEGORY")
public class PlanCategory {
	
	@javax.persistence.Id
	@javax.persistence.GeneratedValue
	@javax.persistence.Column(name = "CATEGORY_ID")
	private Integer categoryId;
	
	@javax.persistence.Column(name = "CATEGORY_NAME")
	private String categoryName;
	
	@javax.persistence.Column(name = "ACTIVE_SW")
	private String activeSw;
	
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
