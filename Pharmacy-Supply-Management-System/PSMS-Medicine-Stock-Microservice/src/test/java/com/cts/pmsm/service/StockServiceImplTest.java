package com.cts.pmsm.service;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.pmsm.exception.MedicineStockNotFoundException;
import com.cts.pmsm.model.MedicineStock;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StockServiceImplTest {

	@Autowired
	private StockServiceImpl stockService;
	
	@Mock
	private MedicineStock medicineStock;
	
	@Test
	public void testGetAllMedicineStock()
	{
		List<MedicineStock> list=stockService.getAllMedicineStock();
		assertNotNull(list);
	}
	
	@Test
	public void testGetAllMedicineStockFail()
	{
		List<MedicineStock> list=stockService.getAllMedicineStock();
		assertNotNull(list);
	}
	
	@Test
	public void testGetStockByIdTest() 
	{
		String medicineName="";
		try {
		medicineName=stockService.getStockById(1).getName();
		}
		catch(MedicineStockNotFoundException e)
		{
			
		}
		
		assertEquals(medicineName,"calpol");
		
	}
	
	@Test
	public void testUpdateStockById()
	{
		LocalDate date=LocalDate.of(2022, 9, 8);
		String medicineName="";
		MedicineStock obj=new MedicineStock(1,"paracip","paracetamol 1000","fever",date,200);
		try {
			stockService.updateStockById(1, obj);
			medicineName=stockService.getStockById(1).getName();
			}
		catch(MedicineStockNotFoundException e)
			{
				
			}
		assertEquals("paracip",medicineName);
	}
	

}
