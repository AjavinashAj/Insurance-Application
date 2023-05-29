package com.avinashit.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.avinashit.entity.CitizenPlan;

@Component
public class ExcelGenerator {
	
	public void generate(HttpServletResponse response,List<CitizenPlan>plans ,File file)throws Exception
	{
		Workbook workbook =new HSSFWorkbook();
		 Sheet sheet = workbook.createSheet("Plan-Data");
		 Row headerRow= sheet.createRow(0);
		 
		 headerRow.createCell(0).setCellValue("Id");
		 headerRow.createCell(1).setCellValue("Citizen Name");
		 headerRow.createCell(2).setCellValue("Plan Name");
		 headerRow.createCell(3).setCellValue("Plan Status");
		 headerRow.createCell(4).setCellValue("Plan Start Date");
		 headerRow.createCell(5).setCellValue("Plan End Date");
		 headerRow.createCell(6).setCellValue("Benifit Amt");
		 
		
		 
		 int dataRowIndex=1;
		 
		 for(CitizenPlan plan:plans)
		 {
			Row dataRow=  sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(plan.getCititzenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getPlanName());
			dataRow.createCell(3).setCellValue(plan.getPlanStatus());
			if(null!=plan.getPlanStartDate())
			{
				dataRow.createCell(4).setCellValue(plan.getPlanStartDate());
			}
			else
			{
				dataRow.createCell(4).setCellValue("N/A");
			}
			if(null !=plan.getPlanEndDate())
			{
				dataRow.createCell(5).setCellValue(plan.getPlanEndDate());
			}
			else
			{
				dataRow.createCell(5).setCellValue("N/A");
			}
			
			if(null !=plan.getBenefitAmt())
			{
				dataRow.createCell(6).setCellValue(plan.getBenefitAmt());
			}
			else
			{
				dataRow.createCell(6).setCellValue("N/A");
			}
			
			dataRowIndex++;
		 }
		 
		 //for save excel file in current folder .it will use as to send as attachement in email
		 FileOutputStream fos=new FileOutputStream(file);
		 workbook.write(fos);
		 fos.close();
		 
		 
		 //for sending response (excel file)in web Browser
		 ServletOutputStream outputstream=response.getOutputStream();
		 workbook.write(outputstream);
		 workbook.close();
	}

}
