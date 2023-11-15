package com.example.demo1.rest;

import java.util.List;
import java.util.Map;

import org.jboss.logging.Messages;
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
import com.example.demo1.constants.AppConstants;
import com.example.demo1.props.AppProperties;
import com.example.demo1.service.PlanService;

@RestController
public class PlanRestController {

	private PlanService planService;
	
	private AppProperties appProps;
	
	private Map<String, String> messages;
	
	public PlanRestController(PlanService planService, AppProperties appProps) {
		
		this.planService=planService;
		this.messages=appProps.getMessages();
	}
	 
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategories(){
		
		Map<Integer, String> categories = planService.getPlanCategory();
		
		return new ResponseEntity<>(categories, HttpStatus.OK);
		
	}
	
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@org.springframework.web.bind.annotation.RequestBody Plan plan){
		
		String responseMsg = AppConstants.Empty_STR;
		
		boolean isSaved = planService.savePlan(plan);
		
		if(isSaved) {
			
			responseMsg = messages.get(AppConstants.PLAN_SAVE_SUCC);
		}else {
			responseMsg = messages.get(AppConstants.PLAN_SAVE_FAIL);
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
		
		String msg = AppConstants.Empty_STR;
		
		if(isDeleted) {
			msg=messages.get(AppConstants.PLAN_DELETE_SUCCESS);
		}else {
			msg = messages.get(AppConstants.PLAN_DELETE_FAIL);
		}
		
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
	
	@PutMapping("/plan")
	public ResponseEntity<String> update(@org.springframework.web.bind.annotation.RequestBody Plan plan){
		
		boolean isUpdated = planService.updatePlan(plan);
	
		String msg = AppConstants.Empty_STR;
		
		if(isUpdated) {
			msg= messages.get(AppConstants.PLAN_UPDATE_SUCC);
		}else {
			msg = messages.get(AppConstants.PLAN_UPDATE_FAIL);
		}
		
		return new ResponseEntity<>(msg, HttpStatus.OK);
		
	}
	
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(Integer planId, String status){
		
		String msg = AppConstants.Empty_STR;
		
		boolean isStatusChanged = planService.planStatusChange(planId, status);
		
		if(isStatusChanged) {
			msg = messages.get(AppConstants.PLAN_STATUS_CHANGED_SUCC);
		}else {
			msg=messages.get(AppConstants.PLAN_STATUS_CHANGED_FAIL);
		}
		
		return new ResponseEntity<>(msg, HttpStatus.OK);
		
	}}
