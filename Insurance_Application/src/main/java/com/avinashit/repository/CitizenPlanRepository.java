package com.avinashit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.avinashit.entity.CitizenPlan;
@Repository
public interface CitizenPlanRepository extends JpaRepository<CitizenPlan, Integer>{
 
	//for unique plan name from entity class
	
	@Query("select distinct(planName) from CitizenPlan")
	public List<String> getPlanName();
	
	//for unique plan status from enity class
	
	@Query("select distinct (planStatus)from CitizenPlan")
	public List<String> getPlanStatus();
	
	//above two method for drop down only it is feaching  data from db and provind to drop down value
	
}
