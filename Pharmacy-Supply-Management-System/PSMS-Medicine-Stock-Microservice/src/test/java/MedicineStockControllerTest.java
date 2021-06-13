import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.pmsm.exception.MedicineStockNotFoundException;
import com.cts.pmsm.model.MedicineStock;
import com.cts.pmsm.service.StockServiceImpl;

import lombok.extern.slf4j.Slf4j;



@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
public class MedicineStockControllerTest {

	@InjectMocks
	private MedicineStockController medicineStockController;
	
	@Mock
	private MedicineStock medicineStock;
	
	@Mock
	private StockServiceImpl stockService;
	
	@Test
	public void testGetStockInformation() {
		List<MedicineStock> list=medicineStockController.getStockInformation();
		assertNotNull(list);
	}
	
	@Test
	public void testGetStockById()
	{
		try
		{
			ResponseEntity<?> getStock=medicineStockController.getStockById(1);
			HttpStatus statusCode=getStock.getStatusCode();
			assertNotNull(statusCode);
			assertEquals(statusCode,HttpStatus.OK);
		}
		catch(MedicineStockNotFoundException e)
		{}
	}
	
	@Test
	public void testCreateMedicineStock()
	{
		LocalDate date=LocalDate.of(2022, 9, 8);
		MedicineStock obj = new MedicineStock(8,"Ivepred","Methyl Predisolone","Steroid",date,250);
		ResponseEntity<?> createMedicine=medicineStockController.createMedicineStock(obj);
		HttpStatus statusCode=createMedicine.getStatusCode();
		assertNotNull(statusCode);
		assertEquals(statusCode,HttpStatus.OK);
	}
	
	@Test
	public void testDeleteStockById()
	{
		ResponseEntity<?> deleteMedicine=medicineStockController.deleteStockById(7);
		HttpStatus statusCode=deleteMedicine.getStatusCode();
		assertNotNull(statusCode);
		assertEquals(statusCode,HttpStatus.OK);
	}
	
	@Test
	public void testUpdateStockById()
	{
		try
		{
			LocalDate date=LocalDate.of(2022, 9, 8);
			MedicineStock obj = new MedicineStock(8,"Ivepred 8","Methyl Predisolone","Steroid",date,250);
			ResponseEntity<?> updateMedicine=medicineStockController.updateStockById(8, obj);
			HttpStatus statusCode=updateMedicine.getStatusCode();
			assertNotNull(statusCode);
			assertEquals(statusCode,HttpStatus.OK);
		}
		catch(MedicineStockNotFoundException e) {}
	}

}
