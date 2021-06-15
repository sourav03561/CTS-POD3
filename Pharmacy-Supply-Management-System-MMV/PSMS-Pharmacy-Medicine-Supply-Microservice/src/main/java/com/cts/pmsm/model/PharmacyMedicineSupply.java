package com.cts.pmsm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PharmacyMedicineSupply {

	private String pharmacyName;
	private String medicineName;
	private int supplyCount;
	
	
}
