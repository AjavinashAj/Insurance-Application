package com.avinashit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.filters.ExpiresFilter.XHttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.avinashit.binding.SearchRequest;
import com.avinashit.entity.CitizenPlan;
import com.avinashit.service.ReportService;

@Controller
public class ReportController {
	
	@Autowired
	private ReportService service;
	
	//for download pdf file
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception
	{
		//type of file to send pdf
		response.setContentType("application/pdf");
		
		//header specify in which formet response come
		response.addHeader("Content-Disposition", "attachment;filename=plans.pdf");
		service.exportPdf(response);
		
	}
	//for download Excel file
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception
	{
		//type of file to send pdf/excel(octet-stream)
		response.setContentType("application/octet-stream");
		
		//header specify in which formet response come
		response.addHeader("Content-Disposition", "attachment;filename=plans.xls");
		service.exportExcel(response);
		
	}

	
	@PostMapping("/handle")
	public String handleSearch(@ModelAttribute("request")SearchRequest request,Model model)
	{
		//for show search data from db on console
		System.out.println(request);
		
		//for show search data from db on UI
		List<CitizenPlan> plans=service.search(request);
		model.addAttribute("plans",plans);
		init(model);
		return "index";
	}

	@GetMapping("/")
	public String indexPage(Model model)
	{
		//bec i want data only one time load from database
		model.addAttribute("request",new SearchRequest());
		init(model);
		//init(model);
		return "index";
	}

	

	private void init(Model model) {
		model.addAttribute("names",service.getPlanNames());
		model.addAttribute("status",service.getPlanStatuses());
		
		//because every search time data is loading but i don't want
		//SearchRequest searchobj =new SearchRequest();
		//model.addAttribute("request",searchobj);
	}
	
	
}
