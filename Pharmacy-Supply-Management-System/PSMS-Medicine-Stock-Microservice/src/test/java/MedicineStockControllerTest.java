import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cts.pmsm.controller.MedicineStockController;

@RunWith(SpringJUnit4ClassRunner.class)
public class MedicineStockControllerTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private MedicineStockController medicine;
	
	@Before
	public void setUp() throws Exception{
		mockMvc=MockMvcBuilders.standaloneSetup(medicine).build();
	}
	
	@Test
	public void testHealthCheck() throws Exception {
		
		mockMvc.perform(
				MockMvcRequestBuilders.get("/healthCheck")
				)
		   .andExpect(status().isOk())
		   .andExpect(content().string("working"));
		
	}
	
}
