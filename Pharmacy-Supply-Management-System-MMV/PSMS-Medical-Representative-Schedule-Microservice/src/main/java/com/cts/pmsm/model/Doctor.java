package com.cts.pmsm.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Doctor {
	@Id
	private int id;
	private String name;
	private String contactNumber;
	private String treatingAilment;
	private String preferredSlot;
	
	
}
