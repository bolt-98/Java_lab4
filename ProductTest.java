package lab1;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;

public class ProductTest {
@DataProvider
	  public Object[][] testForNameRg() {
	Product P = new Product("Chess", 25.86, 256, LocalDate.of(2015, 11, 17));
	Product P1 = new Product("Appl854%e", 45.0, 3587, LocalDate.of(2018, 07, 17));	
	return new Object[][] {
	    	 {P1, false},{P, true}
	     
	    };
	  }
@Test(dataProvider = "testForNameRg")
	  public void testNameRg(Product n, boolean s) {
		  assertEquals(n.regular_nm(),s);
	  } 
@DataProvider
	  public Object[][] testForPriceRg() {
	Product P = new Product("Chess", 25.86, 256, LocalDate.of(2015, 11, 17));
	Product P1 = new Product("Apple", 45.0, 3587, LocalDate.of(2018, 07, 17));	
	return new Object[][] {
	    	 {P1, true},{P, true}
	     
	    };
	  }
@Test(dataProvider = "testForPriceRg")
	  public void testPriceRg(Product n, boolean s) {
		  assertEquals(n.regular_pr(),s);
	  }
	

@DataProvider
  public Object[][] testForDate() {
	Product P = new Product("Chess", 25.5, 256, LocalDate.of(2015, 11, 17));
	Product P1 = new Product("Apple", 45.0, 3587, LocalDate.of(2018, 07, 17));
	return new Object[][] {
    	{P, false}, {P1, true}
     
    };
  }
  @Test(dataProvider = "testForDate")
  public void testDate(Product n, boolean s) {
	  assertEquals(n.dateOff(),s);
  }


}
