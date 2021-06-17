package com.cts.pmsm.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicineStock {
	private int id;
	private String name;
	private String chemicalComposition;
	private String targetAilment;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dateOfExpiry;
	private int numberOfTabletsInStock;
	
	
	
}
