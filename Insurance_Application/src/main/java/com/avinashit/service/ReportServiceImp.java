package com.avinashit.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.avinashit.binding.SearchRequest;
import com.avinashit.entity.CitizenPlan;
import com.avinashit.repository.CitizenPlanRepository;
import com.avinashit.util.EmailUtils;
import com.avinashit.util.ExcelGenerator;
import com.avinashit.util.PdfGenerator;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class ReportServiceImp implements ReportService{
    @Autowired
	private CitizenPlanRepository planRepo;
    
    @Autowired
	private ExcelGenerator excelGenerator;
    
    @Autowired
    private PdfGenerator pdfGenerator;
    
    @Autowired
    private EmailUtils emailUtils;
    
	@Override
	public List<String> getPlanNames() {
		return planRepo.getPlanName();
	}

	@Override
	public List<String> getPlanStatuses() {
		return planRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		
		CitizenPlan entity=new CitizenPlan();
		
		//for plan name search
		if(null!=request.getPlanName() && !"".equals(request.getPlanName()))
		{
			entity.setPlanName(request.getPlanName());

		}
		
		//for plan status search
		if(null!=request.getPlanStatus() && !"".equals(request.getPlanStatus()))
		{
			entity.setPlanStatus(request.getPlanStatus());
		}
		
		//for gender search
		if(null!=request.getGender() && !"".equals(request.getGender()))
		{
			entity.setGender(request.getGender());
		}
		
		//for Start date search
		if(null!=request.getStartDate() && !"".equals(request.getStartDate()))
		{
			String startDate=request.getStartDate();
			//convert string into LOcalDate
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
			
			LocalDate date = LocalDate.parse("startDate", formatter);
			
			entity.setPlanStartDate(date);
		}
		
					return planRepo.findAll(Example.of(entity));
	}
	
	

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception{
		
		//create file object
				File f=new File("Plans.xls");
				
		//for downloading excel file
		List<CitizenPlan>plans =planRepo.findAll();
		excelGenerator.generate(response, plans,f);
		
		//for sending excel file as attachement through mail
		String subject ="Text mail subject";
		String body="<h1>Test Mail bidy</h1>";
		String to="delhiboy1345@gmail.com";
		
		
		emailUtils.sendEmail(subject, body, to,f);
		//after sending email as attachment i want to delete excel file from my folder
		f.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		
		//create file object
		File f=new File("Plans.pdf");
		
		List<CitizenPlan> plans=planRepo.findAll();
		pdfGenerator.generate(response, plans,f);
		

		//for sending excel file as attachement through mail
		String subject ="Text mail subject";
		String body="<h1>Test Mail bidy</h1>";
		String to="delhiboy1345@gmail.com";
		
		emailUtils.sendEmail(subject, body, to,f);
		//after sending email as attachment i want to delete pdf file from my folder
		f.delete();
		return true;
	}

	

}
