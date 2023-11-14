package com.example.demo1.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.Plan;
import com.example.demo1.service.PlanService;

@RestController
public class PlanRestController {

	@Autowired
	private PlanService planService;
	
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategories(){
		
		Map<Integer, String> categories = planService.getPlanCategory();
		
		return new ResponseEntity<>(categories, HttpStatus.OK);
		
	}
	
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@org.springframework.web.bind.annotation.RequestBody Plan plan){
		
		String responseMsg = "";
		
		boolean isSaved = planService.savePlan(plan);
		
		if(isSaved) {
		responseMsg = "Plan saved";
		}else {
			responseMsg = "Plan not saved";		
		}
		
		return new ResponseEntity<>(responseMsg, HttpStatus.CREATED);
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans(){
		
		List<Plan> allPlans = planService.getAllPlans();
		
		return new ResponseEntity<>(allPlans, HttpStatus.OK);
		
	}
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
		
		Plan plan = planService.getPlanById(planId);
		
		return new ResponseEntity<>(plan, HttpStatus.OK);
	}
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> delete(@PathVariable Integer planId){
		
		boolean isDeleted = planService.deletePlanById(planId);
		
		String msg = "";
		
		if(isDeleted) {
			msg="Plan Deleted";
		}else {
			msg = "Plan Not Deleted";
		}
		
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@PutMapping("/plan")
	public ResponseEntity<String> update(@org.springframework.web.bind.annotation.RequestBody Plan plan){
		
		boolean isUpdated = planService.updatePlan(plan);
		
		String msg = "";
		
		if(isUpdated) {
			msg="Plan Updated";
		}else {
			msg = "Plan Not Updated";
		}
		
		return new ResponseEntity<>(msg, HttpStatus.OK);
		
	}
	
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(Integer planId, String status){
		
		String msg = "";
		
		boolean isStatusChanged = planService.planStatusChange(planId, status);
		
		if(isStatusChanged) {
			msg="status changed";
		}else {
			msg="status not changed";
		}
		
		return new ResponseEntity<>(msg, HttpStatus.OK);
		
	}}
