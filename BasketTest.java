package lab1;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.time.LocalTime;
import org.testng.annotations.BeforeTest;
import java.time.Month;

public class BasketTest {
  
  
	Product Product_0,Product_1,Product_2,Product_3;
	Basket B;
	ArrayList<Product> k = new ArrayList<Product>();
	@BeforeTest
	public void start() {
		Product_0 = new Product("Chess", 23.5, 256, LocalDate.of(2015, 01, 15));
		Product_1 = new Product("Apple", 45.0, 3587, LocalDate.of(2016, 07, 17));
		Product_2 = new Product("Milk", 115.0, 8926, LocalDate.of(2010, 02, 14));
		Product_3 = new Product("Fish", 27.5, 21856, LocalDate.of(2007, 01, 01));
		k.add(Product_0);
		k.add(Product_1);
		k.add(Product_2);
		k.add(Product_3);
		B = new Basket(k, 2658, "Bogdan");
	}
@DataProvider
  public Object[][] testForSortUp() {
    ArrayList<Product> t = new ArrayList<Product>();
    t.add(Product_1);
    t.add(Product_0);
    t.add(Product_3);
    t.add(Product_2);
    	
    return new Object[][] {{B,t}};
    
  }
  
  @Test(dataProvider = "testForSortUp")
  public void testSort_one(Basket b,  ArrayList<Product> r ) {
	assertEquals(b.sort_Up_alphabet(),r);
  }
  
  @DataProvider
  public Object[][] testForSortdown() {
    ArrayList<Product> t = new ArrayList<Product>();
    t.add(Product_1);
    t.add(Product_0);
    t.add(Product_3);
    t.add(Product_2);
    	
    return new Object[][] {{B,t}};
    
  }
  
  @Test(dataProvider = "testForSortdown")
  public void testSort_two(Basket b,  ArrayList<Product> r ) {
	assertEquals(b.sort_Up_alphabet(),r);
  }
  @DataProvider
  public Object[][] testForCount(){
	  
	  
	  return new Object[][] {{B, 4}};
  }
  @Test(dataProvider = "testForSum")
  public void testCount(Basket b, double rez ) {
	assertEquals(b.Sum(),rez);
  }
  @DataProvider
  public Object[][] testForSum(){
	  
	  return new Object[][] {{B, 211.0}};
  }
  @Test(dataProvider = "testForSum")
  public void testSum(Basket b, double rez ) {
	assertEquals(b.Sum(),rez);
  }
  
  @DataProvider
  public Object[][] testForSortPriceUp() {
    ArrayList<Product> t = new ArrayList<Product>();
    t.add(Product_2);
    t.add(Product_1);
    t.add(Product_3);
    t.add(Product_0);
    	
    return new Object[][] {{B,t}};
    
  }
  
  @Test(dataProvider = "testForSortPriceUp")
  public void testSortPr(Basket b,  ArrayList<Product> r ) {
	assertEquals(b.sort_Upprice(),r);
  }
  /*************************************************/
  @DataProvider
  public Object[][] testForSortPriceDown() {
    ArrayList<Product> t = new ArrayList<Product>();
    t.add(Product_0);
    t.add(Product_3);
    t.add(Product_1);
    t.add(Product_2);
    	
    return new Object[][] {{B,t}};
    
  }
  
  @Test(dataProvider = "testForSortPriceDown")
  public void testSortPrDown(Basket b,  ArrayList<Product> r ) {
	assertEquals(b.sort_Downprice(),r);
  }

  
}
