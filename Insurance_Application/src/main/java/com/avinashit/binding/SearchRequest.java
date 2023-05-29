package com.avinashit.binding;

import lombok.Data;

@Data
public class SearchRequest {

	private String planName;
	
	private String planStatus;
	
	private String gender;
	//@DateTimeFormat(pattern="mm-dd-yyyy")
	private String startDate;//localdate ka formate yyyy-mm-dd hota hai ,so here mismatch ho rha hai
	//@DateTimeFormat(pattern="mm-dd-yyyy")
	private String endDate;
	
}
