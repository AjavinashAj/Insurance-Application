package com.avinashit.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.avinashit.entity.CitizenPlan;
import com.avinashit.repository.CitizenPlanRepository;
@Component
public class DataLoader implements ApplicationRunner{
    
	
	//insert data into DB by runner so,Need repository class to save the data
	@Autowired
	private CitizenPlanRepository repo;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		//delete all inserted data ,nhi to har bar run karne per db mai data insert hota
		repo.deleteAll();
		
		// Cash Plan Data for approved
		CitizenPlan c1=new CitizenPlan();
		c1.setCitizenName("jhon");
		c1.setGender("Male");
		c1.setPlanName("Cash");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenefitAmt(5000.00);
		
		//Cash Plan for denied
		
		CitizenPlan c2=new CitizenPlan();
		c2.setCitizenName("smith");
		c2.setGender("male");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Denied");
		c2.setDenialReason("Rental Income");
		
		//Cash plan for Data for Termination
		
		CitizenPlan c3=new CitizenPlan();
		c3.setCitizenName("Alex");
		c3.setGender("Female");
		c3.setPlanName("Cash");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now().minusMonths(4));
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenefitAmt(6000.00);
		c3.setTerminatedDate(LocalDate.now());
		c3.setTerminationRsn("Employed");
		
		// Food Plan Data for approved
				CitizenPlan c4=new CitizenPlan();
				c4.setCitizenName("David");
				c4.setGender("Male");
				c4.setPlanName("Food");
				c4.setPlanStatus("Approved");
				c4.setPlanStartDate(LocalDate.now());
				c4.setPlanEndDate(LocalDate.now().plusMonths(6));
				c4.setBenefitAmt(4000.00);
				
				//Food Plan for denied
				
				CitizenPlan c5=new CitizenPlan();
				c5.setCitizenName("Robert");
				c5.setGender("male");
				c5.setPlanName("Food");
				c5.setPlanStatus("Denied");
				c5.setDenialReason("Property Income");
				
				//Food plan for Data for Termination
				
				CitizenPlan c6=new CitizenPlan();
				c6.setCitizenName("Cathy");
				c6.setGender("Female");
				c6.setPlanName("Food");
				c6.setPlanStatus("Terminated");
				c6.setPlanStartDate(LocalDate.now().minusMonths(4));
				c6.setPlanEndDate(LocalDate.now().plusMonths(6));
				c6.setBenefitAmt(7000.00);
				c6.setTerminatedDate(LocalDate.now());
				c6.setTerminationRsn("Employed");
				
				// Medical Plan Data for approved
				CitizenPlan c7=new CitizenPlan();
				c7.setCitizenName("Charles");
				c7.setGender("Male");
				c7.setPlanName("Medical");
				c7.setPlanStatus("Approved");
				c7.setPlanStartDate(LocalDate.now());
				c7.setPlanEndDate(LocalDate.now().plusMonths(6));
				c7.setBenefitAmt(4000.00);
				
				//Medical Plan for denied
				
				CitizenPlan c8=new CitizenPlan();
				c8.setCitizenName("George");
				c8.setGender("male");
				c8.setPlanName("Medical");
				c8.setPlanStatus("Denied");
				c8.setDenialReason("Property Income");
				
				//Medical plan for Data for Termination
				
				CitizenPlan c9=new CitizenPlan();
				c9.setCitizenName("Neil");
				c9.setGender("Female");
				c9.setPlanName("Medical");
				c9.setPlanStatus("Terminated");
				c9.setPlanStartDate(LocalDate.now().minusMonths(4));
				c9.setPlanEndDate(LocalDate.now().plusMonths(6));
				c9.setBenefitAmt(7000.00);
				c9.setTerminatedDate(LocalDate.now());
				c9.setTerminationRsn("Govt.job");

				// Employment Plan Data for approved
				CitizenPlan c10=new CitizenPlan();
				c10.setCitizenName("Pushpa");
				c10.setGender("Male");
				c10.setPlanName("Employment");
				c10.setPlanStatus("Approved");
				c10.setPlanStartDate(LocalDate.now());
				c10.setPlanEndDate(LocalDate.now().plusMonths(6));
				c10.setBenefitAmt(4000.00);
				
				//Employment Plan for denied
				
				CitizenPlan c11=new CitizenPlan();
				c11.setCitizenName("Balaya");
				c11.setGender("male");
				c11.setPlanName("Employment");
				c11.setPlanStatus("Denied");
				c11.setDenialReason("Property Income");
				
				//Employment plan for Data for Termination
				
				CitizenPlan c12=new CitizenPlan();
				c12.setCitizenName("sharukh");
				c12.setGender("Female");
				c12.setPlanName("Employment");
				c12.setPlanStatus("Terminated");
				c12.setPlanStartDate(LocalDate.now().minusMonths(4));
				c12.setPlanEndDate(LocalDate.now().plusMonths(6));
				c12.setBenefitAmt(7000.00);
				c12.setTerminatedDate(LocalDate.now());
				c12.setTerminationRsn("Govt.job");
				//add all object in single group list
				List<CitizenPlan> list=Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
				//save list in repository interface ,repo mai add hote hi data run karne wakt DB mai insert ho jaye ga
		    repo.saveAll(list);
	}

}
