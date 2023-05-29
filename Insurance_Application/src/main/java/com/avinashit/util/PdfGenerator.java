package com.avinashit.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.avinashit.entity.CitizenPlan;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class PdfGenerator {
	
	

	public void generate(HttpServletResponse response, List<CitizenPlan> plans,File f) throws Exception{
		
		// Creating the Object of Document
				Document document=new Document(PageSize.A4);
				
				// Getting instance of PdfWriter for the browser pdf download
				PdfWriter.getInstance(document, response.getOutputStream());
				
				//service layer pass file object for pdf email and pdfwriter created for email send
				PdfWriter.getInstance(document, new FileOutputStream(f));
				
				// Opening the created document to change it
				document.open();
				
				// Creating font
			    // Setting font style and size
			    Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
			    fontTiltle.setSize(20);
				 // Creating paragraph
				Paragraph p=new Paragraph("Citizen-Plan-Info", fontTiltle);
				// Aligning the paragraph in the document
			    p.setAlignment(Paragraph.ALIGN_CENTER);
			    
				// Adding the created paragraph in the document
				document.add(p);
				
				// Creating a table of the 6 columns
				PdfPTable table=new PdfPTable(6);
				// Setting width of the table, its columns and spacing
			    table.setWidthPercentage(100f);
			    table.setWidths(new int[] {3,3,3,3,3,3});
			    table.setSpacingBefore(5);
			    
				table.addCell("Id");
				table.addCell("Citizen Name");
				table.addCell("Plan Name");
				table.addCell("Plan Status");
				table.addCell("Start Date");
				table.addCell("End Date");
				//List<CitizenPlan> plans=planRepo.findAll();
				for(CitizenPlan plan:plans)
				{
					//add cell expecting string value but citizenId is integer so we need to convert integer to string by using valueOf() before addCell()
					table.addCell(String.valueOf(plan.getCititzenId()));
					table.addCell(plan.getCitizenName());
					table.addCell(plan.getPlanName());
					table.addCell(plan.getPlanStatus());
					if(null!=plan.getPlanStartDate())
					{
						table.addCell(plan.getPlanStartDate()+"");//converting string by ""
					}
					else
					{
						table.addCell("N/A");
					}
					if(null!=plan.getPlanEndDate())
					{
						table.addCell(plan.getPlanEndDate()+"");
					}
					else
					{
						table.addCell("N/A");
					}
					
					
				}
				document.add(table);
				document.close();
	}

}
