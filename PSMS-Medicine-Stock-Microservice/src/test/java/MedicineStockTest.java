import java.time.LocalDate;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.cts.pmsm.model.MedicineStock;



public class MedicineStockTest {
    private MedicineStock medicine;
    @Before
    public void setup() throws Exception{
    	medicine=new MedicineStock(1,"paracitamol","Mn","br",LocalDate.parse("2020-10-04"),50);
    }
    @Test
    public void testMedicineDetails() throws Exception{
    	Assert.assertEquals(1, medicine.getId());
    	Assert.assertEquals("paracitamol", medicine.getName());
    	Assert.assertEquals("Mn", medicine.getChemicalComposition());
    	Assert.assertEquals("br", medicine.getTargetAilment());
    	Assert.assertEquals(LocalDate.parse("2020-10-04"), medicine.getDateOfExpiry());
    	Assert.assertEquals(50, medicine.getNumberOfTabletsInStock());
    }
}
