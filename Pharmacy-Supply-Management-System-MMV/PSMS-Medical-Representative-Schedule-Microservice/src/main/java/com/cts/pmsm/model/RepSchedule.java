package com.cts.pmsm.model;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RepSchedule {
	
	private String repName;
	private String doctorName;
	private String meetingSlot;
	private LocalDate meetingDate;
	private String doctorContactNumber;
	private List<String> medicines;
	private String treatingAilment;
	
	
}
