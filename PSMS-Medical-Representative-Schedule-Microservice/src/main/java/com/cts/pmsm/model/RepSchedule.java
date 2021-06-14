package com.cts.pmsm.model;

import java.time.LocalDate;
import java.util.List;

public class RepSchedule {
	
	private String repName;
	private String doctorName;
	private String meetingSlot;
	private LocalDate meetingDate;
	private String doctorContactNumber;
	private List<String> medicines;
	private String treatingAilment;
	
	public String getRepName() {
		return repName;
	}
	public void setRepName(String repName) {
		this.repName = repName;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getMeetingSlot() {
		return meetingSlot;
	}
	public void setMeetingSlot(String meetingSlot) {
		this.meetingSlot = meetingSlot;
	}
	public LocalDate getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(LocalDate meetingDate) {
		this.meetingDate = meetingDate;
	}
	public String getDoctorContactNumber() {
		return doctorContactNumber;
	}
	public void setDoctorContactNumber(String doctorContactNumber) {
		this.doctorContactNumber = doctorContactNumber;
	}
	public List<String> getMedicines() {
		return medicines;
	}
	public void setMedicines(List<String> medicines) {
		this.medicines = medicines;
	}
	public String getTreatingAilment() {
		return treatingAilment;
	}
	public void setTreatingAilment(String treatingAilment) {
		this.treatingAilment = treatingAilment;
	}
	public RepSchedule(String repName, String doctorName, String meetingSlot, LocalDate meetingDate,
			String doctorContactNumber, List<String> medicines, String treatingAilment) {
		super();
		this.repName = repName;
		this.doctorName = doctorName;
		this.meetingSlot = meetingSlot;
		this.meetingDate = meetingDate;
		this.doctorContactNumber = doctorContactNumber;
		this.medicines = medicines;
		this.treatingAilment = treatingAilment;
	}
	public RepSchedule() {
		super();
	}
}
