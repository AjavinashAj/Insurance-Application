package com.avinashit.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.avinashit.binding.SearchRequest;
import com.avinashit.entity.CitizenPlan;

public interface ReportService {
	
	public List<String>  getPlanNames();
	
	public List<String>getPlanStatuses();
	//purpose of above two abstract method is to get data from database and display into dropdown value
	
	//for search
	
	public List<CitizenPlan> search(SearchRequest request);
	
	
	//for pdf export and download from ui
	
	public boolean exportPdf(HttpServletResponse response)throws Exception;
	
	// for Excel export and download from ui
	
	public boolean exportExcel(HttpServletResponse response) throws Exception;
	

}
